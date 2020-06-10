/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.names.NamesConstants;

public class NameDataLoader {
    private static final String MAC_PREFIX = "HOME";
    private static final String WIN_PREFIX = "APPDATA";
    private static final String UNIX_PREFIX = "HOME";
    private static final String MAC_DIR = "/Library/Application Support/Putty Software/MazeRunnerII/";
    private static final String WIN_DIR = "\\Putty Software\\MazeRunnerII\\";
    private static final String UNIX_DIR = "/.puttysoftware/mazerunner2/";

    public static String[] getNamesData() {
	final File overrideData = NameDataLoader.getNamesOverrideFile();
	if (overrideData.exists()) {
	    return NameDataLoader.getNamesOverrideData();
	} else {
	    return NameDataLoader.getNamesDefaultData();
	}
    }

    private static String[] getNamesDefaultData() {
	try (ResourceStreamReader rsr = new ResourceStreamReader(
		NameDataLoader.class.getResourceAsStream("/asset/data/name/names.txt"))) {
	    // Load default
	    final ArrayList<String> data = new ArrayList<>();
	    // Ignore first line
	    String raw = rsr.readString();
	    while (raw != null) {
		raw = rsr.readString();
		data.add(raw);
	    }
	    final Object[] arr = data.toArray();
	    final String[] tempres = new String[arr.length];
	    int count = 0;
	    for (int x = 0; x < arr.length; x++) {
		if (arr[x] != null) {
		    tempres[x] = arr[x].toString();
		    count++;
		}
	    }
	    final String[] res = new String[count];
	    count = 0;
	    for (final String tempre : tempres) {
		if (tempre != null) {
		    res[count] = tempre;
		    count++;
		}
	    }
	    return res;
	} catch (final Exception e) {
	    Game.uncaughtException(e);
	    return null;
	}
    }

    private static String[] getNamesOverrideData() {
	try {
	    final File overrideData = NameDataLoader.getNamesOverrideFile();
	    // Version check
	    if (overrideData.exists() && !NameDataLoader.isNamesFileCorrectVersion(overrideData)) {
		final boolean success = overrideData.delete();
		if (!success) {
		    throw new IOException("Deleting override failed!");
		}
	    }
	    try (FileInputStream fis = new FileInputStream(overrideData);
		    ResourceStreamReader rsr = new ResourceStreamReader(fis)) {
		final ArrayList<String> data = new ArrayList<>();
		// Ignore first line
		String raw = rsr.readString();
		while (raw != null) {
		    raw = rsr.readString();
		    data.add(raw);
		}
		final Object[] arr = data.toArray();
		final String[] tempres = new String[arr.length];
		int count = 0;
		for (int x = 0; x < arr.length; x++) {
		    if (arr[x] != null) {
			tempres[x] = arr[x].toString();
			count++;
		    }
		}
		final String[] res = new String[count];
		count = 0;
		for (final String tempre : tempres) {
		    if (tempre != null) {
			res[count] = tempre;
			count++;
		    }
		}
		return res;
	    }
	} catch (final Exception e) {
	    Game.uncaughtException(e);
	    return null;
	}
    }

    public static void resetNames() {
	try {
	    final File overrideData = NameDataLoader.getNamesOverrideFile();
	    // Version check
	    if (overrideData.exists()) {
		final boolean success = overrideData.delete();
		if (!success) {
		    throw new IOException("Deleting override failed!");
		}
	    }
	} catch (final Exception e) {
	    Game.uncaughtException(e);
	}
    }

    private static String getNamesDirPrefix() {
	final String osName = System.getProperty("os.name");
	if (osName.indexOf("Mac OS X") != -1) {
	    // Mac OS X
	    return System.getenv(NameDataLoader.MAC_PREFIX);
	} else if (osName.indexOf("Windows") != -1) {
	    // Windows
	    return System.getenv(NameDataLoader.WIN_PREFIX);
	} else {
	    // Other - assume UNIX-like
	    return System.getenv(NameDataLoader.UNIX_PREFIX);
	}
    }

    private static String getNamesDirectory() {
	final String osName = System.getProperty("os.name");
	if (osName.indexOf("Mac OS X") != -1) {
	    // Mac OS X
	    return NameDataLoader.MAC_DIR;
	} else if (osName.indexOf("Windows") != -1) {
	    // Windows
	    return NameDataLoader.WIN_DIR;
	} else {
	    // Other - assume UNIX-like
	    return NameDataLoader.UNIX_DIR;
	}
    }

    public static File getNamesOverrideFile() {
	final StringBuilder b = new StringBuilder();
	b.append(NameDataLoader.getNamesDirPrefix());
	b.append(NameDataLoader.getNamesDirectory());
	b.append("names.txt");
	return new File(b.toString());
    }

    private static boolean isNamesFileCorrectVersion(final File f) {
	try (FileInputStream fis = new FileInputStream(f); ResourceStreamReader rsr = new ResourceStreamReader(fis)) {
	    final int version = rsr.readInt();
	    return version == NamesConstants.NAMES_VERSION;
	} catch (final Exception e) {
	    return false;
	}
    }
}
