package com.puttysoftware.mazerunner3.maze.legacy;

import java.io.IOException;

import com.puttysoftware.mazerunner3.Game;
import com.puttysoftware.mazerunner3.legacyxio.XLegacyDataReader;

public class LegacySuffixHandler implements LegacySuffixIO {
    @Override
    public void readSuffix(final XLegacyDataReader reader, final int formatVersion) throws IOException {
	Game.getApplication().getGameManager().loadLegacyGameHook(reader, formatVersion);
    }
}
