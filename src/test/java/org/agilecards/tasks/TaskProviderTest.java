package org.agilecards.tasks;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Beewy on 14/03/2017.
 */
public class TaskProviderTest {

    public TaskProvider taskProvider;

    @Before
    public void setUp() throws Exception {
        this.taskProvider = new TaskProvider();
    }

    @Test
    public void registerAndGetTask() throws Exception {
        AgileCardsTask registeredTask = new VersionTask();
        this.taskProvider.registerTask("test",registeredTask);
        AgileCardsTask task = this.taskProvider.getTask("test");

        assertEquals(registeredTask,task);

    }

}