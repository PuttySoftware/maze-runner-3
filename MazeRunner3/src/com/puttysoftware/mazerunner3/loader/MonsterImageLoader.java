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
import com.puttysoftware.mazerunner3.creatures.monsters.Element;

public class MonsterImageLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/image/monster/";
    private static String LOAD_PATH = MonsterImageLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = MonsterImageLoader.class;

    public static BufferedImageIcon getImage(final String name, final Element e) {
	// Get it from the cache
	return MonsterImageCache.getCachedImage(name, e.getFaith().getColor().getRGB());
    }

    static BufferedImageIcon getUncachedImage(final String name) {
	try {
	    final String normalName = ImageTransformer.normalizeName(name);
	    final URL url = MonsterImageLoader.LOAD_CLASS
		    .getResource(MonsterImageLoader.LOAD_PATH + normalName + ".png");
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
