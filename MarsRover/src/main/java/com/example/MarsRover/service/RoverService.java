package com.example.MarsRover.service;

import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Rover;

public interface RoverService {
   Rover getCurrentPosition(String name);

    Rover moveRover(String name, String commands);

	boolean hasCollision(Rover rover);

	Rover createRover(int x, int y, Direction direction);
}