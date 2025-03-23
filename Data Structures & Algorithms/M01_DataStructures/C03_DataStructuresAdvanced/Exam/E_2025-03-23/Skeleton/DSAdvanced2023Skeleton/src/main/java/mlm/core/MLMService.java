package mlm.core;

import mlm.models.Seller;

import java.util.Collection;

public interface MLMService {
    void addSeller(Seller seller);
    void hireSeller(Seller parent, Seller newHire);
    boolean exists(Seller seller);
    void fire(Seller seller);
    void makeSale(Seller seller, int amount);
    Collection<Seller> getByProfits();
    Collection<Seller> getByEmployeeCount();
    Collection<Seller> getByTotalSalesMade();
}
