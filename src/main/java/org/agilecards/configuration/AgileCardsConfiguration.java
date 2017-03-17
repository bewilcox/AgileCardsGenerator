package org.agilecards.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Beewy on 25/02/2017.
 */
public class AgileCardsConfiguration {

    //Logs
    private static final Logger LOG = LoggerFactory.getLogger(AgileCardsConfiguration.class);

    // Constants for CLI
    public static final String APP_NAME ="agile-cards";
    public static final String GENERATE_ACTION = "generate";
    public static final String GENERATE_USAGE = "Generate the agile cards";
    public static final String BLANK_ACTION = "blank";
    public static final String BLANK_USAGE = "Generate blank cards";
    public static final String INIT_ACTION = "init";
    public static final String INIT_USAGE = "Init the configuration and template files";
    public static final String VERSION_ACTION = "version";
    public static final String VERSION_USAGE = "Show the application version";

    // Constants for Configuration File
    public static final String PROP_DATA_FILE_PATH ="data_file";
    public static final String PROP_HEADER ="header";
    public static final String PROP_SHEET_NAME ="sheet_name";
    public static final String PROP_JAZZ_SERVER_URL ="jazz_server_url";
    public static final String PROP_JAZZ_LOGIN ="jazz_login";
    public static final String PROP_JAZZ_PROJECT_AREA ="project_area";
    public static final String PROP_JAZZ_QUERY_NAME ="query_name";

    // Others
    private String applicationVersion;


    // Config Initialization

    public AgileCardsConfiguration() {
        //get the property value and print it out
        this.applicationVersion =  AgileCardsConfiguration.class.getPackage().getImplementationVersion();
    }


    //Manage configuration file

    public String getApplicationVersion() {
        return applicationVersion;
    }
}
