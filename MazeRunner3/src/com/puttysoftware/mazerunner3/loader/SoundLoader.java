/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.puttysoftware.diane.Diane;
import com.puttysoftware.randomrange.RandomRange;

public class SoundLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/sound/";
    private static String LOAD_PATH = SoundLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = SoundLoader.class;

    public static void playSound(final int soundID) {
	try {
	    int offset = 0;
	    if (soundID == SoundConstants.SOUND_WALK) {
		final RandomRange rSound = new RandomRange(0, 2);
		offset = rSound.generate();
	    }
	    final String soundName = SoundConstants.SOUND_NAMES[soundID + offset];
	    SoundLoader
		    .play(SoundLoader.LOAD_CLASS.getResource(SoundLoader.LOAD_PATH + soundName.toLowerCase() + ".wav"));
	} catch (final ArrayIndexOutOfBoundsException aioob) {
	    // Do nothing
	}
    }

    private static final int BUFFER_SIZE = 4096; // 4Kb

    private static void play(final URL soundURL) {
	new Thread() {
	    @Override
	    public void run() {
		try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL)) {
		    final AudioFormat format = audioInputStream.getFormat();
		    final DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		    try (Line line = AudioSystem.getLine(info); SourceDataLine auline = (SourceDataLine) line) {
			auline.open(format);
			auline.start();
			int nBytesRead = 0;
			final byte[] abData = new byte[SoundLoader.BUFFER_SIZE];
			try {
			    while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) {
				    auline.write(abData, 0, nBytesRead);
				}
			    }
			} catch (final IOException e) {
			    Diane.handleError(e);
			} finally {
			    auline.drain();
			}
		    } catch (final LineUnavailableException e) {
			Diane.handleError(e);
		    }
		} catch (final UnsupportedAudioFileException e) {
		    Diane.handleError(e);
		} catch (final IOException e) {
		    Diane.handleError(e);
		}
	    }
	}.start();
    }
}