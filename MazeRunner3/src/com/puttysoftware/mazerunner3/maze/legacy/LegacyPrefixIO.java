package com.puttysoftware.mazerunner3.maze.legacy;

import java.io.IOException;

import com.puttysoftware.mazerunner3.legacyxio.XLegacyDataReader;

public interface LegacyPrefixIO {
    int readPrefix(XLegacyDataReader reader) throws IOException;
}
