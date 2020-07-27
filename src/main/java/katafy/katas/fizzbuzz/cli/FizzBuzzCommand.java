package katafy.katas.fizzbuzz.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import katafy.cli.KataCommand;
import katafy.katas.fizzbuzz.DeciBuzzer;
import katafy.katas.fizzbuzz.FizzBuzzer;

import java.util.List;

@Parameters(
        commandNames = "fizzbuzz",
        commandDescription = "Print out fizz if a number is divisible by three, buzz if it's divisible by 5, " +
                "fizzbuzz if divisible by both 3 and 5, or just the number if none of those are true."
)
public class FizzBuzzCommand extends KataCommand {

    @Parameter(
            description = "Numbers(s) to do fizzbuzz with, example: --numbers 1000 42",
            names = {"-n", "--numbers"},
            variableArity = true,
            required = true,
            order = 1
    )
    private List<String> numbers;

    @Override
    public void runKata() {
        FizzBuzzer fizzBuzzer = new DeciBuzzer();
        this.numbers.forEach(number -> System.out.println(fizzBuzzer.fizzBuzz(number)));
    }
}
