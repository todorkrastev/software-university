package mlm.core;

import mlm.models.Seller;

import java.util.*;

public class MLMServiceImpl implements MLMService {
    private final Map<String, Seller> sellers;
    private final Map<String, Set<String>> hireMap;
    private final Map<String, Integer> salesCount;
    private final Map<String, String> parentMap;
    private final Map<String, Integer> totalHiresCache;

    public MLMServiceImpl() {
        sellers = new HashMap<>();
        hireMap = new HashMap<>();
        salesCount = new HashMap<>();
        parentMap = new HashMap<>();
        totalHiresCache = new HashMap<>();
    }

    @Override
    public void addSeller(Seller seller) {
        if (sellers.containsKey(seller.id)) {
            throw new IllegalArgumentException("Seller already exists");
        }

        sellers.put(seller.id, seller);
        hireMap.put(seller.id, new HashSet<>());
        salesCount.put(seller.id, 0);
        totalHiresCache.clear();
    }

    @Override
    public void hireSeller(Seller parent, Seller newHire) {
        if (!sellers.containsKey(parent.id) || sellers.containsKey(newHire.id)) {
            throw new IllegalArgumentException("Invalid parent or newHire");
        }

        sellers.put(newHire.id, newHire);
        hireMap.get(parent.id).add(newHire.id);
        parentMap.put(newHire.id, parent.id);
        hireMap.put(newHire.id, new HashSet<>());
        salesCount.put(newHire.id, 0);
        totalHiresCache.clear();
    }

    @Override
    public boolean exists(Seller seller) {
        return sellers.containsKey(seller.id);
    }

    @Override
    public void fire(Seller seller) {
        if (!sellers.containsKey(seller.id)) {
            throw new IllegalArgumentException("Seller does not exist");
        }

        String parentId = parentMap.get(seller.id);
        if (parentId != null) {
            Set<String> hires = hireMap.get(seller.id);
            for (String hireId : hires) {
                parentMap.put(hireId, parentId);
                hireMap.get(parentId).add(hireId);
            }
        }

        sellers.remove(seller.id);
        hireMap.remove(seller.id);
        parentMap.remove(seller.id);
        salesCount.remove(seller.id);
        totalHiresCache.clear();
    }

    @Override
    public void makeSale(Seller seller, int amount) {
        int commission = amount / 20;
        int remainingAmount = amount;
        String currentId = seller.id;

        List<String> hierarchyPath = getHierarchyPath(currentId);
        for (String parentId : hierarchyPath) {
            sellers.get(parentId).earnings += commission;
            remainingAmount -= commission;
        }

        seller.earnings += remainingAmount;
        salesCount.put(seller.id, salesCount.get(seller.id) + 1);
    }

    private List<String> getHierarchyPath(String sellerId) {
        List<String> path = new ArrayList<>();
        String currentId = sellerId;
        while (parentMap.containsKey(currentId)) {
            String parentId = parentMap.get(currentId);
            path.add(parentId);
            currentId = parentId;
        }
        return path;
    }

    @Override
    public Collection<Seller> getByProfits() {
        List<Seller> sortedSellers = new ArrayList<>(sellers.values());
        sortedSellers.sort(Comparator.comparingInt(s -> -s.earnings));

        return sortedSellers;
    }

    @Override
    public Collection<Seller> getByEmployeeCount() {
        List<Seller> sortedSellers = new ArrayList<>(sellers.values());
        sortedSellers.sort(Comparator.comparingInt((Seller s) -> getTotalHires(s.id)).reversed()
                .thenComparing(s -> new ArrayList<>(sellers.keySet()).indexOf(s.id)));

        return sortedSellers;
    }

    @Override
    public Collection<Seller> getByTotalSalesMade() {
        List<Seller> sortedSellers = new ArrayList<>(sellers.values());
        sortedSellers.sort(Comparator.comparingInt((Seller s) -> salesCount.get(s.id)).reversed());

        return sortedSellers;
    }

    private int getTotalHires(String sellerId) {
        if (totalHiresCache.containsKey(sellerId)) {
            return totalHiresCache.get(sellerId);
        }

        Set<String> hires = hireMap.get(sellerId);
        int totalHires = hires.size();
        for (String hireId : hires) {
            totalHires += getTotalHires(hireId);
        }

        totalHiresCache.put(sellerId, totalHires);
        return totalHires;
    }
}