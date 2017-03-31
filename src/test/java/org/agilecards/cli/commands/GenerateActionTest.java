package org.agilecards.cli.commands;

import org.junit.Assert;
import org.junit.Test;
import org.kohsuke.args4j.CmdLineException;

/**
 * Created by Beewy on 25/02/2017.
 */
public class GenerateActionTest extends BaseActionTest {


    @Test
    public void testGenerateAction() throws Exception {
        parser.parseArgument("generate","--generator","toto");
        Assert.assertTrue(cliConfiguration.getAction() instanceof GenerateCommand);
        Assert.assertFalse(cliConfiguration.isVerbose());
        GenerateCommand generateAction = (GenerateCommand)cliConfiguration.getAction();
        Assert.assertEquals(generateAction.getGenerator(),"toto");
    }

    @Test
    public void testGenerateActionWithVerbose() throws Exception {
        parser.parseArgument("--log","generate","--generator","toto");
        Assert.assertTrue(cliConfiguration.getAction() instanceof GenerateCommand);
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test(expected = CmdLineException.class)
    public void testGenerateAction_withOptionRequired() throws Exception {
        parser.parseArgument("generate");
        Assert.assertTrue(cliConfiguration.getAction() instanceof GenerateCommand);
    }

    @Test
    public void showSpecificUsage() throws Exception {
        parser.parseArgument("generate","--help");
        Assert.assertTrue(cliConfiguration.getAction().isHelp());

        String expectedSpecificUsage =
                "agile-cards generate : Generate the agile cards" + System.getProperty("line.separator") +
                        System.getProperty("line.separator") +
                        "Usage : agile-cards generate [options]" + System.getProperty("line.separator") +
                        " --help (-H) : Show specific usage (default: false)" + System.getProperty("line.separator");

        cliConfiguration.getAction().showSpecificUsage();
        Assert.assertEquals(expectedSpecificUsage,outContent.toString());
    }

}