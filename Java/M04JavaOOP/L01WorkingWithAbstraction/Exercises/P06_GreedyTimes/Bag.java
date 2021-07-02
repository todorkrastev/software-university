package bg.softuni.java_oop.working_with_abstraction.exercises.P06_GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private final long capacity;
    private long currentCapacity;
    private Long gold;
    private final Map<String, Long> gems;
    private final Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.currentCapacity = 0;
        this.gems = new HashMap<>();
        this.cash = new HashMap<>();
    }

    public void addGold(long quantity) {
        if (hasCapacity(quantity)) {
            gold = gold == null ? quantity : gold + quantity;
            this.currentCapacity += quantity;
        }
    }

    public void addGem(String item, long quantity) {
        if (gold != null && getSum(gems) + quantity <= gold && hasCapacity(quantity)) {
            gems.put(item, !gems.containsKey(item) ? quantity : gems.get(item) + quantity);
            this.currentCapacity += quantity;
        }
    }

    public void addCash(String item, long quantity) {
        if (getSum(cash) + quantity <= getSum(gems) && hasCapacity(quantity)) {
            cash.put(item, !cash.containsKey(item) ? quantity : cash.get(item) + quantity);
            this.currentCapacity += quantity;
        }
    }

    private boolean hasCapacity(long quantity) {
        return currentCapacity + quantity <= capacity;
    }

    private long getSum(Map<String, Long> map) {
        return map.values().stream().mapToLong(e -> e).sum();
    }


    public String ordered() {
        StringBuilder output = new StringBuilder();
        if (gold != null) {
            output.append(String.format("<Gold> $%d%n##Gold - %d%n", gold, gold));
        }
        if (!gems.isEmpty()) {
            output.append(String.format("<Gem> $%d%n", getSum(gems)));
            gems.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                    .forEach(e -> output.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
        }
        if (!cash.isEmpty()) {
            output.append(String.format("<Cash> $%d%n", getSum(cash)));
            cash.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByKey().reversed())
                    .forEach(e -> output.append(String.format("##%s - %d%n", e.getKey(), e.getValue())));
        }
        return output.toString().trim();
    }
}
