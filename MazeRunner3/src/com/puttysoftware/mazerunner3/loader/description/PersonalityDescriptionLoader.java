/*  MazeRunnerII: An RPG
Copyright (C) 2011-2012 Eric Ahnell


Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader.description;

import com.puttysoftware.fileutils.ResourceStreamReader;
import com.puttysoftware.mazerunner3.creatures.personalities.PersonalityConstants;
import com.puttysoftware.mazerunner3.maze.Extension;

public class PersonalityDescriptionLoader {
    public static String getPersonalityDescription(final int p) {
	final String name = PersonalityConstants.getPersonalityName(p).toLowerCase();
	try (final ResourceStreamReader rsr = new ResourceStreamReader(
		PersonalityDescriptionLoader.class.getResourceAsStream(
			"/asset/desc/personality/" + name + Extension.getInternalDataExtensionWithPeriod()))) {
	    // Fetch description
	    final String desc = rsr.readString();
	    return desc;
	} catch (final Exception e) {
	    return null;
	}
    }
}
