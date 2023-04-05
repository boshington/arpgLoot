package net.bosh.arpglootmod.Config;

import com.mojang.datafixers.util.Pair;

public class ARPGConfig implements SimpleConfig.DefaultConfig {

    private String configBody = "";

    public void addKeyValuePair(Pair<String, ?> keyValuePair) {
        configBody += keyValuePair.getFirst();
        configBody += "=";
        configBody += keyValuePair.getSecond();
        configBody += "\n";
    }

    public void addComment(String comment){
        configBody +=  "#" + comment + "\n";
    }

    @Override
    public String get(String namespace) {
        return configBody;
    }
}

