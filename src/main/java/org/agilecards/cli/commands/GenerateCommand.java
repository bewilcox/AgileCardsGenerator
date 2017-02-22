package org.agilecards.cli.commands;

import org.kohsuke.args4j.Option;

/**
 * Created by Beewy on 22/02/2017.
 */
public class GenerateCommand {

    @Option(name = "--help", usage = "Show usage", aliases = "-H", help = true, hidden = true)
    private boolean help;

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

    public boolean isHelp() {
        return help;
    }
}
