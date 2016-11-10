package com.gmail.dtcrowder.dev.chasm;

/**
 * Created by David Crowder on 11/3/2016.
 *
 * LevelLab currently holds the values of the current level.
 *
 * This will initially be held in sqlite but will be moved to firebase (11/3/16).
 */

public class LevelLab implements Level {

    private int[][][] mCurrentLevel;

    private int currentLevel(int index) {
        // Grab from existing fetcher class
        return 0;
    }

    @Override
    public int[][][] fetchLevel() {

        return new int[0][][];
    }
}
