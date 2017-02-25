package org.agilecards.cli.actions;

import org.kohsuke.args4j.Option;

/**
 * Created by Beewy on 25/02/2017.
 */
public abstract class AgileCardsAction {

    @Option(name = "--help", usage = "Show usage", aliases = "-H", help = true, hidden = true)
    private boolean help;

    public boolean isHelp() {
        return help;
    }

}
