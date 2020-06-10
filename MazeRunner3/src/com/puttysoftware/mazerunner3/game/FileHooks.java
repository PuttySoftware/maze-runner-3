package com.puttysoftware.mazerunner3.game;

import java.io.IOException;

import com.puttysoftware.mazerunner3.creatures.party.PartyManager;
import com.puttysoftware.mazerunner3.legacyxio.XLegacyDataReader;
import com.puttysoftware.xio.XDataReader;
import com.puttysoftware.xio.XDataWriter;

public class FileHooks {
    private FileHooks() {
	// Do nothing
    }

    public static void loadLegacyGameHook(final XLegacyDataReader mapFile) throws IOException {
	PartyManager.loadLegacyGameHook(mapFile);
    }

    public static void loadGameHook(final XDataReader mapFile) throws IOException {
	PartyManager.loadGameHook(mapFile);
    }

    public static void saveGameHook(final XDataWriter mapFile) throws IOException {
	PartyManager.saveGameHook(mapFile);
    }
}
