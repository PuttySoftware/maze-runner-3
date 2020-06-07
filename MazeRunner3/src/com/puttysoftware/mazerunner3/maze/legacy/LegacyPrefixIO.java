package com.puttysoftware.mazerunner3.maze.legacy;

import java.io.IOException;

import com.puttysoftware.xio.legacy.XLegacyDataReader;

public interface LegacyPrefixIO {
    int readPrefix(XLegacyDataReader reader) throws IOException;
}
