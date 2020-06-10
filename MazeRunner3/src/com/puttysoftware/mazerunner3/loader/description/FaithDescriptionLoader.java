/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.description;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.creatures.faiths.FaithConstants;
import com.puttysoftware.mazerunner3.maze.Extension;

public class FaithDescriptionLoader {
    public static String getFaithDescription(final int f) {
	final String name = FaithConstants.getFaithName(f).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(FaithDescriptionLoader.class
		.getResourceAsStream("/asset/desc/faith/" + name + Extension.getInternalDataExtensionWithPeriod()))) {
	    // Fetch description
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    return null;
	}
    }
}
