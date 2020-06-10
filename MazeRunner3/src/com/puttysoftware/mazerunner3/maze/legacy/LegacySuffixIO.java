package com.puttysoftware.mazerunner3.maze.legacy;

import java.io.IOException;

import com.puttysoftware.mazerunner3.legacyxio.XLegacyDataReader;

public interface LegacySuffixIO {
    void readSuffix(XLegacyDataReader reader, int formatVersion) throws IOException;
}
