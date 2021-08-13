package core.factories.interfaces;

import exceptions.ArgumentException;
import models.engines.Engine;

public interface EngineFactory {
    Engine produce(String[] args) throws ArgumentException;
}
