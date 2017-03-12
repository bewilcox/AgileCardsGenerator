package org.agilecards.configuration;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the configuration.
 * Created by Beewy on 05/03/2017.
 */
public class AgileCardsConfigurationTest
{
    @Test
    public void testGenerateAction_NameAndUsage() throws Exception {
        Assert.assertEquals("generate",AgileCardsConfiguration.GENERATE_ACTION);
        Assert.assertEquals("Generate the agile cards",AgileCardsConfiguration.GENERATE_USAGE);
    }

    @Test
    public void testVersionAction_NameAndUsage() throws Exception {
        Assert.assertEquals("version",AgileCardsConfiguration.VERSION_ACTION);
        Assert.assertEquals("Show the application version",AgileCardsConfiguration.VERSION_USAGE);
    }

    @Test
    public void testInitAction_NameAndUsage() throws Exception {
        Assert.assertEquals("init",AgileCardsConfiguration.INIT_ACTION);
        Assert.assertEquals("Init the configuration and template files",AgileCardsConfiguration.INIT_USAGE);
    }

    @Test
    public void testBlankAction_NameAndUsage() throws Exception {
        Assert.assertEquals("blank",AgileCardsConfiguration.BLANK_ACTION);
        Assert.assertEquals("Generate blank cards",AgileCardsConfiguration.BLANK_USAGE);
    }
}