package katafy.cli;

public abstract class KataCommand extends KataHelpParameter implements KataRunner {
    public abstract void runKata();
}
