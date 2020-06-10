/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2012 Eric Ahnell

Any questions should be directed to the author via email at: products@puttysoftware.com
 */
package com.puttysoftware.mazerunner3.editor.rulesets;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.puttysoftware.diane.gui.CommonDialogs;
import com.puttysoftware.mazerunner3.Application;
import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.xio.XDataReader;

public class RuleSetLoadTask extends Thread {
    // Fields
    private final String filename;

    // Constructors
    public RuleSetLoadTask(final String file) {
	this.filename = file;
	this.setName("Rule Set File Reader");
    }

    // Methods
    @Override
    public void run() {
	final Application app = Boot.getApplication();
	final String sg = "Rule Set";
	try (XDataReader ruleSetFile = new XDataReader(this.filename, "ruleset")) {
	    final int magic = ruleSetFile.readInt();
	    if (magic == RuleSetConstants.MAGIC_NUMBER_2) {
		// Format 2 file
		app.getObjects().readRuleSet(ruleSetFile, RuleSetConstants.FORMAT_2);
	    }
	    CommonDialogs.showTitledDialog(sg + " file loaded.", "Rule Set Picker");
	} catch (final FileNotFoundException fnfe) {
	    CommonDialogs.showDialog("Loading the " + sg.toLowerCase()
		    + " file failed, probably due to illegal characters in the file name.");
	    app.getMazeManager().handleDeferredSuccess(false);
	} catch (final IOException ie) {
	    CommonDialogs.showDialog(ie.getMessage());
	    app.getMazeManager().handleDeferredSuccess(false);
	} catch (final Exception ex) {
	    Boot.getErrorLogger().logError(ex);
	}
    }
}
