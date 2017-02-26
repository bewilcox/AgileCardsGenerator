package org.agilecards.cli;

/**
 * Created by Beewy on 25/02/2017.
 */
public interface AgileCardsCommandLineManager {

    void showUsage();

    void handleCLICommands(String[] args);

    boolean isVerboseActivated();

    boolean isHelp();

    void executeAction();
}
