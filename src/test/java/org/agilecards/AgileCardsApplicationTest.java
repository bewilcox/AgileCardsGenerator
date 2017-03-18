package org.agilecards;

import ch.qos.logback.classic.Level;
import org.agilecards.configuration.AgileCardsConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by Beewy on 14/03/2017.
 */
public class AgileCardsApplicationTest {

    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        // To test console output
        // Output stream to test console output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void startWithParsingException() throws Exception {
        AgileCardsApplication.main(new String[] {"toto"});
        assertTrue(outContent.toString().contains("Error during parameters parsing"));
    }

    @Test
    public void startWithVerboseMode() throws Exception {
        AgileCardsApplication.main(new String[] {"--log","version"});
        org.slf4j.Logger rootLogger = org.slf4j.LoggerFactory.getLogger("ROOT");
        if (rootLogger instanceof ch.qos.logback.classic.Logger) {
            ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) rootLogger;
            assertEquals(root.getLevel(),Level.DEBUG);
        } else {
            fail("Unable to get the correct logger");
        }
    }

    @Test
    public void startWithUsage() throws Exception {
        AgileCardsApplication.main(new String[] {"--help"});
        outContent.toString().contains("Usage");
    }

    @Test
    public void startWithAction() throws Exception {
        AgileCardsApplication.main(new String[] {"version"});
        outContent.toString().contains(AgileCardsConfiguration.APP_NAME);
    }
}