package com.example.MarsRover.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MarsRover.dto.CreateRoverRequest;
import com.example.MarsRover.dto.MoveRoverRequest;
import com.example.MarsRover.model.Rover;
import com.example.MarsRover.service.*;


import java.util.*;

	@RestController
	public class RoverController {
	    private final RoverService roverService;

	    public RoverController(RoverService roverService) {
	        this.roverService = roverService;
	    }

	    @PostMapping("/rovers")
	    public ResponseEntity<Rover> createRover(@RequestBody CreateRoverRequest request) {
	        Rover rover = roverService.createRover(request.getX(), request.getY(), request.getDirection());
	        return new ResponseEntity<>(rover, HttpStatus.CREATED);
	    }

	    @GetMapping("/rovers/{name}/position")
	    public ResponseEntity<Rover> getCurrentPosition(@PathVariable String name) {
	        Rover rover = roverService.getCurrentPosition(name);
	        if (rover == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(rover, HttpStatus.OK);
	    }

	    @PostMapping("/rovers/{name}/move")
	    public ResponseEntity<Rover> moveRover(@PathVariable String name, @RequestBody MoveRoverRequest request) {
	        Rover rover = roverService.moveRover(name, request.getCommands());
	        return new ResponseEntity<>(rover, HttpStatus.OK);
	    }
	}
