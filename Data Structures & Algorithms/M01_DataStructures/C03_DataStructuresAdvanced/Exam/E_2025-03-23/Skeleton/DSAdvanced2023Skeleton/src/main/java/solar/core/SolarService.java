package solar.core;

import solar.models.*;

import java.util.Collection;

public interface SolarService {

    void addInverter(Inverter inverter);

    void addArray(Inverter inverter, String arrayId);

    void addPanel(Inverter inverter, String arrayId, PVModule pvModule);

    boolean containsInverter(String id);

    boolean isPanelConnected(PVModule pvModule);

    Inverter getInverterByPanel(PVModule pvModule);

    void replaceModule(PVModule oldModule, PVModule newModule);

    Collection<Inverter> getByProductionCapacity();

    Collection<Inverter> getByNumberOfPVModulesConnected();

    Collection<PVModule> getByWattProduction();
}
