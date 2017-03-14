package org.agilecards.cli;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.agilecards.tasks.*;

/**
 * Created by Beewy on 12/03/2017.
 */
public abstract class BaseManager {

    private final AgileCardsConfiguration applicationConfiguration;
    private TaskProvider taskProvider;

    public BaseManager() {
        this.applicationConfiguration = new AgileCardsConfiguration();
        this.registerTasks();
    }

    public TaskProvider getTaskProvider() {
        return taskProvider;
    }

    public AgileCardsConfiguration getApplicationConfiguration() {
        return applicationConfiguration;
    }

    private void registerTasks() {
        this.taskProvider = new TaskProvider();
        // Version task
        this.taskProvider.registerTask(AgileCardsConfiguration.VERSION_ACTION, new VersionTask());
        // init task
        this.taskProvider.registerTask(AgileCardsConfiguration.INIT_ACTION, new InitTask());
        // blank task
        this.taskProvider.registerTask(AgileCardsConfiguration.BLANK_ACTION, new BlankTask());
        // generate task
        this.taskProvider.registerTask(AgileCardsConfiguration.GENERATE_ACTION, new GenerateTask());
    }
}
