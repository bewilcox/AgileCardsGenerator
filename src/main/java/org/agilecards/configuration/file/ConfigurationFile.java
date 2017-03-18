package org.agilecards.configuration.file;

import java.util.List;
import java.util.Optional;

public class ConfigurationFile {
    
    private int version;
    private List<GeneratorConfig> generators;


    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<GeneratorConfig> getGenerators() {
        return generators;
    }

    public void setGenerators(List<GeneratorConfig> generators) {
        this.generators = generators;
    }

    public Optional<GeneratorConfig> getGeneratorConfig(String name) {
        GeneratorConfig config = this.generators.stream()
                                        .filter(gen -> gen.getName().equals(name))
                                        .findFirst()
                                        .orElse(null);
        return Optional.ofNullable(config);
    }
}
