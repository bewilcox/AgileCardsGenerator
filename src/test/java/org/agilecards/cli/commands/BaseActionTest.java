package org.agilecards.cli.commands;

import org.agilecards.cli.args4j.Args4jCliConfiguration;
import org.junit.Before;
import org.kohsuke.args4j.CmdLineParser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by Beewy on 26/02/2017.
 */
public abstract class BaseActionTest {

    protected Args4jCliConfiguration cliConfiguration;
    protected CmdLineParser parser;
    protected ByteArrayOutputStream outContent;

    @Before
    public void setUp() {
        // CLI Config
        cliConfiguration = new Args4jCliConfiguration();
        parser = new CmdLineParser(cliConfiguration);

        // Output stream to test console output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }


}
