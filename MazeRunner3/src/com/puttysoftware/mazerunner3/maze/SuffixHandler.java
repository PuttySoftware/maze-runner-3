package com.puttysoftware.mazerunner3.maze;

import java.io.IOException;

import com.puttysoftware.mazerunner3.Boot;
import com.puttysoftware.xio.XDataReader;
import com.puttysoftware.xio.XDataWriter;

public class SuffixHandler implements SuffixIO {
    @Override
    public void readSuffix(final XDataReader reader, final int formatVersion) throws IOException {
	Boot.getApplication().getGameManager().loadGameHook(reader, formatVersion);
    }

    @Override
    public void writeSuffix(final XDataWriter writer) throws IOException {
	Boot.getApplication().getGameManager().saveGameHook(writer);
    }
}
