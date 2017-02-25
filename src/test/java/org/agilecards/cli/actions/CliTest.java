package org.agilecards.cli.actions;

import org.agilecards.cli.args4j.Args4jCliConfiguration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Created by Beewy on 25/02/2017.
 */

public class CliTest {


    private Args4jCliConfiguration baseOptions;

    @Before
    public void setUp() {
        baseOptions = new Args4jCliConfiguration();

    }


    @Test
    public void testVersionAction() throws Exception {
        CmdLineParser parser = new CmdLineParser(baseOptions);
        parser.parseArgument("version");
        Assert.assertTrue(baseOptions.getAction() instanceof VersionAction);
    }

    @Test
    public void testGenerateAction() throws Exception {
        CmdLineParser parser = new CmdLineParser(baseOptions);
        parser.parseArgument("generate");
        Assert.assertTrue(baseOptions.getAction() instanceof GenerateAction);
    }

    @Test
    public void testInitAction() throws Exception {
        CmdLineParser parser = new CmdLineParser(baseOptions);
        parser.parseArgument("version");
        Assert.assertTrue(baseOptions.getAction() instanceof InitAction);
    }

    @Test
    public void testBlankAction() throws Exception {
        CmdLineParser parser = new CmdLineParser(baseOptions);
        parser.parseArgument("version");
        Assert.assertTrue(baseOptions.getAction() instanceof BlankAction);
    }

    @Test
    public void testVersionActionWithVerbose() throws Exception {
        CmdLineParser parser = new CmdLineParser(baseOptions);
        parser.parseArgument("version","--log");
        Assert.assertTrue(baseOptions.getAction() instanceof VersionAction);
        Assert.assertTrue(baseOptions.isVerbose());
    }

}
