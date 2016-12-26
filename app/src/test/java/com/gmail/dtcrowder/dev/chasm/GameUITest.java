package com.gmail.dtcrowder.dev.chasm;

import android.os.Build;
import android.support.v4.*;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Array;
import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment;

/**
 * Created by David Crowder on 12/16/2016.
 */



@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class GameUITest {
    private GameActivity mGameActivity;
    private GameFragment mGameFragment;
    private LevelEngineer mEngineer;
    private Hero mHero;
    private Level mLevel;
    private ArrayMap<Position, Integer> mGrid;
    private final int TEST_LEVEL_INDEX = 0;

    @Before
    public void SetUp() throws Exception {
        mGameActivity = Robolectric.setupActivity(GameActivity.class);
        mGameFragment = new GameFragment();
        startFragment(mGameFragment);
        mHero = new Hero(UUID.randomUUID());
        mLevel = new Level(TEST_LEVEL_INDEX);
        mEngineer = new LevelEngineer(mLevel, mHero);
        mEngineer.orderGrid();
        mGrid = mEngineer.getGrid();
    }

    @Test
    public void GameActivityNotNull() {
        assertNotNull(mGameActivity);
    }

    @Test
    public void GameFragmentNotNull() {
        assertNotNull(mGameFragment);
    }

    @Test
    public void CurrentPosNotNullAfterMove() {
        AppCompatImageButton button = (AppCompatImageButton) mGameFragment.getView().findViewById(R.id.command6);
        button.performClick();
        Integer result = mGrid.get(mHero.getCurrentPosition());
        assertNotNull(result);
    }

}
