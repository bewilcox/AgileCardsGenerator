package org.agilecards.service;

import org.agilecards.configuration.AgileCardsConfiguration;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test Class for VersionService.
 * Created by Beewy on 05/03/2017.
 */
public class VersionServiceTest {

    private AgileCardsConfiguration config;

    @Before
    public void setUp() throws Exception {
        config = new AgileCardsConfiguration();
    }

    @Test
    public void getApplicationVersion() throws Exception {
        // app version can be read only at runtime.
        assertNull(config.getApplicationVersion());
    }

}