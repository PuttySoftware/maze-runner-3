/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.puttysoftware.images.BufferedImageIcon;

public class EffectImageLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/image/effect/";
    private static String LOAD_PATH = EffectImageLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = EffectImageLoader.class;

    public static BufferedImageIcon getImage(final int imageID) {
	// Get it from the cache
	final String name = EffectImageConstants.STAT_IMAGE_NAMES[imageID];
	return EffectImageCache.getCachedImage(name);
    }

    static BufferedImageIcon getUncachedImage(final String name) {
	try {
	    final String normalName = ImageTransformer.normalizeName(name);
	    final URL url = EffectImageLoader.LOAD_CLASS.getResource(EffectImageLoader.LOAD_PATH + normalName + ".png");
	    final BufferedImage image = ImageIO.read(url);
	    return new BufferedImageIcon(image);
	} catch (final IOException ie) {
	    return null;
	} catch (final NullPointerException np) {
	    return null;
	} catch (final IllegalArgumentException ia) {
	    return null;
	}
    }
}
