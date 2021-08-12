package manager;

import dump.DumpImpl;
import interfaces.Dump;
import interfaces.InputReader;
import interfaces.OutputWriter;
import reactor.Heavy;
import reactor.Power;
import interfaces.Repository;
import repository.RepositoryImpl;
import software.Express;
import software.Light;
import software.SoftwareImpl;

public class MyManager {

    private final InputReader reader;
    private final OutputWriter writer;
    private final Repository reactorInfo;
    private final Dump dumpInfo;

    public MyManager() {
        this.reactorInfo = new RepositoryImpl();
        this.reader = new InputManager();
        this.writer = new OutputManager();
        this.dumpInfo = new DumpImpl();
    }

    public void run() {

        while (true) {

            String reactorName, softwareName;
            int capacity, memory, capacityConsumption, memoryConsumption;
            String command = reader.readLine().trim();

            if (command.startsWith("RegisterPowerHardware")) {

                String[] input = splitCommand(command);
                reactorName = input[0];
                capacity = Integer.parseInt(input[1]);
                memory = Integer.parseInt(input[2]);
                reactorInfo.getRepository().put(reactorName, new Power(reactorName, capacity, memory));

            } else if (command.startsWith("RegisterHeavyHardware")) {

                String[] input = splitCommand(command);
                reactorName = input[0];
                capacity = Integer.parseInt(input[1]);
                memory = Integer.parseInt(input[2]);
                reactorInfo.getRepository().put(reactorName, new Heavy(reactorName, capacity, memory));

            } else if (command.startsWith("RegisterExpressSoftware")) {

                String[] input = splitCommand(command);
                reactorName = input[0];

                if (reactorInfo.getRepository().containsKey(reactorName)) {

                    softwareName = input[1];
                    capacityConsumption = Integer.parseInt(input[2]);
                    memoryConsumption = Integer.parseInt(input[3]);

                    SoftwareImpl software = new Express(softwareName, capacityConsumption, memoryConsumption);
                    capacityConsumption = software.getCapacityConsumption();
                    memoryConsumption = software.getMemoryConsumption();

                    if (hasEnoughCapacity(reactorName, capacityConsumption)
                            && hasEnoughMemory(reactorName, memoryConsumption)) {
                        reactorInfo.getRepository().get(reactorName)
                                .add(software);
                    }
                }

            } else if (command.startsWith("RegisterLightSoftware")) {

                String[] input = splitCommand(command);
                reactorName = input[0];

                if (reactorInfo.getRepository().containsKey(reactorName)) {
                    softwareName = input[1];
                    capacityConsumption = Integer.parseInt(input[2]);
                    memoryConsumption = Integer.parseInt(input[3]);

                    SoftwareImpl software = new Light(softwareName, capacityConsumption, memoryConsumption);
                    capacityConsumption = software.getCapacityConsumption();
                    memoryConsumption = software.getMemoryConsumption();

                    if (hasEnoughCapacity(reactorName, capacityConsumption)
                            && hasEnoughMemory(reactorName, memoryConsumption)) {
                        reactorInfo.getRepository().get(reactorName)
                                .add(software);
                    }
                }

            } else if (command.startsWith("Release")) {

                String[] input = splitCommand(command);
                String hardware = input[0];
                String software = input[1];
                reactorInfo.release(hardware, software);

            } else if (command.startsWith("Analyze")) {

                writer.write(reactorInfo.analyze());

            } else if (command.startsWith("System")) {

                writer.write(reactorInfo.finalizes());
                return;
            } else if(command.split("\\(")[0].equals("Dump")){

                reactorName = splitCommand(command)[0];

                if(reactorInfo.getRepository().containsKey(reactorName)){
                    dumpInfo.dump(reactorName,reactorInfo.getRepository().remove(reactorName));
                }

            } else if(command.startsWith("Restore")){

                reactorName = splitCommand(command)[0];

                if(dumpInfo.getDumpRepository().containsKey(reactorName)){
                    reactorInfo.getRepository().put(reactorName,dumpInfo.restore(reactorName));
                }

            } else if(command.startsWith("Destroy")){

                dumpInfo.destroy(splitCommand(command)[0]);

            }else if(command.startsWith("DumpAnalyze")){

                writer.write(dumpInfo.analyze());
            }
        }
    }

    private boolean hasEnoughMemory(String reactorName, int memoryConsumption) {
        int memory = reactorInfo.getRepository().get(reactorName).getMaximumMemory();
        int usedMemory = reactorInfo.getRepository().get(reactorName).memoryUsed();
        return usedMemory + memoryConsumption <= memory;
    }

    private boolean hasEnoughCapacity(String reactorName, int capacityConsumption) {
        int capacity = reactorInfo.getRepository().get(reactorName).getMaximumCapacity();
        int usedCapacity = reactorInfo.getRepository().get(reactorName).capacityUsed();
        return usedCapacity + capacityConsumption <= capacity;
    }

    private String[] splitCommand(String command) {
        return command.substring(command.indexOf('(') + 1, command.indexOf(')')).split(", ");
    }
}
