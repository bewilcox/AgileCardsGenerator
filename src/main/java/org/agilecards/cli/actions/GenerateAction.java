package org.agilecards.cli.actions;

import org.kohsuke.args4j.Option;

/**
 * Created by Beewy on 22/02/2017.
 */
public class GenerateAction extends AgileCardsAction{

    @Option(name = "--provider", required = true, usage = "Set the provider name", aliases = "-P", metaVar = "{provider name}")
    private String provider;

    @Option(name = "--template", required = true, usage = "Set the template name", aliases = "-T", metaVar = "{template name}")
    private String template;

    public String getProvider() {
        return provider;
    }

    public String getTemplate() {
        return template;
    }

}
