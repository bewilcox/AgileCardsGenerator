package org.agilecards.configuration;

import org.junit.Test;
import java.io.File;

import static org.junit.Assert.*;

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
   
        File file = new File(getClass().getClassLoader().getResource("agile-cards-v1.yml").getFile());

        ConfigurationFile configFile = ConfigurationFileReader.read(file);
        assertEquals(1, configFile.getVersion());
        
        // Test configuration for csv data provider
        //////////////////////////////////////////////////
        GeneratorConfig generatorConfig = configFile.getGeneratorConfig("config_avec_csv");
        assertNotNull("Config for config_avec_csv must be not null", generatorConfig);
        assertEquals("config_avec_csv", configFile.getName());        
        // Test DataProvider conf
        assertEquals("csv", configFile.getDataProvider().getType());
        assertEquals("dede.csv", configFile.getDataProvider().getProperty(AgileCardsConfiguration.PROP_DATA_FILE_PATH));
        assertEquals("true", configFile.getDataProvider().getProperty(AgileCardsConfiguration.PROP_HEADER));
        // Test Card Template
        assertEquals("story", configFile.getCardTemplate().getName());
        String[] mapping = configFile.getCardTemplate().getMapping();
        assertEquals(4, mapping.length());
        assertEquals("A1" , mapping[0]);
        assertEquals("B2", mapping[1]);
        assertEquals("C3", mapping[2]);
        assertEquals("D4", mapping[3]);
        
        // Test configuration for xls data provider
        //////////////////////////////////////////////////
        generatorConfig = configFile.getGeneratorConfig("config_avec_xlsx");
        assertNotNull("Config for config_avec_xlsx must be not null", generatorConfig);
        assertEquals("config_avec_xlsx", generatorConfig.getName());        
        // Test DataProvider conf
        assertEquals("xlsx", generatorConfig.getDataProvider().getType());
        assertEquals("dede.xlsx", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_DATA_FILE_PATH));
        assertEquals("false", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_HEADER));
        assertEquals("Backlog", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_SHEET_NAME));
        
        // Test configuration for xls data provider
        //////////////////////////////////////////////////
        generatorConfig = configFile.getGeneratorConfig("config_avec_rtc");
        assertNotNull("Config for config_avec_rtc must be not null", generatorConfig);
        assertEquals("config_avec_rtc", generatorConfig.getName());        
        // Test DataProvider conf
        assertEquals("rtc", generatorConfig.getDataProvider().getType());
        assertEquals("https://host:9393/jazz", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_JAZZ_SERVER_URL));
        assertEquals("mylogin", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_JAZZ_LOGIN));
        assertEquals("myproject", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_JAZZ_PROJECT_AREA));
        assertEquals("myquery", generatorConfig.getDataProvider().getProperty(AgileCardsConfiguration.PROP_JAZZ_QUERY_NAME));
        
    }
}