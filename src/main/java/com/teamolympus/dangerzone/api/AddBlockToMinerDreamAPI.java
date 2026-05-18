package com.teamolympus.dangerzone.api;


import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This is to be done on the Initialization stage.
 * Allows for the registry name of blocks to be breakable by miner's dream.
 * EG. mymodid:mymodblock
 */
public class AddBlockToMinerDreamAPI {

    private static final String SEARCHED_CLASS_NAME = "com.teamolympus.dangerzone.config.DZConfig";

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(String name)  {
        try {
            Class.forName(SEARCHED_CLASS_NAME);
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListArrayList.add(name);
        } catch (ClassNotFoundException e) {
            logErrMsg();
        }
    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(Set<String> name) {
       try {
           Class.forName(SEARCHED_CLASS_NAME);
           com.teamolympus.dangerzone.config.DZConfig.bannedBlockListArrayList.addAll(name);
       } catch (ClassNotFoundException e) {
           logErrMsg();
       }

    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(String[] name) {
        try {
           Class.forName(SEARCHED_CLASS_NAME);
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListArrayList.addAll(Arrays.asList(name));
        } catch (ClassNotFoundException e) {
            logErrMsg();
        }

    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(List<String> name){
        try {
            Class.forName(SEARCHED_CLASS_NAME);
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListArrayList.addAll(name);
        } catch (ClassNotFoundException e) {
            logErrMsg();
        }
    }

    private static void logErrMsg() {
        com.teamolympus.dangerzone.misc.DZLogger.fatal("AdventureKraft MinerDream API class was called when the class does not exists. This means a call was not isolated properly!!!");
    }
}
