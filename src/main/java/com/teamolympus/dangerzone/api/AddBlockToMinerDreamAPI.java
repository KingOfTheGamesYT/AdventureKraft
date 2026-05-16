package com.teamolympus.dangerzone.api;

import com.teamolympus.dangerzone.config.DZConfig;

import java.util.Arrays;

/**
 *
 * This here simply allows for blocks in their class String name or unlocalized name form to be added
 * for the miner's dream item to break your block.
 */
public class AddBlockToMinerDreamAPI {

    public void addOntoMinerdreamList(String name)  {
        try {
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListArrayList.add(name);
        } catch (Exception e) {
            logErrMsg();
            throw new RuntimeException(e);
        }

    }

    public void addOntoMinerdreamList(String[] name) {
       try {
           DZConfig.bannedBlockListArrayList.addAll(Arrays.asList(name));
       } catch (Exception e) {
           logErrMsg();
           throw new RuntimeException(e);
       }

    }

    private static void logErrMsg() {
        com.teamolympus.dangerzone.misc.DZLogger.LOGGER.fatal("It seems a mod has done something wrong!!!! Probably did not isolate the calls?");
    }
}
