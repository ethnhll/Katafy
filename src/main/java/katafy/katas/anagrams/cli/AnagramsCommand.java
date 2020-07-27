package katafy.katas.anagrams.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.converters.FileConverter;
import katafy.cli.KataCommand;
import katafy.cli.validators.FileValidator;
import katafy.katas.anagrams.Anagrammer;
import katafy.katas.anagrams.Hashgrammer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Stream;

@Parameters(
        commandNames = "anagrams",
        commandDescription = "Print out all anagrams for words in a file."
)
public class AnagramsCommand extends KataCommand {

    @Parameter(
            description = "A file containing words (one word per line) to derive anagrams from",
            names = {"-f", "--word-file"},
            // TODO: use Path
            converter = FileConverter.class,
            validateValueWith = FileValidator.class,
            required = true,
            order = 0
    )
    private File file;

    @Parameter(
            description = "Word(s) to find anagrams for, example: --words cat dog",
            names = {"-w", "--words"},
            variableArity = true,
            order = 1
    )
    private List<String> words;

    @Override
    public void runKata() {
        try (Stream<String> streamOfWords = Files.lines(this.file.toPath())) {
            Anagrammer anagrammer = new Hashgrammer();
            // Add the words to the Anagrammer
            streamOfWords.map(String::toLowerCase).forEach(anagrammer::add);
            if (this.words == null) {
                // print all the anagrams
                anagrammer.words().stream()
                        .map(anagrammer::anagrams)
                        .forEach(System.out::println);
            } else {
                this.words.forEach(word -> System.out.println(anagrammer.anagrams(word)));
            }
        } catch (IOException e) {
            // TODO: replace with console logging
            e.printStackTrace();
        }
    }
}
