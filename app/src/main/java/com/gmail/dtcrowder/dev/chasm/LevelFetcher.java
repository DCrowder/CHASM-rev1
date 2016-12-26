package com.gmail.dtcrowder.dev.chasm;

import android.support.v4.util.ArrayMap;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by David Crowder on 11/13/2016.
 *
 * LevelFetcher reads information from Firebase to add a level to code.
 *
 * This should only run when the level is being created in code.
 */
public class LevelFetcher {

    private ArrayMap<Position, Integer> mGrid;
    private DatabaseReference mDatabase;



    public LevelFetcher(int LevelIndex) {

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }



}
