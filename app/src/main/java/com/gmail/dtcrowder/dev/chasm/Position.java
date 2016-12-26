package com.gmail.dtcrowder.dev.chasm;

import android.annotation.SuppressLint;
import android.util.Log;

/**
 * Position is an general use object that contains 3D coordinates.
 * This object is used in collections to represent a position in the game.
 * Simply create a position object by passing in the initial coordinates.
 * The fields are meant to be updated for iteration purposes.
 *
 * Created by David Crowder on 11/27/2016.
 */

class Position extends MoveCommand implements Comparable<Position> {

    private int mX;
    private int mY;
    private int mZ;


    private static final String TAG = "Position";

    public Position(int x, int y, int z) {
        mX = x;
        mY = y;
        mZ = z;
    }

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public int getZ() {
        return mZ;
    }

    public void setZ(int z) {
        mZ = z;
    }




    /** This implementation of compareTo aims to organize the order of the position
     *  so the collection can create a natural order where Z, Y, X are the most critical fields
     *  in descending order.
     *
     */


    // TODO: 11/27/2016  Run unit test

    @Override
    public int compareTo(Position p) {

        try {

            if (mZ > p.getZ()) {
                return 1;
            }
            else if (mZ < p.getZ()) {
                return -1;
            }
            else {
                if (mY > p.getY()) {
                    return 1;
                }
                else if (mY < p.getY()) {
                    return -1;
                }
                else {
                    if (mX > p.getX()) {
                        return 1;
                    }
                    else if (mX < p.getX()) {
                        return -1;
                    }
                    else {
                        return 0;
                    }
                }
            }

        } catch (ClassCastException cce) {
                Log.e(TAG, "compareTo incorrect cast");
                return 2;                                   // out of bounds
        }

    }

    @Override
    public String toString() {
        return "Pos: (" + mX + ", " + mY + ", " + mZ + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += mX*7499 + mY*127 + mZ*17;        // Creates a unique hash based on position and large prime numbers
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        // check if they're the same object first
        if (!(obj instanceof Position)) {
            return false;
        }

        // upcast object as a position
        Position pos = (Position) obj;

        // ensure hashcodes are the same
        if (hashCode() != pos.hashCode()) {
            return false;
        }

        // ensure position values are the same
        if (pos.getX() == mX) {
            if (pos.getY() == mY) {
                if (pos.getZ() == mZ) {
                    return true;
                }      // return true iff all values match
            }
        } else {
            return false;
        }                          // otherwise return false

        return false;
    }

}
