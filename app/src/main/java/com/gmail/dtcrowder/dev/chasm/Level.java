package com.gmail.dtcrowder.dev.chasm;

/**
 * Created by David Crowder on 11/3/2016.
 */

public interface Level {

    int[][][] mGridImages = {};    // x, y, z values of the grid

    int[][][] mHeroImages = {};    // initial location of hero(es)

    int[][][] mEnemyImages = {};   // initial location of enemies
    
    // // TODO: 11/4/2016 Add methods for pulling info from SQLite.

    // Insert SQL query here
    int[][][] fetchLevel();




}
