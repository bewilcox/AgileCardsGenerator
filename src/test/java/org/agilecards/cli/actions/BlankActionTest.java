package org.agilecards.cli.actions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Beewy on 25/02/2017.
 */
public class BlankActionTest extends BaseActionTest{

    @Test
    public void testBlankAction() throws Exception {
        parser.parseArgument("blank");
        Assert.assertTrue(cliConfiguration.getAction() instanceof BlankAction);
        Assert.assertFalse(cliConfiguration.isVerbose());
    }

    @Test
    public void testBlankActionWithVerbose() throws Exception {
        parser.parseArgument("--log","blank");
        Assert.assertTrue(cliConfiguration.getAction() instanceof BlankAction);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("blank","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards blank : Generate blank cards" + System.getProperty("line.separator") +
                        System.getProperty("line.separator") +
                        "Usage : agile-cards blank [options]" + System.getProperty("line.separator") +
                        " --help (-H) : Show specific usage (default: false)" + System.getProperty("line.separator");

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}