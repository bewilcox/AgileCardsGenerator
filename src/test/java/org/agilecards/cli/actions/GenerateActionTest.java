package org.agilecards.cli.actions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Beewy on 25/02/2017.
 */
public class GenerateActionTest extends BaseActionTest {

    @Test
    public void testVersionAction() throws Exception {
        parser.parseArgument("generate");
        Assert.assertTrue(cliConfiguration.getAction() instanceof GenerateAction);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testVersionActionWithVerbose() throws Exception {
        parser.parseArgument("--log","generate");
        Assert.assertTrue(cliConfiguration.getAction() instanceof GenerateAction);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("generate","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards generate : Generate the agile cards\n" +
                        "\n" +
                        "Usage : agile-cards generate [options]\n" +
                        " --help (-H) : Show specific usage (default: false)\n";

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}