package org.agilecards.tasks;

import org.agilecards.exceptions.AgileCardsApplicationException;

/**
 * Created by Beewy on 14/03/2017.
 */
public interface AgileCardsTask {

    void execute() throws AgileCardsApplicationException;
}
