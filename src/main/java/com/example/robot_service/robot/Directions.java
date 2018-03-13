package com.example.robot_service.robot;

import com.example.robot_service.exceptions.InvalidDirectionException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by elmar on 11.03.18.
 */
public class Directions {
    public static final String NORTH = "NORTH";
    public static final String EAST = "EAST";
    public static final String SOUTH = "SOUTH";
    public static final String WEST = "WEST";
    public static final List<String> directionList = Arrays.asList(NORTH, EAST, SOUTH, WEST);
    public static final List<Direction> stepList = Arrays
            .asList(
                    new Direction(0, 1),
                    new Direction(1, 0),
                    new Direction(0, -1),
                    new Direction(-1, 0)
            );
    private int value;

    public Directions(String direction) throws InvalidDirectionException {
        if (direction == null)
            throw new InvalidDirectionException();

        value = directionList.indexOf(direction);
        if (value == -1)
            throw new InvalidDirectionException();
    }

    public void turnRight() {
        value = (value + 1) % directionList.size();
    }

    public void turnLeft() {
        if (--value < 0)
            value = directionList.size() - 1;
    }

    public String getDirection() {
        return directionList.get(value);
    }

    public int getStepDx() {
        return stepList.get(value).getDx();
    }

    public int getStepDy() {
        return stepList.get(value).getDy();
    }

    public static class Direction {
        private int dx, dy;

        public Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int getDx() {
            return dx;
        }

        public void setDx(int dx) {
            this.dx = dx;
        }

        public int getDy() {
            return dy;
        }

        public void setDy(int dy) {
            this.dy = dy;
        }
    }
}
