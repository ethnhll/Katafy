package katafy.cli.utils;

import com.beust.jcommander.JCommander;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class JCommanderWrapper {
    private <T> T mapToClass(Class<T> clazz, Object object) {
        return object.getClass().asSubclass(clazz).cast(object);
    }

    public <T> T extractCommand(JCommander jCommander, String commandName, Class<T> commandClazz) {
        Map<String, T> commands = jCommander.getCommands().entrySet().stream()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        entry -> this.mapToClass(
                                                commandClazz,
                                                // at this point, the only "object" is a single command
                                                entry.getValue().getObjects().get(0)
                                        )
                                ),
                                Collections::unmodifiableMap
                        )
                );
        return commands.get(commandName);
    }
}
