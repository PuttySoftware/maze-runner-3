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

public class ObjectImageLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/image/object/";
    private static String LOAD_PATH = ObjectImageLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = ObjectImageLoader.class;

    public static BufferedImageIcon getImage(final String name, final int baseID, final int transformColor,
	    final int attrID, final int attrColor) {
	// Get it from the cache
	final String baseName = ObjectImageConstants.getObjectImageName(baseID);
	final String attrName = ObjectImageConstants.getObjectImageName(attrID);
	return ObjectImageCache.getCachedImage(name, baseName, transformColor, attrName, attrColor);
    }

    public static void addImageToCache(final String name, final BufferedImageIcon img) {
	if (!ObjectImageCache.isInCache(name)) {
	    ObjectImageCache.addToCache(name, img);
	}
    }

    static BufferedImageIcon getUncachedImage(final String name) {
	try {
	    final String normalName = ImageTransformer.normalizeName(name);
	    final URL url = ObjectImageLoader.LOAD_CLASS.getResource(ObjectImageLoader.LOAD_PATH + normalName + ".png");
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
