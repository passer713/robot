package com.example.robot_service.robot;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by elmar on 11.03.18.
 */
public class RobotTest {
    @Test
    public void moveTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("PLACE 0,0,NORTH", "MOVE", "REPORT"));
        assertEquals("0,1,NORTH", robot.getResultState());
    }

    @Test
    public void turnTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("PLACE 0,0,NORTH", "LEFT", "REPORT"));
        assertEquals("0,0,WEST", robot.getResultState());
    }

    @Test
    public void moveAndTurnTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("PLACE 1,2,EAST",
                "MOVE",
                "MOVE",
                "LEFT",
                "MOVE",
                "REPORT"));
        assertEquals("3,3,NORTH", robot.getResultState());
    }

    @Test
    public void notActiveTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("MOVE", "REPORT"));
        assertEquals("ROBOT MISSING", robot.getResultState());
    }

    @Test
    public void outOfDescTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("PLACE 0,0,NORTH", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT"));
        assertEquals("0,4,NORTH", robot.getResultState());
    }

    @Test
    public void invalidStartTest() throws Exception {
        Robot robot = new Robot("ROBOT MISSING", 5, 5);
        robot.execute(Arrays.asList("PLACE 6,0,NORTH", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT"));
        assertEquals("ROBOT MISSING", robot.getResultState());
    }
}