package interfaces;

import interfaces.Reactor;

import java.util.Map;

public interface Repository {

    Map<String, Reactor> getRepository();

    void release(String hardware ,String software);

    String analyze();

    String finalizes();
}
