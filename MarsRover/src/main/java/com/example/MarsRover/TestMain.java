package com.example.MarsRover;

import com.example.MarsRover.model.Direction;
import com.example.MarsRover.model.Rover;
import com.example.MarsRover.service.RoverService;
import com.example.MarsRover.service.RoverServiceImpl;

public class TestMain {
	  public static void main(String[] args) {
	        RoverService roverService = new RoverServiceImpl();

	        // Create and initialize multiple rovers
	        Rover rover1 = roverService.createRover(3, 4, Direction.NORTH);
	        Rover rover2 = roverService.createRover(5, 6, Direction.EAST);

	        // Move each rover independently
	        roverService.moveRover(rover1.getName(), "ffrff");
	        roverService.moveRover(rover2.getName(), "fbbfrf");

	        // Get the current positions of the rovers
	        System.out.println(roverService.getCurrentPosition(rover1.getName()));
	        System.out.println(roverService.getCurrentPosition(rover2.getName()));
	    }
}
