package org.agilecards.cli;

import org.agilecards.exceptions.AgileCardsException;

/**
 * Created by Beewy on 25/02/2017.
 */
public interface AgileCardsCommandLineManager {

    void showUsage();

    void handleCLICommands(String[] args) throws AgileCardsException;

    boolean isVerboseActivated();

    boolean isHelp();

    void executeAction();

}
