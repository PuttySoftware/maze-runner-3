/*  MazeRunnerII: A Scenario Editor
Copyright (C) 2011-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.editor.namer.abc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.editor.namer.EditorProperties;
import com.puttysoftware.mazerunner3.loader.ImageTransformer;
import com.puttysoftware.mazerunner3.loader.LogoImageLoader;

public abstract class AbstractEditor implements EditorProperties {
    // Fields
    private final String source;
    private JFrame outputFrame;
    private Container borderPane;
    private Container outputPane;
    private JLabel messageLabel;
    private JScrollPane scrollPane;
    private boolean objectChanged;
    private final int editorID;
    private boolean readOnly;

    protected AbstractEditor(final String newSource, final int newEditorID) {
	this.source = newSource;
	this.objectChanged = true;
	this.editorID = newEditorID;
    }

    // Methods from EditorProperties
    @Override
    public final String getEditorSource() {
	return this.source;
    }

    // Methods
    public final boolean didObjectChange() {
	return this.objectChanged;
    }

    public final void objectChanged() {
	this.objectChanged = true;
    }

    public final void edit() {
	final Application app = Game.getApplication();
	app.getGUIManager().hideGUI();
	app.setInEditor();
	app.setCurrentEditor(this.editorID);
	// Create the managers
	if (this.objectChanged) {
	    this.loadObject();
	    this.editObjectChanged();
	    this.objectChanged = false;
	}
	this.setUpGUI();
	// Make sure message area is attached to border pane
	this.borderPane.removeAll();
	this.borderPane.add(this.messageLabel, BorderLayout.NORTH);
	this.borderPane.add(this.outputPane, BorderLayout.CENTER);
	this.borderPaneHook();
	this.showOutput();
	app.notifyAllNonCurrentEditorsDisableCommands();
	this.redrawEditor();
    }

    public final boolean create() {
	if (AbstractEditor.usesImporter()) {
	    this.newObjectOptions();
	    return true;
	} else {
	    boolean success = true;
	    if (this.newObjectOptions()) {
		success = this.newObjectCreate();
		if (success) {
		    this.saveObject();
		    this.objectChanged = true;
		}
		return success;
	    }
	    return false;
	}
    }

    private final void showOutput() {
	final Application app = Game.getApplication();
	this.outputFrame.setJMenuBar(app.getMenuManager().getMainMenuBar());
	app.getMenuManager().setEditorMenus();
	this.outputFrame.setVisible(true);
	this.outputFrame.pack();
    }

    private final void hideOutput() {
	if (this.outputFrame != null) {
	    this.outputFrame.setVisible(false);
	}
    }

    public final boolean isReadOnly() {
	return this.readOnly;
    }

    public final void exitEditor() {
	final Application app = Game.getApplication();
	app.notifyAllNonCurrentEditorsEnableCommands();
	// Save changes
	this.saveObject();
	// Hide the editor
	this.hideOutput();
	Game.getApplication().getGUIManager().showGUI();
    }

    private static boolean usesImporter() {
	return false;
    }

    public abstract JMenu createEditorCommandsMenu();

    public abstract void enableEditorCommands();

    public abstract void disableEditorCommands();

    public abstract void handleCloseWindow();

    protected abstract boolean doesObjectExist();

    protected abstract boolean newObjectOptions();

    protected abstract boolean newObjectCreate();

    protected abstract void editObjectChanged();

    protected abstract void borderPaneHook();

    protected abstract void loadObject();

    protected abstract void saveObject();

    protected abstract void setUpGUIHook(Container output);

    protected abstract void reSetUpGUIHook(Container output);

    protected abstract WindowListener guiHookWindow();

    public abstract void switchToSubEditor();

    public abstract void switchFromSubEditor();

    public abstract void redrawEditor();

    private void setUpGUI() {
	// Destroy the old GUI, if one exists
	if (this.outputFrame != null) {
	    this.outputFrame.dispose();
	}
	this.messageLabel = new JLabel(" ");
	this.outputFrame = new JFrame(this.getEditorSource());
	final Image iconlogo = LogoImageLoader.getIconLogo();
	this.outputFrame.setIconImage(iconlogo);
	this.outputPane = new Container();
	this.borderPane = new Container();
	this.borderPane.setLayout(new BorderLayout());
	this.outputFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	this.setUpGUIHook(this.outputPane);
	this.scrollPane = new JScrollPane(this.borderPane);
	this.borderPane.add(this.outputPane, BorderLayout.CENTER);
	this.borderPane.add(this.messageLabel, BorderLayout.NORTH);
	this.outputFrame.setResizable(false);
	final WindowListener wl = this.guiHookWindow();
	if (wl != null) {
	    this.outputFrame.addWindowListener(wl);
	}
	this.outputFrame.setContentPane(this.scrollPane);
	this.outputFrame.pack();
	if (this.outputFrame.getWidth() > ImageTransformer.MAX_WINDOW_SIZE
		|| this.outputFrame.getHeight() > ImageTransformer.MAX_WINDOW_SIZE) {
	    int pw, ph;
	    if (this.outputFrame.getWidth() > ImageTransformer.MAX_WINDOW_SIZE) {
		pw = ImageTransformer.MAX_WINDOW_SIZE;
	    } else {
		pw = this.scrollPane.getWidth();
	    }
	    if (this.outputFrame.getHeight() > ImageTransformer.MAX_WINDOW_SIZE) {
		ph = ImageTransformer.MAX_WINDOW_SIZE;
	    } else {
		ph = this.scrollPane.getHeight();
	    }
	    this.scrollPane.setPreferredSize(new Dimension(pw, ph));
	}
    }

    public void reSetUpGUI() {
	// Destroy the old GUI, if one exists
	if (this.outputFrame != null) {
	    this.outputFrame.dispose();
	}
	this.messageLabel = new JLabel(" ");
	this.outputFrame = new JFrame(this.getEditorSource());
	final Image iconlogo = LogoImageLoader.getIconLogo();
	this.outputFrame.setIconImage(iconlogo);
	this.outputPane = new Container();
	this.borderPane = new Container();
	this.borderPane.setLayout(new BorderLayout());
	this.outputFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	this.reSetUpGUIHook(this.outputPane);
	this.scrollPane = new JScrollPane(this.borderPane);
	this.borderPane.add(this.outputPane, BorderLayout.CENTER);
	this.borderPane.add(this.messageLabel, BorderLayout.NORTH);
	this.outputFrame.setResizable(false);
	final WindowListener wl = this.guiHookWindow();
	if (wl != null) {
	    this.outputFrame.addWindowListener(wl);
	}
	this.outputFrame.setContentPane(this.scrollPane);
	this.outputFrame.pack();
	if (this.outputFrame.getWidth() > ImageTransformer.MAX_WINDOW_SIZE
		|| this.outputFrame.getHeight() > ImageTransformer.MAX_WINDOW_SIZE) {
	    int pw, ph;
	    if (this.outputFrame.getWidth() > ImageTransformer.MAX_WINDOW_SIZE) {
		pw = ImageTransformer.MAX_WINDOW_SIZE;
	    } else {
		pw = this.scrollPane.getWidth();
	    }
	    if (this.outputFrame.getHeight() > ImageTransformer.MAX_WINDOW_SIZE) {
		ph = ImageTransformer.MAX_WINDOW_SIZE;
	    } else {
		ph = this.scrollPane.getHeight();
	    }
	    this.scrollPane.setPreferredSize(new Dimension(pw, ph));
	}
    }
}
