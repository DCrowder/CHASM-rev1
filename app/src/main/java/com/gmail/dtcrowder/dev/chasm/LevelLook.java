package com.gmail.dtcrowder.dev.chasm;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.SparseArray;
import android.util.SparseIntArray;

/**
 * Created by David Crowder on 11/3/2016.
 */

interface LevelLook {

    int[][][] getGrid();                    // returns the entire grid as an int array
    void setGrid(int key);                  // takes the key of the Levels SparseArrayCompat to load the grid


    void getCurrentGrid();                  // returns the 9x9 grid currently in view
    void setCurrentGrid(Position position);      // sets the 9x9 grid currently in view

    void setHeroes(int key);                // takes the key of the Levels SparseArrayCompat to load the grid
    void getHeroes();

    void setVillains(int key);              // loads initial villains
    int[] getVillains();

    int[] getPosition();                    // returns current position
    void setPosition(int command);         // sets current position



}
