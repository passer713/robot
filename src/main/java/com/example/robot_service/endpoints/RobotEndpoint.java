package com.example.robot_service.endpoints;

import com.example.robot_service.robot.Robot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by elmar on 08.03.18.
 */
@RestController
public class RobotEndpoint {
    private static final Logger LOG = LoggerFactory.getLogger(RobotEndpoint.class);

    @Value("${noRobotResponse:ROBOT MISSING}")
    private String noRobotResponse;
    @Value("${descWidth:5}")
    private int descWidth;
    @Value("${descHeight:5}")
    private int descHeight;

    @RequestMapping(value = "/execute", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String execute(@RequestParam(value = "commands", required = true) List<String> commands) {
        return "Output: " + new Robot(noRobotResponse, descWidth, descHeight).execute(commands);
    }

}
