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

public class LogoImageLoader {
    private static final String DEFAULT_LOAD_PATH = "/asset/image/logo/";
    private static String LOAD_PATH = LogoImageLoader.DEFAULT_LOAD_PATH;
    private static Class<?> LOAD_CLASS = LogoImageLoader.class;

    static BufferedImageIcon getUncachedLogo(final String name) {
	try {
	    final URL url = LogoImageLoader.LOAD_CLASS.getResource(LogoImageLoader.LOAD_PATH + name + ".png");
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

    public static BufferedImageIcon getLogo() {
	return LogoCache.getCachedLogo("logo");
    }

    public static BufferedImageIcon getMiniatureLogo() {
	return LogoCache.getCachedLogo("minilogo");
    }

    public static BufferedImageIcon getMicroLogo() {
	return LogoCache.getCachedLogo("micrologo");
    }

    public static BufferedImageIcon getIconLogo() {
	return LogoCache.getCachedLogo("logo");
    }
}
