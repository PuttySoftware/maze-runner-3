/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.names;

import java.util.ArrayList;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.loader.data.NameDataLoader;

public class NamesManager {
    private static boolean CACHE_CREATED = false;
    private static String[] RAW_CACHE;
    private static String[][] CACHE;

    public static String getName(final String section, final String type) {
	try {
	    NamesManager.createCache();
	} catch (final Exception e) {
	    Game.uncaughtException(e);
	}
	final String key = section + ":" + type;
	if (!NamesManager.containsKey(key)) {
	    Game.uncaughtException(new IllegalArgumentException("No such key " + key));
	}
	return NamesManager.getValue(key);
    }

    private static boolean containsKey(final String key) {
	for (final String[] element : NamesManager.CACHE) {
	    if (element[0].equals(key)) {
		return true;
	    }
	}
	return false;
    }

    private static String getValue(final String key) {
	for (final String[] element : NamesManager.CACHE) {
	    if (element[0].equals(key)) {
		return element[1];
	    }
	}
	return null;
    }

    public static void invalidateNamesCache() {
	NamesManager.CACHE_CREATED = false;
    }

    public static String[][] getNamesCache() {
	try {
	    NamesManager.createCache();
	} catch (final Exception e) {
	    Game.uncaughtException(e);
	}
	return NamesManager.CACHE;
    }

    public static String[] convertCacheToArray() {
	final ArrayList<String> temp1 = new ArrayList<>();
	final ArrayList<String> temp2 = new ArrayList<>();
	for (final String[] element : NamesManager.CACHE) {
	    temp1.add(element[0]);
	    temp2.add(element[1]);
	}
	final String[] temp3 = temp1.toArray(new String[temp1.size()]);
	final String[] temp4 = temp2.toArray(new String[temp2.size()]);
	final String[] results = new String[temp3.length];
	for (int x = 0; x < results.length; x++) {
	    results[x] = temp3[x] + "=" + temp4[x];
	}
	return results;
    }

    private static void createCache() {
	if (!NamesManager.CACHE_CREATED) {
	    // Create raw cache
	    NamesManager.RAW_CACHE = NameDataLoader.getNamesData();
	    if (NamesManager.RAW_CACHE != null) {
		NamesManager.CACHE = new String[NamesManager.RAW_CACHE.length][2];
		for (int x = 0; x < NamesManager.RAW_CACHE.length; x++) {
		    if (NamesManager.RAW_CACHE[x] != null && !NamesManager.RAW_CACHE[x].isEmpty()) {
			// Entry
			final String[] splitEntry = NamesManager.RAW_CACHE[x].split("=");
			// Sanity check
			if (splitEntry.length < 2) {
			    throw new IllegalArgumentException("Invalid names file format: Entry format invalid!");
			}
			final String key = splitEntry[0];
			final String value = splitEntry[1];
			NamesManager.CACHE[x][0] = key;
			NamesManager.CACHE[x][1] = value;
		    }
		}
		NamesManager.CACHE_CREATED = true;
	    } else {
		throw new IllegalArgumentException("Names file not found!");
	    }
	}
    }
}
