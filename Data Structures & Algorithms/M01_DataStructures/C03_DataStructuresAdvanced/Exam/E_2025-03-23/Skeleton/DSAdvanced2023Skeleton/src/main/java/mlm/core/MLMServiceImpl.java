package mlm.core;

import mlm.models.Seller;

import java.util.*;
import java.util.stream.Collectors;

public class MLMServiceImpl implements MLMService {
    private final Map<String, Seller> sellerIdToSeller;
    private final Map<String, Seller> sellerIdToParent;
    private final Map<String, Set<Seller>> parentIdToHires;
    private final Map<String, Integer> sellerIdToSalesMade;

    public MLMServiceImpl() {
        sellerIdToSeller = new LinkedHashMap<>();
        sellerIdToParent = new HashMap<>();
        parentIdToHires = new HashMap<>();
        sellerIdToSalesMade = new HashMap<>();
    }

    @Override
    public void addSeller(Seller seller) {
        if (exists(seller)) {
            throw new IllegalArgumentException();
        }

        sellerIdToSeller.put(seller.id, seller);
        sellerIdToParent.put(seller.id, null);
        parentIdToHires.put(seller.id, new HashSet<>());
        sellerIdToSalesMade.put(seller.id, 0);
    }

    @Override
    public void hireSeller(Seller parent, Seller newHire) {
        if (!exists(parent)) {
            throw new IllegalArgumentException();
        }

        addSeller(newHire);
        sellerIdToParent.put(newHire.id, parent);
        parentIdToHires.get(parent.id).add(newHire);
    }

    @Override
    public boolean exists(Seller seller) {
        return sellerIdToSeller.containsKey(seller.id);
    }

    @Override
    public void fire(Seller seller) {
        if (!exists(seller)) {
            throw new IllegalArgumentException();
        }

        Seller parent = sellerIdToParent.get(seller.id);
        Set<Seller> hires = parentIdToHires.getOrDefault(seller.id, new HashSet<>());

        if (parent != null) {
            parentIdToHires.get(parent.id).addAll(hires);
        }

        hires.forEach(hire -> sellerIdToParent.put(hire.id, parent));

        sellerIdToSeller.remove(seller.id);
        sellerIdToSalesMade.remove(seller.id);
    }

    @Override
    public void makeSale(Seller seller, int amount) {
        int initialAmount = amount;
        Seller parent = sellerIdToParent.get(seller.id);

        while (parent != null) {
            parent.earnings += initialAmount * 0.05;
            amount -= initialAmount * 0.05;

            parent = sellerIdToParent.get(parent.id);
        }

        seller.earnings += amount;

        Integer count = sellerIdToSalesMade.get(seller.id);
        sellerIdToSalesMade.put(seller.id, count == null ? 1 : count + 1);
    }

    @Override
    public Collection<Seller> getByProfits() {
        return sellerIdToSeller.values()
                .stream()
                .sorted((l, r) -> r.earnings - l.earnings)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Seller> getByEmployeeCount() {
        return sellerIdToSeller.values()
                .stream()
                .sorted((l, r) -> getEmployeeCount(r) - getEmployeeCount(l))
                .collect(Collectors.toList());
    }

    private int getEmployeeCount(Seller s) {
        Set<Seller> initial = parentIdToHires.getOrDefault(s.id, new HashSet<>());
        List<Seller> hires = new ArrayList<>(initial);

        int totalEmployees = 0;

        for (int i = 0; i < hires.size(); i++) {
            totalEmployees++;

            Set<Seller> orDefault = parentIdToHires.getOrDefault(hires.get(i).id, new HashSet<>());

            hires.addAll(orDefault);
        }

        return totalEmployees;
    }

    @Override
    public Collection<Seller> getByTotalSalesMade() {
        return sellerIdToSalesMade.entrySet()
                .stream()
                .sorted((l, r) -> Integer.compare(r.getValue(), l.getValue()))
                .map(Map.Entry::getKey)
                .map(sellerIdToSeller::get)
                .collect(Collectors.toList());
    }
}
