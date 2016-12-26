package com.gmail.dtcrowder.dev.chasm;

import android.util.Log;

import java.io.PipedOutputStream;

/**
 * Created by David Crowder on 11/30/2016.
 */

public class MoveCommand {

    private final static String TAG = "MoveCommand";

    public MoveCommand() {

    }

    public Position nextPosition(Position position, int command) {

        /** the position command is based on the numpad:
         *            ^ fore
         * < port       x      starboard >
         *            v aft
         *
         * 789
         * 456
         * 123
         *  0
         */

        Position p;

        boolean mValid = true;

        // TODO: 11/26/2016 add verification logic to ensure position is only changed in a valid condition

        if (mValid) {

            p = new Position(position.getX(), position.getY(), position.getZ());

            switch (command) {

                case 8: // fore
                    moveFore(p);
                    break;
                case 9: // fore and starboard
                    moveForeSB(p);
                    break;
                case 7: // fore and port
                    moveForePort(p);
                    break;
                case 6: // starboard
                    moveSB(p);
                    break;
                case 4: // port
                    movePort(p);
                    break;

                case 2: // aft
                    moveAft(p);
                    break;
                case 3: // aft and starboard
                    moveAftSB(p);
                    break;
                case 1: // aft and port
                    moveAftPort(p);
                    break;

                case 5: // up
                    moveUp(p);
                    break;
                case 0: // down
                    moveDown(p);
                    break;

                default: // no action if cases not met
                    Log.i(TAG, "No Action taken at " + p.toString());
                    break;

            }

            return p;
        }

        return position;

    }

    void moveFore(Position p) {
        int newY = p.getY()+1;
        p.setY(newY);
    }

    void moveForeSB(Position p) {
        moveFore(p);
        moveSB(p);
    }

    void moveForePort(Position p) {
        moveFore(p);
        movePort(p);
    }
    void moveSB(Position p) {
        int newX = p.getX()+1;
        p.setX(newX);
    }
    void movePort(Position p) {
        int newX = p.getX()-1;
        p.setX(newX);
    }
    void moveAft(Position p) {
        int newY = p.getY()-1;
        p.setY(newY);
    }
    void moveAftSB(Position p) {
        moveAft(p);
        moveSB(p);
    }
    void moveAftPort(Position p) {
        moveAft(p);
        movePort(p);
    }
    void moveUp(Position p) {
        int newZ = p.getZ()+1;
        p.setZ(newZ);
    }
    void moveDown(Position p) {
        int newZ = p.getZ()-1;
        p.setZ(newZ);
    }
}
