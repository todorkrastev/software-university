package bg.manhattan.battleships.model.service;

public class ShipFireServiceModel {
    private Long attackerId;
    private Long defenderId;

    public Long getAttackerId() {
        return attackerId;
    }

    public ShipFireServiceModel setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public ShipFireServiceModel setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
