package restaurant.repositories;

import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.TableRepository;

public class TableRepositoryImpl extends RepositoryImpl<Table> implements TableRepository<Table> {
    @Override
    public Table byNumber(int number) {
        return super.getAllEntities().stream()
                .filter(t -> t.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
