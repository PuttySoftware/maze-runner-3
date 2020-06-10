/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

import com.puttysoftware.audio.mod.MicroMod;
import com.puttysoftware.fileutils.FileUtilities;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.maze.Maze;

public class MusicLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/music/";
    private static String LOAD_PATH = MusicLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = MusicLoader.class;
    private static MicroMod CURRENT_MUSIC;

    private static MicroMod getMusic(final String filename) {
	try {
	    final File modFile = new File(Maze.getMazeTempFolder() + File.separator + "MusicTemp" + File.separator
		    + filename.toLowerCase() + ".mod");
	    if (!modFile.exists()) {
		final File modParent = modFile.getParentFile();
		if (!modParent.exists()) {
		    final boolean result = modParent.mkdirs();
		    if (!result) {
			throw new IOException();
		    }
		}
		try (final InputStream is = MusicLoader.LOAD_CLASS
			.getResourceAsStream(MusicLoader.LOAD_PATH + filename.toLowerCase() + ".mod")) {
		    FileUtilities.copyRAMFile(is, modFile);
		}
	    }
	    final MicroMod mm = new MicroMod();
	    mm.loadModule(modFile);
	    return mm;
	} catch (final NullPointerException np) {
	    return null;
	} catch (final IOException io) {
	    return null;
	}
    }

    public static void playMusic(final String musicName) {
	MusicLoader.CURRENT_MUSIC = MusicLoader.getMusic(musicName);
	if (MusicLoader.CURRENT_MUSIC != null) {
	    // Play the music
	    MusicLoader.CURRENT_MUSIC.playModule();
	}
    }

    public static void stopMusic() {
	if (MusicLoader.CURRENT_MUSIC != null) {
	    // Stop the music
	    try {
		MusicLoader.CURRENT_MUSIC.stopModule();
	    } catch (final BufferUnderflowException bue) {
		// Ignore
	    } catch (final NullPointerException np) {
		// Ignore
	    } catch (final Throwable t) {
		Game.uncaughtException(t);
	    }
	}
    }

    public static boolean isMusicPlaying() {
	if (MusicLoader.CURRENT_MUSIC != null) {
	    if (MusicLoader.CURRENT_MUSIC.isPlayThreadAlive()) {
		return true;
	    }
	}
	return false;
    }
}