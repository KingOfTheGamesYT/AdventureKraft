package com.teamolympus.dangerzone.api;

import net.minecraft.block.Block;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * This is to be done on the Initialization stage of Forge.
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
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListAPI.add(name);
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();
        }
    }

    /**
     * Passing the block, it will get the registry name of it
     */
    public static void addOntoMinerdreamList(Block name)  {
        try {
            Class.forName(SEARCHED_CLASS_NAME);
            addOntoMinerdreamList(Block.blockRegistry.getNameForObject(name));
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();
        }
    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(Set<String> name) {
       try {
           Class.forName(SEARCHED_CLASS_NAME);
           com.teamolympus.dangerzone.config.DZConfig.bannedBlockListAPI.addAll(name);
       } catch (ClassNotFoundException e) {
           throwErr(e);
           logErrMsg();
       }
    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(String[] name) {
        try {
           Class.forName(SEARCHED_CLASS_NAME);
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListAPI.addAll(Arrays.asList(name));
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();
        }
    }

    /**
     * Passing the block, it will get the registry name of it
     */
    public static void addOntoMinerdreamList(Block[] name) {
        try {
            Class.forName(SEARCHED_CLASS_NAME);

            final int len = name.length;
            for (int i = 0; i < len; ++i) {
                addOntoMinerdreamList(Block.blockRegistry.getNameForObject(name[i]));
            }
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();
        }

    }

    /**
     * The registry name of the block
     */
    public static void addOntoMinerdreamList(List<String> name){
        try {
            Class.forName(SEARCHED_CLASS_NAME);
            com.teamolympus.dangerzone.config.DZConfig.bannedBlockListAPI.addAll(name);
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();
        }
    }

    /**
     * Passing the block, it will get the registry name of it
     */
    public static void addBlockOntoMinerdreamList(List<Block> name){
        try {
            Class.forName(SEARCHED_CLASS_NAME);
            final int arrSize = name.size();
            for (int i = 0; i < arrSize; ++i) {
                addOntoMinerdreamList( Block.blockRegistry.getNameForObject(name.get(i)));
            }
        } catch (ClassNotFoundException e) {
            throwErr(e);
            logErrMsg();

        }
    }

    private static void throwErr(Throwable throwable) {
        com.teamolympus.dangerzone.misc.DZLogger.handleExceptionError(throwable);
    }

    private static void logErrMsg() {
        com.teamolympus.dangerzone.misc.DZLogger.error("AdventureKraft MinerDream API class was called when the class does not exists. This means a call was not isolated properly!!!");
    }
}
