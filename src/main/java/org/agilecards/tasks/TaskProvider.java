package org.agilecards.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Beewy on 14/03/2017.
 */
public class TaskProvider {

    private Map<String, AgileCardsTask> tasks;

    public TaskProvider() {
        this.tasks = new HashMap<>();
    }

    public AgileCardsTask getTask(String ref) {
        return this.tasks.get(ref);
    }

    public void registerTask(String ref, AgileCardsTask task) {
        this.tasks.put(ref, task);
    }
}
