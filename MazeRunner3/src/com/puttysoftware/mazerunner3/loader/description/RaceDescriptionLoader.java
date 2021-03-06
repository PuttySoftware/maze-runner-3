/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.description;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.creatures.races.RaceConstants;
import com.puttysoftware.mazerunner3.maze.Extension;

public class RaceDescriptionLoader {
    public static String getRaceDescription(final int r) {
	final String name = RaceConstants.getRaceName(r).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(RaceDescriptionLoader.class
		.getResourceAsStream("/asset/desc/race/" + name + Extension.getInternalDataExtensionWithPeriod()))) {
	    // Fetch description
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    return null;
	}
    }
}
