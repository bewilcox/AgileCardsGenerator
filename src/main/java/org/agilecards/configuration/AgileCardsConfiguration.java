package org.agilecards.configuration;

import org.agilecards.configuration.file.ConfigurationFile;
import org.agilecards.configuration.file.ConfigurationFileReader;
import org.agilecards.exceptions.AgileCardsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


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
    public static final String PROP_TYPE ="type";
    public static final String PROP_DATA_FILE_PATH ="data_file";
    public static final String PROP_HEADER ="header";
    public static final String PROP_SHEET_NAME ="sheet_name";
    public static final String PROP_JAZZ_SERVER_URL ="jazz_server_url";
    public static final String PROP_JAZZ_LOGIN ="jazz_user";
    public static final String PROP_JAZZ_PROJECT_AREA ="project_area";
    public static final String PROP_JAZZ_QUERY_NAME ="query_name";


    // Config Initialization
    public AgileCardsConfiguration() {
        try {
            this.loadConfigurationFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgileCardsException e) {
            e.printStackTrace();
        }
    }


    //Manage configuration file
    private void loadConfigurationFile() throws IOException, AgileCardsException {
        Path file = Paths.get("./agile-cards.yml");
        if (Files.isReadable(file)) {
            ConfigurationFile configFile = ConfigurationFileReader.read(Files.newInputStream(file, StandardOpenOption.READ));
            LOG.info("Configuration file version {}",configFile.getVersion());
        } else {
            LOG.error("The configuration file agile-cards.yml was not found. See the init command to recreate it.");
            System.exit(1);
        }
    }

    public static String getApplicationVersion() {
        return AgileCardsConfiguration.class.getPackage().getImplementationVersion();
    }
}
