package net.bosh.arpglootmod.Config;


import com.mojang.datafixers.util.Pair;

public class ConfigLoader {
    public static SimpleConfig CONFIG;
    private static ARPGConfig conf;
    public static int LEGENDARY_CHANCE;
    public static int EPIC_CHANCE;
    public static int SUPERB_CHANCE;
    public static int EXALTED_CHANCE;
    public static int RARE_CHANCE;
    public static int UNCOMMON_CHANCE;
    public static int COMMON_CHANCE;
    public static String ENABLE_INCOMPATIBLE_ENCHANTS;
    public static String ENABLE_WILD_ENCHANTS;


    public static void registerConfigs() {
        conf = new ARPGConfig();
        createConfigs();

        CONFIG = SimpleConfig.of("arpglootmod").provider(conf).request();

        assignConfigs();
    }

    private static void createConfigs() {
        conf.addKeyValuePair(new Pair<>("LEGENDARY_CHANCE", 1000));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("EPIC_CHANCE", 200));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("EXALTED_CHANCE", 200 ));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("SUPERB_CHANCE", 100));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("RARE_CHANCE", 50));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("UNCOMMON_CHANCE", 25));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("COMMON_CHANCE", 10));
        conf.addComment("Minimum 2 -- 1 in X chance of an enemy dropping a legendary item");
        conf.addKeyValuePair(new Pair<>("ENABLE_INCOMPATIBLE_ENCHANTS", "DISABLED"));
        conf.addComment("DISABLED or ENABLED -- If Enabled, it is possible for items to roll multiple exclusive enchants e.g. fortune and silk touch");
        conf.addKeyValuePair(new Pair<>("ENABLE_WILD_ENCHANTS", "DISABLED"));
        conf.addComment("DISABLED or ENABLED -- If Enabled, it is possible to roll incompatible enchants e.g. protection on a sword");
    }

    private static void assignConfigs() {
        LEGENDARY_CHANCE = CONFIG.getOrDefault( "LEGENDARY_CHANCE", 1000 );
        EPIC_CHANCE = CONFIG.getOrDefault( "EPIC_CHANCE", 200 );
        EXALTED_CHANCE = CONFIG.getOrDefault( "EXALTED_CHANCE", 200 );
        SUPERB_CHANCE = CONFIG.getOrDefault( "SUPERB_CHANCE", 100 );
        RARE_CHANCE = CONFIG.getOrDefault( "RARE_CHANCE", 50 );
        UNCOMMON_CHANCE = CONFIG.getOrDefault( "UNCOMMON_CHANCE", 25 );
        COMMON_CHANCE = CONFIG.getOrDefault( "COMMON_CHANCE", 10 );
        ENABLE_INCOMPATIBLE_ENCHANTS = CONFIG.getOrDefault("ENABLE_INCOMPATIBLE_ENCHANTS", "DISABLED");
        ENABLE_WILD_ENCHANTS = CONFIG.getOrDefault("ENABLE_WILD_ENCHANTS", "DISABLED");
    }
}
