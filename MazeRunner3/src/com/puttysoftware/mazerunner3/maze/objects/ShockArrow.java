/*  MazeRunnerII: A Maze-Solving Game
Copyright (C) 2008-2010 Eric Ahnell

Any questions should be directed to the author via email at: MazeRunnerII@worldwizard.net
 */
package com.puttysoftware.mazerunner3.maze.objects;

import com.puttysoftware.mazerunner3.maze.abc.AbstractTransientObject;
import com.puttysoftware.mazerunner3.maze.utilities.ColorConstants;

public class ShockArrow extends AbstractTransientObject {
    // Constructors
    public ShockArrow() {
        super("Shock Arrow", ColorConstants.COLOR_LIGHT_YELLOW);
    }
}
