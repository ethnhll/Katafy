package katafy;

import com.beust.jcommander.JCommander;
import katafy.cli.KataCommand;
import katafy.cli.KataFactory;
import katafy.cli.utils.JCommanderWrapper;

public class Main {

    private static final String PROGRAM_NAME = "Katafy";

    public static void main(String[] args) {
        JCommander.Builder builder = JCommander.newBuilder()
                .args(args)
                .programName(PROGRAM_NAME);
        KataFactory kataFactory = new KataFactory();
        kataFactory.createParameters()
                .forEach(builder::addObject);
        kataFactory.createCommands()
                .forEach(builder::addCommand);
        JCommander jCommander = builder.build();
        String parsedCommand = jCommander.getParsedCommand();
        if (parsedCommand == null) {
            jCommander.usage();
        } else {
            KataCommand kataCommand = new JCommanderWrapper().extractCommand(
                    jCommander,
                    parsedCommand,
                    KataCommand.class
            );
            if (kataCommand.shouldShowUsage()) {
                jCommander.usage(parsedCommand);
            } else {
                kataCommand.runKata();
            }
        }
    }
}

