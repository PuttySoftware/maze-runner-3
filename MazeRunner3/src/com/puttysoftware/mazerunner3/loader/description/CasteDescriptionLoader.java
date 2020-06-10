/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.description;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.creatures.castes.CasteConstants;
import com.puttysoftware.mazerunner3.maze.Extension;

public class CasteDescriptionLoader {
    public static String getCasteDescription(final int c) {
	final String name = CasteConstants.CASTE_NAMES[c].toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(CasteDescriptionLoader.class
		.getResourceAsStream("/asset/desc/caste/" + name + Extension.getInternalDataExtensionWithPeriod()))) {
	    // Fetch description
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    return null;
	}
    }
}
