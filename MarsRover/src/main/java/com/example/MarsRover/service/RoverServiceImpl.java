package com.example.MarsRover.service;

import org.springframework.stereotype.Service;

import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Rover;
import com.example.MarsRover.service.RoverService;
import java.util.*;


@Service
public class RoverServiceImpl implements RoverService {
    private List<Rover> rovers = new ArrayList<>();

    @Override
    public Rover createRover(int x, int y, Direction direction) {
        String name = "R" + (rovers.size() + 1);
        System.out.println("name"+name);
        Rover rover = new Rover(name, x, y, direction);
        rovers.add(rover);
        return rover;
    }

    @Override
    public Rover getCurrentPosition(String name) {
        return rovers.stream()
                .filter(rover -> rover.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Rover moveRover(String name, String commands) {
        Rover rover = rovers.stream()
                .filter(r -> r.getName().equals(name))
                .findFirst()
                .orElse(null);

        if (rover == null) {
            throw new IllegalArgumentException("Rover not found: " + name);
        }

        int initialX = rover.getX();
        int initialY = rover.getY();

        commands.chars().forEach(command -> {
            int prevX = rover.getX();
            int prevY = rover.getY();

            switch (command) {
                case 'f':
                    rover.moveForward();
                    break;
                case 'b':
                    rover.moveBackward();
                    break;
                case 'r':
                    rover.rotateClockwise();
                    break;
                case 'l':
                    rover.rotateAntiClockwise();
                    break;
                case ',':
                    break;
                default:
                    // Handle invalid command (for example, log the invalid command)
                    System.out.println("Invalid command: " + (char) command);
                    break;
            }

            if (hasCollision(rover)) {
                // Revert last movement to avoid collision
                rover.setX(prevX);
                rover.setY(prevY);

                // Handle collision based on requirements (e.g., stop further commands)
                return;
            }
        });

        return rover;
    }

    @Override
    public boolean hasCollision(Rover rover) {
        return rovers.stream()
                .anyMatch(otherRover -> !rover.equals(otherRover) &&
                        rover.getX() == otherRover.getX() &&
                        rover.getY() == otherRover.getY());
    }

	
}
