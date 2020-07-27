package katafy.cli;

import com.beust.jcommander.Parameter;

public class KataHelpParameter implements KataParameter {
    @Parameter(
            description = "Prints help display text",
            names = {"-h", "--help"},
            help = true,
            // ensure info is displayed last in usage for this parameter option
            order = Integer.MAX_VALUE
    )
    protected boolean help = false;

    @Override
    public boolean shouldShowUsage() {
        return this.help;
    }
}
