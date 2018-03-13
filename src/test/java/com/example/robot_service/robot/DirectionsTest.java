package com.example.robot_service.robot;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by elmar on 11.03.18.
 */
public class DirectionsTest {
    @Test
    public void turnRight() throws Exception {
        Directions d = new Directions(Directions.NORTH);
        assertEquals(Directions.NORTH, d.getDirection());
        assertEquals(0, d.getStepDx());
        assertEquals(1, d.getStepDy());

        d.turnRight();
        assertEquals(Directions.EAST, d.getDirection());
        assertEquals(1, d.getStepDx());
        assertEquals(0, d.getStepDy());

        d.turnRight();
        assertEquals(Directions.SOUTH, d.getDirection());
        assertEquals(0, d.getStepDx());
        assertEquals(-1, d.getStepDy());

        d.turnRight();
        assertEquals(Directions.WEST, d.getDirection());
        assertEquals(-1, d.getStepDx());
        assertEquals(0, d.getStepDy());
    }

    @Test
    public void turnLeft() throws Exception {
        Directions d = new Directions(Directions.NORTH);
        assertEquals(Directions.NORTH, d.getDirection());
        assertEquals(0, d.getStepDx());
        assertEquals(1, d.getStepDy());

        d.turnLeft();
        assertEquals(Directions.WEST, d.getDirection());
        assertEquals(-1, d.getStepDx());
        assertEquals(0, d.getStepDy());

        d.turnLeft();
        assertEquals(Directions.SOUTH, d.getDirection());
        assertEquals(0, d.getStepDx());
        assertEquals(-1, d.getStepDy());

        d.turnLeft();
        assertEquals(Directions.EAST, d.getDirection());
        assertEquals(1, d.getStepDx());
        assertEquals(0, d.getStepDy());
    }

}