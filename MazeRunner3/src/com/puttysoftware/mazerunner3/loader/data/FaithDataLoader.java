/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.data;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.creatures.faiths.FaithConstants;
import com.puttysoftware.mazerunner3.maze.Extension;

public class FaithDataLoader {
    public static double[] getFaithData(final int f) {
	final String name = FaithConstants.getFaithName(f).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(FaithDataLoader.class
		.getResourceAsStream("/asset/data/faith/" + name + Extension.getInternalDataExtensionWithPeriod()))) {
	    // Fetch data
	    final int[] rawData = new int[FaithConstants.getFaithsCount()];
	    for (int x = 0; x < rawData.length; x++) {
		rawData[x] = rsr.readInt();
	    }
	    // Parse raw data
	    final double[] finalData = new double[rawData.length];
	    for (int x = 0; x < rawData.length; x++) {
		finalData[x] = FaithConstants.getLookupTableEntry(rawData[x]);
	    }
	    return finalData;
	} catch (final Exception e) {
	    return null;
	}
    }
}
