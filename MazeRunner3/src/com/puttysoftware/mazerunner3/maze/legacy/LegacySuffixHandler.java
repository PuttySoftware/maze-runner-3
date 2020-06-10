package com.puttysoftware.mazerunner3.maze.legacy;

import java.io.IOException;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.xio.legacy.XLegacyDataReader;

public class LegacySuffixHandler implements LegacySuffixIO {
    @Override
    public void readSuffix(final XLegacyDataReader reader, final int formatVersion) throws IOException {
	Boot.getApplication().getGameManager().loadLegacyGameHook(reader, formatVersion);
    }
}
