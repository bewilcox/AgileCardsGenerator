package org.agilecards.cli.args4j;

import org.agilecards.cli.actions.BaseActionTest;
import org.agilecards.cli.actions.VersionAction;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Beewy on 25/02/2017.
 */
public class Args4jCliConfigurationTest extends BaseActionTest {

    @Test
    public void isVerbose() throws Exception {
        parser.parseArgument("--log","version");
        Assert.assertTrue(cliConfiguration.isVerbose());
    }

    @Test
    public void isHelp() throws Exception {
        parser.parseArgument("--help");
        Assert.assertTrue(cliConfiguration.isHelp());
    }

    @Test
    public void getAction() throws Exception {
        parser.parseArgument("--log","version");
        Assert.assertTrue(cliConfiguration.getAction() instanceof VersionAction);
    }

}