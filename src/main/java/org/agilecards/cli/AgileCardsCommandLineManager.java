package org.agilecards.cli;

import org.agilecards.exceptions.AgileCardsApplicationException;
import org.agilecards.exceptions.AgileCardsException;
import org.agilecards.exceptions.AgileCardsParsingException;

/**
 * Created by Beewy on 25/02/2017.
 */
public interface AgileCardsCommandLineManager {

    void showUsage();

    void handleCLICommands(String[] args) throws AgileCardsParsingException;

    boolean isVerboseActivated();

    boolean isHelp();

    void executeAction() throws AgileCardsApplicationException;

}
