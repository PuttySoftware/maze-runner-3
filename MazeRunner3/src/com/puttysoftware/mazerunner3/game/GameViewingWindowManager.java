/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.game;

import com.puttysoftware.mazerunner3.prefs.PreferencesManager;

public class GameViewingWindowManager {
    // Fields
    private int oldLocX, oldLocY, locX, locY;

    // Constructors
    public GameViewingWindowManager() {
	this.locX = 0;
	this.locY = 0;
	this.oldLocX = 0;
	this.oldLocY = 0;
    }

    // Methods
    public int getViewingWindowLocationX() {
	return this.locX;
    }

    public int getViewingWindowLocationY() {
	return this.locY;
    }

    public int getLowerRightViewingWindowLocationX() {
	return this.locX + PreferencesManager.getViewingWindowSize() - 1;
    }

    public int getLowerRightViewingWindowLocationY() {
	return this.locY + PreferencesManager.getViewingWindowSize() - 1;
    }

    public void setViewingWindowLocationX(final int val) {
	this.locX = val;
    }

    public void setViewingWindowLocationY(final int val) {
	this.locY = val;
    }

    public void offsetViewingWindowLocationX(final int val) {
	this.locX += val;
    }

    public void offsetViewingWindowLocationY(final int val) {
	this.locY += val;
    }

    public void saveViewingWindow() {
	this.oldLocX = this.locX;
	this.oldLocY = this.locY;
    }

    public void restoreViewingWindow() {
	this.locX = this.oldLocX;
	this.locY = this.oldLocY;
    }

    public int getViewingWindowSizeX() {
	return PreferencesManager.getViewingWindowSize();
    }

    public int getViewingWindowSizeY() {
	return PreferencesManager.getViewingWindowSize();
    }

    public int getOffsetFactorX() {
	return PreferencesManager.getViewingWindowSize() / 2;
    }

    public int getOffsetFactorY() {
	return PreferencesManager.getViewingWindowSize() / 2;
    }
}
