package org.agilecards.configuration;

import org.agilecards.configuration.file.ConfigurationFile;
import org.agilecards.configuration.file.ConfigurationFileReader;
import org.agilecards.configuration.file.GeneratorConfig;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for the configuration.
 * Created by Beewy on 05/03/2017.
 */
public class AgileCardsConfigurationTest
{
    @Test
    public void testGenerateAction_NameAndUsage() throws Exception {
        assertEquals("generate",AgileCardsConfiguration.GENERATE_ACTION);
        assertEquals("Generate the agile cards",AgileCardsConfiguration.GENERATE_USAGE);
    }

    @Test
    public void testVersionAction_NameAndUsage() throws Exception {
        assertEquals("version",AgileCardsConfiguration.VERSION_ACTION);
        assertEquals("Show the application version",AgileCardsConfiguration.VERSION_USAGE);
    }

    @Test
    public void testInitAction_NameAndUsage() throws Exception {
        assertEquals("init",AgileCardsConfiguration.INIT_ACTION);
        assertEquals("Init the configuration and template files",AgileCardsConfiguration.INIT_USAGE);
    }

    @Test
    public void testBlankAction_NameAndUsage() throws Exception {
        assertEquals("blank",AgileCardsConfiguration.BLANK_ACTION);
        assertEquals("Generate blank cards",AgileCardsConfiguration.BLANK_USAGE);
    }
    
    @Test
    public void testPropertiesConstants() throws Exception {
        assertEquals("type",AgileCardsConfiguration.PROP_TYPE);
        assertEquals("data_file",AgileCardsConfiguration.PROP_DATA_FILE_PATH);
        assertEquals("header",AgileCardsConfiguration.PROP_HEADER);
        assertEquals("sheet_name",AgileCardsConfiguration.PROP_SHEET_NAME);
        assertEquals("jazz_server_url",AgileCardsConfiguration.PROP_JAZZ_SERVER_URL);
        assertEquals("jazz_user",AgileCardsConfiguration.PROP_JAZZ_LOGIN);
        assertEquals("project_area",AgileCardsConfiguration.PROP_JAZZ_PROJECT_AREA);
        assertEquals("query_name",AgileCardsConfiguration.PROP_JAZZ_QUERY_NAME);
    }
    
    @Test
    public void testLoadConfigurationFile_version1() throws Exception {
   
        //File file = new File(getClass().getClassLoader().getResource("agile-cards-v1.yml").getFile());

        ConfigurationFile configFile = ConfigurationFileReader.read(getClass().getClassLoader().getResourceAsStream("agile-cards-v1.yml"));
        assertEquals(1, configFile.getVersion());
        
        // Test configuration for csv data provider
        //////////////////////////////////////////////////
        Optional<GeneratorConfig> generatorConfig = configFile.getGeneratorConfig("config_avec_csv");
        assertTrue("Config for config_avec_csv must be not null", generatorConfig.isPresent());
        assertEquals("config_avec_csv", generatorConfig.get().getName());
        // Test DataProvider conf
        assertEquals("csv", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_TYPE));
        assertEquals("dede.csv", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_DATA_FILE_PATH));
        assertEquals("true", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_HEADER));
        // Test Card Template
        assertEquals("story", generatorConfig.get().getCardTemplate().getName());
        String[] mapping = generatorConfig.get().getCardTemplate().getMapping();
        assertEquals(4, mapping.length);
        assertEquals("A1" , mapping[0]);
        assertEquals("B2", mapping[1]);
        assertEquals("C3", mapping[2]);
        assertEquals("D4", mapping[3]);

        // Test configuration for xls data provider
        //////////////////////////////////////////////////
        generatorConfig = configFile.getGeneratorConfig("config_avec_xlsx");
        assertTrue("Config for config_avec_xlsx must be not null", generatorConfig.isPresent());
        assertEquals("config_avec_xlsx", generatorConfig.get().getName());
        // Test DataProvider conf
        assertEquals("xlsx", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_TYPE));
        assertEquals("dede.xlsx", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_DATA_FILE_PATH));
        assertEquals("false", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_HEADER));
        assertEquals("Backlog", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_SHEET_NAME));

        // Test configuration for xls data provider
        //////////////////////////////////////////////////
        generatorConfig = configFile.getGeneratorConfig("config_avec_rtc");
        assertTrue("Config for config_avec_rtc must be not null", generatorConfig.isPresent());
        assertEquals("config_avec_rtc", generatorConfig.get().getName());
        // Test DataProvider conf
        assertEquals("rtc", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_TYPE));
        assertEquals("https://host:9393/jazz", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_JAZZ_SERVER_URL));
        assertEquals("mylogin", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_JAZZ_LOGIN));
        assertEquals("myproject", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_JAZZ_PROJECT_AREA));
        assertEquals("myquery", generatorConfig.get().getDataProvider().get(AgileCardsConfiguration.PROP_JAZZ_QUERY_NAME));

    }
}