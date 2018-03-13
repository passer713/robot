package com.example.robot_service.robot;

import com.example.robot_service.exceptions.InvalidDirectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Created by elmar on 08.03.18.
 */
public class Robot {
    private static final Logger LOG = LoggerFactory.getLogger(Robot.class);
    private int x, y;
    private Directions facing;
    private boolean isActive = false;

    private String resultState;
    private final int descWidth;
    private final int descHeight;
    Map<String, Consumer<String[]>> commandImplemantations = new HashMap<>();


    public Robot(String initialState, int descWidth, int descHeight) {
        this.resultState = initialState;
        this.descWidth = descWidth;
        this.descHeight = descHeight;

        commandImplemantations.put("PLACE", this::placeCommand);
        commandImplemantations.put("MOVE", this::moveCommand);
        commandImplemantations.put("LEFT", this::leftCommand);
        commandImplemantations.put("RIGHT", this::rightCommand);
        commandImplemantations.put("REPORT", this::reportCommand);
    }

    public String execute(List<String> commands) {
        commands.forEach(this::executeCommand);
        return resultState;
    }

    private void executeCommand(String command) {
        String[] s = command.split(" ");

        if (commandImplemantations.containsKey(s[0]))
            commandImplemantations.get(s[0]).accept(s);
    }

    private void reportCommand(String[] strings) {
        if (isActive) {
            resultState = String.format("%d,%d,%s", x, y, facing.getDirection());
        }
    }

    private void rightCommand(String[] strings) {
        if (isActive)
            facing.turnRight();
    }

    private void leftCommand(String[] strings) {
        if (isActive)
            facing.turnLeft();
    }

    private void moveCommand(String[] strings) {
        if (isActive) {
            setPositions(x + facing.getStepDx(), y + facing.getStepDy());
        }
    }

    private void placeCommand(String[] strings) {
        if (strings.length < 2)
            return;//as I understand service ignores invalid commands.

        String[] params = strings[1].split(",");
        if (params.length < 3)
            return;

        try {
            if(!setPositions(Integer.parseInt(params[0].trim()), Integer.parseInt(params[1].trim())))
                return;

            facing = new Directions(params[2].trim());

            isActive = true;
        } catch (InvalidDirectionException | NumberFormatException e) {
            LOG.warn("Invalidcommand parameters", e);//as I understand service ignores invalid commands.
        }
    }

    public String getResultState() {
        return resultState;
    }

    private boolean setPositions(int newX, int newY) {
        if (newX >= 0 && newX < descWidth
                && newY >= 0 && newY < descHeight) {
            this.x = newX;
            this.y = newY;
            return true;
        }
        return false;
    }
}
