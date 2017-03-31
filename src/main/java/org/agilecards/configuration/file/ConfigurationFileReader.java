package org.agilecards.configuration.file;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.agilecards.configuration.AgileCardsConfiguration;
import org.agilecards.exceptions.AgileCardsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class ConfigurationFileReader {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationFileReader.class);

//    /**
//     * Read the configuration file.
//     * @param file
//     * @return
//     * @throws AgileCardsException
//     */
//    public static ConfigurationFile read(File file) throws AgileCardsException {
//
//        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
//
//        try {
//            JsonNode node = mapper.readTree(file);
//            int version = node.get("version").asInt();
//
//            if (isKnownVersion(version)) {
//                ConfigurationFile configurationFile =  mapper.readValue(file, ConfigurationFile.class);
//                return configurationFile;
//            } else {
//                LOG.error("An error occurred while loading the configuration file");
//                LOG.error("The agile-cards {}, can't read the configuration file in this version : {}",
//                        AgileCardsConfiguration.getApplicationVersion(),
//                        version);
//                throw new AgileCardsException();
//            }
//
//        } catch (Exception e) {
//            LOG.error("Unable to read the configuration file : {}",file.getName());
//            LOG.error(e.getMessage());
//            throw new AgileCardsException();
//        }
//
//    }

    /**
     * Read the configuration file.
     * @param input
     * @return
     * @throws AgileCardsException
     */
    public static ConfigurationFile read(InputStream input) throws AgileCardsException {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            JsonNode node = mapper.readTree(input);
            int version = node.get("version").asInt();

            if (isKnownVersion(version)) {
                ConfigurationFile configurationFile =  mapper.readValue(input, ConfigurationFile.class);
                return configurationFile;
            } else {
                LOG.error("An error occurred while loading the configuration file");
                LOG.error("The agile-cards {}, can't read the configuration file in this version : {}",
                        AgileCardsConfiguration.getApplicationVersion(),
                        version);
                throw new AgileCardsException();
            }

        } catch (Exception e) {
            LOG.error("Unable to read the configuration file. : {}");
            LOG.error(e.getMessage());
            throw new AgileCardsException();
        }

    }

    /**
     * Check if version is known by the application.
     * @param version
     * @return
     */
    private static boolean isKnownVersion(int version) {
        return (version <= 1);
    }


}
