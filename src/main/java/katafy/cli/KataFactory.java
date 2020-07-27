package katafy.cli;

import katafy.katas.anagrams.cli.AnagramsCommand;

import java.util.Collections;
import java.util.List;

public class KataFactory {
    public List<? extends KataCommand> createCommands() {
        return Collections.unmodifiableList(
                Collections.singletonList(
                        new AnagramsCommand()
                )
        );
    }

    public List<? extends KataParameter> createParameters() {
        return Collections.singletonList(
                new KataHelpParameter()
        );
    }
}
