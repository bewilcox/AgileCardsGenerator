package org.agilecards.configuration.file;

/**
 * Created by Beewy on 18/03/2017.
 */
public class CardTemplate {

    private String name;
    private String[] mapping;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMapping() {
        return mapping;
    }

    public void setMapping(String[] mapping) {
        this.mapping = mapping;
    }
}
