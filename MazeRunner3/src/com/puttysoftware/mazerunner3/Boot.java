/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3;

import java.awt.desktop.PreferencesEvent;
import java.awt.desktop.PreferencesHandler;

import com.puttysoftware.diane.ErrorLogger;
import com.puttysoftware.diane.gui.CommonDialogs;
import com.puttysoftware.integration.Integration;
import com.puttysoftware.mazerunner3.creatures.AbstractCreature;
import com.puttysoftware.mazerunner3.prefs.PreferencesManager;

public class Boot {
    // Constants
    private static Application application;
    private static final String PROGRAM_NAME = "MazeRunnerII";
    private static final String ERROR_MESSAGE = "Perhaps a bug is to blame for this error message.\n"
	    + "Include the error log with your bug report.\n" + "Email bug reports to: products@puttysoftware.com\n"
	    + "Subject: MazeRunnerII Bug Report";
    private static final String ERROR_TITLE = "MazeRunnerII Error";
    private static final ErrorLogger elog = new ErrorLogger(Boot.PROGRAM_NAME);
    private static final int BATTLE_MAP_SIZE = 16;
    private static final boolean DEBUG_MODE = false;

    // Methods
    public static Application getApplication() {
	return Boot.application;
    }

    public static ErrorLogger getErrorLogger() {
	String suffix;
	if (Boot.inDebugMode()) {
	    suffix = " (DEBUG)";
	} else {
	    suffix = "";
	}
	// Display error message
	CommonDialogs.showErrorDialog(Boot.ERROR_MESSAGE, Boot.ERROR_TITLE + suffix);
	return Boot.elog;
    }

    public static boolean inDebugMode() {
	return Boot.DEBUG_MODE;
    }

    public static int getBattleMazeSize() {
	return Boot.BATTLE_MAP_SIZE;
    }

    public static void preInit() {
	// Compute action cap
	AbstractCreature.computeActionCap(Boot.BATTLE_MAP_SIZE, Boot.BATTLE_MAP_SIZE);
    }

    public static void main(final String[] args) {
	try {
	    // Early initialization
	    Boot.preInit();
	    // Set look and feel
	    Integration integration = new Integration();
	    integration.configureLookAndFeel();
	    // Create game
	    Boot.application = new Application();
	    Boot.application.postConstruct();
	    // Integrate with host platform
	    integration.setAboutHandler(Boot.application.getAboutDialog());
	    integration.setOpenFileHandler(Boot.application.getMazeManager());
	    integration.setPreferencesHandler(new PrefsLauncher());
	    integration.setQuitHandler(Boot.application.getGUIManager());
	    // Set up Common Dialogs
	    CommonDialogs.setDefaultTitle(Boot.PROGRAM_NAME);
	    CommonDialogs.setIcon(Boot.application.getMicroLogo());
	    // Launch game
	    Boot.application.playLogoSound();
	    Boot.application.getGUIManager().showGUI();
	} catch (final Throwable t) {
	    Boot.getErrorLogger().logError(t);
	}
    }

    private static class PrefsLauncher implements PreferencesHandler {
	@Override
	public void handlePreferences(PreferencesEvent e) {
	    PreferencesManager.showPrefs();
	}
    }
}
