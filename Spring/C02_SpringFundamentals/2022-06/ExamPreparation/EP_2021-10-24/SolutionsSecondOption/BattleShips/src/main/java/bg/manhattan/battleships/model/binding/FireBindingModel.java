package bg.manhattan.battleships.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FireBindingModel {
    @NotNull
    @Positive
    private Long attackerId;

    @NotNull
    @Positive
    private Long defenderId;

    public Long getAttackerId() {
        return attackerId;
    }

    public FireBindingModel setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public FireBindingModel setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
