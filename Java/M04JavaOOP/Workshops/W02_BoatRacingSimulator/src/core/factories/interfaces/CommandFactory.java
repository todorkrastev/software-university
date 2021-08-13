package core.factories.interfaces;

import core.commands.interfaces.Command;

public interface CommandFactory {
    Command produce(String type);
}
