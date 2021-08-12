package interfaces;

import software.SoftwareImpl;

import java.util.List;

public interface Reactor {

    List<SoftwareImpl> getSoftware();

    void add(SoftwareImpl software);

    void remove(SoftwareImpl software);

    String getName();

    int getMaximumCapacity();

    int getMaximumMemory();

    int memoryUsed();

    int capacityUsed();

}
