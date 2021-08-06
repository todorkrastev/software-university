package bankSafe;

import javax.naming.OperationNotSupportedException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class BankVault {
    private Map<String, Item> vaultCells;

    public BankVault() {
        this.vaultCells = new LinkedHashMap<>();
        this.vaultCells.put("A1", null);
        this.vaultCells.put("A2", null);
        this.vaultCells.put("A3", null);
        this.vaultCells.put("A4", null);
        this.vaultCells.put("B1", null);
        this.vaultCells.put("B2", null);
        this.vaultCells.put("B3", null);
        this.vaultCells.put("B4", null);
        this.vaultCells.put("C1", null);
        this.vaultCells.put("C2", null);
        this.vaultCells.put("C3", null);
        this.vaultCells.put("C4", null);
    }

    public Map<String, Item> getVaultCells() {
        return Collections.unmodifiableMap(this.vaultCells);
    }

    public String addItem(String cell, Item item) throws OperationNotSupportedException, IllegalArgumentException{
        if (!this.vaultCells.containsKey(cell)) {
            throw new IllegalArgumentException("Cell doesn't exist!");
        }

        if (this.vaultCells.get(cell) != null) {
            throw new IllegalArgumentException("Cell is already taken!");
        }

        boolean itemExist = getVaultCells().containsValue(item);

        if (itemExist) {
            throw new OperationNotSupportedException("Item is already in cell");
        }

        vaultCells.put(cell, item);
        return String.format("Item:%s saved successfully!", item.getItemId());
    }

    public String removeItem(String cell, Item item) {
        if (!this.vaultCells.containsKey(cell)) {
            throw new IllegalArgumentException("Cell doesn't exists!");
        }

        if (this.vaultCells.get(cell) != item) {
            throw new IllegalArgumentException("Item in that cell doesn't exists!");
        }

        this.vaultCells.put(cell, null);

        return String.format("Remove item:%s successfully!", item.getItemId());
    }
}
