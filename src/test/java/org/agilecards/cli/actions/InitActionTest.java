package org.agilecards.cli.actions;

import org.junit.Assert;
import org.junit.Test;

/**
 * CLI Init Command
 * Created by Beewy on 25/02/2017.
 */
public class InitActionTest extends BaseActionTest {

    @Test
    public void testInitAction() throws Exception {
        parser.parseArgument("init");
        Assert.assertTrue(cliConfiguration.getAction() instanceof InitAction);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testInitActionWithVerbose() throws Exception {
        parser.parseArgument("--log","init");
        Assert.assertTrue(cliConfiguration.getAction() instanceof InitAction);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("init","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards init : Init the configuration and template files\n" +
                        "\n" +
                        "Usage : agile-cards init [options]\n" +
                        " --help (-H) : Show specific usage (default: false)\n";

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}