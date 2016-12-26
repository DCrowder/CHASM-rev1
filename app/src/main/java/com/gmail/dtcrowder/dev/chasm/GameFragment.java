package com.gmail.dtcrowder.dev.chasm;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.text.Layout;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by David Crowder on 10/28/2016.
 */
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static android.view.MotionEvent.ACTION_BUTTON_PRESS;
import static android.view.View.GONE;

public class GameFragment extends Fragment {

    private Hero mMainHero;
    private MoveCommand mMoveCommand;
    private LevelEngineer mEngineer;
    private ArrayMap<Position, Integer> mGrid;
    private GridLayout mGridLayout;
    private Level mCurrentLevel;
    private int mIndex = 0;

    public final String TAG = "Grid";
    //private ImageView mTile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Load initial level view

        mMainHero = new Hero(UUID.randomUUID());
        mCurrentLevel = new Level(mIndex);


        View v = inflater.inflate(R.layout.fragment_game, container, false);

        for (MoveButton mb : MoveButton.values()) {
            AppCompatImageButton imageButton = (AppCompatImageButton) v.findViewById(mb.mResId);
            newListener(imageButton, mb.mIndex);
        }



        mEngineer = new LevelEngineer(mCurrentLevel, mMainHero);
        mEngineer.orderGrid();
        //mEngineer.orderHeroes();
        //mEngineer.orderEnemies();
        mGrid = mEngineer.getGrid();
        mGridLayout = (GridLayout) v.findViewById(R.id.LevelGrid);
        Position pos = mMainHero.getCurrentPosition();

        /**



         for (int j = pos.getY()-4; j < pos.getY()+4; j++) {
         for (int i = pos.getX()-4; i < pos.getX()+4; i++) {
         ImageView mTile = (ImageView) inflater.inflate(R.layout.tile, container, false);
         mCurrentTile = mGrid.get(new Position(i, j, 0));

         mTile.setImageResource(mCurrentTile);
         mGridLayout.addView(mTile);
         }

         }

         pos.setX(pos.getX()-4);
         pos.setY(pos.getY()-4);
         for (int j = 0; j < 9; j++) {
         for (int i = 0; i < 9; i++) {
         ImageView mTile = (ImageView) inflater.inflate(R.layout.tile, container, false);
         mCurrentTile = mGrid.get(new Position(i, j, 0));

         mTile.setImageResource(mCurrentTile);
         mGridLayout.addView(mTile);

         }
         pos.setY(pos.getY()+1);
         pos.setX(pos.getX()-9);
         }

         ORIGINAL CODE DO NOT MODIFY:
         pos.setX(pos.getX()-4);
         pos.setY(pos.getY()-4);
         for (int j = 0; j < 9; j++) {
         for (int i = 0; i < 9; i++) {

         ImageView mTile = (ImageView) inflater.inflate(R.layout.tile, container, false);
         Log.d(TAG, "Current tile: " + mGrid.get(pos));
         mCurrentTile = mGrid.get(pos);

         mTile.setImageResource(mCurrentTile);
         mGridLayout.addView(mTile);
         pos.setX(pos.getX()+1);

         }
         }

         */

        Log.d(TAG, pos.toString());
        Integer mCurrentTile;

        for (int j = pos.getY()+4; j > pos.getY()-5; j--) {
            for (int i = pos.getX()-4; i < pos.getX()+5; i++) {

                ImageView mTile = (ImageView) inflater.inflate(R.layout.tile, container, false);

                Position mCurrentPos = new Position(i, j, 0);
                Log.d(TAG, mCurrentPos.toString());
                mCurrentTile = mGrid.get(mCurrentPos);

                mTile.setImageResource(mCurrentTile);
                mGridLayout.addView(mTile);

            }
        }

        return v;
    }

    private void newListener(AppCompatImageButton button, int command) {
        button.setOnClickListener(new MoveOnClickListener(command));
    }

    private void updateUI(Position p) {

        int index = 0;
        Position pos = mMainHero.getCurrentPosition();

        Integer mCurrentTile;

        for (int j = pos.getY()+4; j > pos.getY()-5; j--) {
            for (int i = pos.getX()-4; i < pos.getX()+5; i++) {
                Position mCurrentPos = new Position(i, j, 0);
                ImageView mTile = (ImageView) mGridLayout.getChildAt(index);
                Log.d(TAG, "(i,j): (" + i + "," + j + " ). mCurrentPos " + mCurrentPos.toString() + ". pos " + pos.toString() + " -> equals(): " + pos.equals(mCurrentPos));
                mCurrentTile = mGrid.get(mCurrentPos);
                //mCurrentTile = mGrid.get(mCurrentPos);
                if (mTile != null){
                    mTile.setVisibility(View.INVISIBLE);
                    if (mCurrentTile != null) {
                        mTile.setVisibility(View.VISIBLE);
                        mTile.setImageResource(mCurrentTile);
                    }
                }
                index++;
            }
        }

        mGridLayout.invalidate();
    }


    class MoveOnClickListener implements View.OnClickListener {

        private int mCommand;
        private MoveCommand mMoveCommand;

        private MoveOnClickListener(int command) {
            mCommand = command;
            mMoveCommand = new MoveCommand();
        }

        @Override
        public void onClick(View v) {
            Position newPos = mMoveCommand.nextPosition(mMainHero.getCurrentPosition(), mCommand);

            mMainHero.setCurrentPosition(newPos);
            updateUI(mMainHero.getCurrentPosition());

        }



    }

    public enum MoveButton {
        BUTTON0 (R.id.command0, 0),
        BUTTON1 (R.id.command1, 1),
        BUTTON2 (R.id.command2, 2),
        BUTTON3 (R.id.command3, 3),
        BUTTON4 (R.id.command4, 4),
        BUTTON5 (R.id.command5, 5),
        BUTTON6 (R.id.command6, 6),
        BUTTON7 (R.id.command7, 7),
        BUTTON8 (R.id.command8, 8),
        BUTTON9 (R.id.command9, 9);

        private final int mResId;
        private final int mIndex;

        MoveButton(int resId, int index) {
            mResId = resId;
            mIndex = index;
        }
    }

}



