package CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

public class GunRepository extends RepositoryImpl<Gun> {
    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        super.getModels().add(model);
    }

    @Override
    public Gun findByName(String name) {
        return this.getModels().stream().filter(gun -> gun.getName().equals(name)).findFirst().orElse(null);
    }
}
