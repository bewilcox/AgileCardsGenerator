package org.agilecards.cli.actions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests class for the version action.
 * Created by Beewy on 25/02/2017.
 */
public class VersionActionTest extends BaseActionTest{

    @Test
    public void testVersionAction() throws Exception {
        parser.parseArgument("version");
        Assert.assertTrue(cliConfiguration.getAction() instanceof VersionAction);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testVersionActionWithVerbose() throws Exception {
        parser.parseArgument("--log","version");
        Assert.assertTrue(cliConfiguration.getAction() instanceof VersionAction);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("version","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards version : Show the application version\n" +
                "\n" +
                "Usage : agile-cards version [options]\n" +
                " --help (-H) : Show specific usage (default: false)\n";

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}