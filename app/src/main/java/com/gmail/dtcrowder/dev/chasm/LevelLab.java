package com.gmail.dtcrowder.dev.chasm;

import android.support.v4.util.SparseArrayCompat;

/**
 * Created by David Crowder on 11/3/2016.
 *
 * LevelLab currently holds the values of the current level.
 *
 * This will initially be held in sqlite but will be moved to firebase (11/3/16).
 */

public class LevelLab {

    private int LevelIndex;
    private SparseArrayCompat<Level> Levels;

}
