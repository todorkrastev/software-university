package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase{
    private Collection<String> exhibits;

    public Carton() {
        this.setExhibits();
    }

    private void setExhibits() {
        this.exhibits = new ArrayList<>();
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }
}
