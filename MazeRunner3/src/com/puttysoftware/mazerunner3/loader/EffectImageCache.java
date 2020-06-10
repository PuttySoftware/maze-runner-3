/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.loader;

import com.puttysoftware.images.BufferedImageIcon;

public class EffectImageCache {
    // Fields
    private static CacheEntry[] cache;
    private static int CACHE_INCREMENT = 20;
    private static int CACHE_SIZE = 0;

    // Methods
    static BufferedImageIcon getCachedImage(final String name) {
	if (!EffectImageCache.isInCache(name)) {
	    final BufferedImageIcon bii = EffectImageLoader.getUncachedImage(name);
	    final BufferedImageIcon fixed = ImageTransformer.getTransformedImage(bii);
	    EffectImageCache.addToCache(name, fixed);
	}
	for (final CacheEntry element : EffectImageCache.cache) {
	    if (name.equals(element.getName())) {
		return element.getImage();
	    }
	}
	return null;
    }

    private static void expandCache() {
	final CacheEntry[] tempCache = new CacheEntry[EffectImageCache.cache.length + EffectImageCache.CACHE_INCREMENT];
	for (int x = 0; x < EffectImageCache.CACHE_SIZE; x++) {
	    tempCache[x] = EffectImageCache.cache[x];
	}
	EffectImageCache.cache = tempCache;
    }

    static void addToCache(final String name, final BufferedImageIcon bii) {
	if (EffectImageCache.cache == null) {
	    EffectImageCache.cache = new CacheEntry[EffectImageCache.CACHE_INCREMENT];
	}
	if (EffectImageCache.CACHE_SIZE == EffectImageCache.cache.length) {
	    EffectImageCache.expandCache();
	}
	EffectImageCache.cache[EffectImageCache.CACHE_SIZE] = new CacheEntry(bii, name);
	EffectImageCache.CACHE_SIZE++;
    }

    static boolean isInCache(final String name) {
	if (EffectImageCache.cache == null) {
	    EffectImageCache.cache = new CacheEntry[EffectImageCache.CACHE_INCREMENT];
	}
	for (int x = 0; x < EffectImageCache.CACHE_SIZE; x++) {
	    if (name.equals(EffectImageCache.cache[x].getName())) {
		return true;
	    }
	}
	return false;
    }
}