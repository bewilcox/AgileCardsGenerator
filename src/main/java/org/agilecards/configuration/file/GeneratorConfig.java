package org.agilecards.configuration.file;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class GeneratorConfig {

    private String name;

    @JsonProperty("data_provider")
    private Map<String, String> dataProvider;

    @JsonProperty("card_template")
    private CardTemplate cardTemplate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(Map<String, String> dataProvider) {
        this.dataProvider = dataProvider;
    }

    public CardTemplate getCardTemplate() {
        return cardTemplate;
    }

    public void setCardTemplate(CardTemplate cardTemplate) {
        this.cardTemplate = cardTemplate;
    }
}
