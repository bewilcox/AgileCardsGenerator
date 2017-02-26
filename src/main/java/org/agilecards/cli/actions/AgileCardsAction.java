package org.agilecards.cli.actions;

import org.kohsuke.args4j.Option;

/**
 * Created by Beewy on 25/02/2017.
 */
public abstract class AgileCardsAction {

    @Option(name = "--help", usage = "Show specific usage", aliases = "-H", help = true, hidden = false)
    private boolean help;

    public abstract void showSpecificUsage();

    public boolean isHelp() {
        return help;
    }

}
