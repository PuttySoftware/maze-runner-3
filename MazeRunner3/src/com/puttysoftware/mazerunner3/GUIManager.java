/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.desktop.QuitEvent;
import java.awt.desktop.QuitHandler;
import java.awt.desktop.QuitResponse;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.puttysoftware.fileutils.DirectoryUtilities;
import com.puttysoftware.images.BufferedImageIcon;
import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.loader.LogoImageLoader;
import com.puttysoftware.mazerunner3.maze.Maze;
import com.puttysoftware.mazerunner3.maze.MazeManager;
import com.puttysoftware.mazerunner3.prefs.PreferencesManager;

public class GUIManager implements QuitHandler {
    // Fields
    private final JFrame guiFrame;
    private final JLabel logoLabel;

    // Constructors
    public GUIManager() {
	final CloseHandler cHandler = new CloseHandler();
	this.guiFrame = new JFrame("MazeRunnerII");
	final Container guiPane = this.guiFrame.getContentPane();
	this.guiFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	this.guiFrame.setLayout(new GridLayout(1, 1));
	this.logoLabel = new JLabel("", null, SwingConstants.CENTER);
	this.logoLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
	guiPane.add(this.logoLabel);
	this.guiFrame.setResizable(false);
	this.guiFrame.addWindowListener(cHandler);
    }

    // Methods
    public JFrame getGUIFrame() {
	if (this.guiFrame.isVisible()) {
	    return this.guiFrame;
	} else {
	    return null;
	}
    }

    public void showGUI() {
	final Application app = Game.getApplication();
	app.setInGUI();
	this.guiFrame.setJMenuBar(app.getMenuManager().getMainMenuBar());
	this.guiFrame.setVisible(true);
	app.getMenuManager().setMainMenus();
	app.getMenuManager().checkFlags();
    }

    public void hideGUI() {
	this.guiFrame.setVisible(false);
    }

    public void hideGUITemporarily() {
	this.guiFrame.setVisible(false);
    }

    public void updateLogo() {
	final BufferedImageIcon logo = LogoImageLoader.getLogo();
	this.logoLabel.setIcon(logo);
	final Image iconlogo = Game.getApplication().getIconLogo();
	this.guiFrame.setIconImage(iconlogo);
	this.guiFrame.pack();
    }

    public boolean quitHandler() {
	final MazeManager mm = Game.getApplication().getMazeManager();
	boolean saved = true;
	int status = JOptionPane.DEFAULT_OPTION;
	if (mm.getDirty()) {
	    status = mm.showSaveDialog();
	    if (status == JOptionPane.YES_OPTION) {
		saved = mm.saveMaze();
	    } else if (status == JOptionPane.CANCEL_OPTION) {
		saved = false;
	    } else {
		mm.setDirty(false);
	    }
	}
	if (saved) {
	    PreferencesManager.writePrefs();
	    if (PreferencesManager.areCharacterChangesPermanent()) {
		PartyManager.writebackCharacters();
	    }
	    // Run cleanup task
	    try {
		final File dirToDelete = new File(Maze.getMazeTempFolder());
		DirectoryUtilities.removeDirectory(dirToDelete);
	    } catch (final Throwable t) {
		// Ignore
	    }
	}
	return saved;
    }

    private class CloseHandler implements WindowListener {
	CloseHandler() {
	    // Do nothing
	}

	@Override
	public void windowActivated(final WindowEvent arg0) {
	    // Do nothing
	}

	@Override
	public void windowClosed(final WindowEvent arg0) {
	    // Do nothing
	}

	@Override
	public void windowClosing(final WindowEvent arg0) {
	    if (GUIManager.this.quitHandler()) {
		System.exit(0);
	    }
	}

	@Override
	public void windowDeactivated(final WindowEvent arg0) {
	    // Do nothing
	}

	@Override
	public void windowDeiconified(final WindowEvent arg0) {
	    // Do nothing
	}

	@Override
	public void windowIconified(final WindowEvent arg0) {
	    // Do nothing
	}

	@Override
	public void windowOpened(final WindowEvent arg0) {
	    // Do nothing
	}
    }

    @Override
    public void handleQuitRequestWith(QuitEvent e, QuitResponse response) {
	boolean result = this.quitHandler();
	if (result) {
	    response.performQuit();
	} else {
	    response.cancelQuit();
	}
    }
}
