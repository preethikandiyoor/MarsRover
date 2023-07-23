package com.example.MarsRover.model;

public class Rover {
    @Override
	public String toString() {
		return "Rover [name=" + name + ", x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}

	private String name;
    private int x;
    private int y;
    private Direction direction;

    // Constructor
    public Rover(String name, int x, int y, Direction direction) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    // Move methods

    public void moveForward() {
        // Implement the logic to move forward in the current direction
    	switch (direction) {
        case NORTH:
            y++;
            break;
        case EAST:
            x++;
            break;
        case SOUTH:
            y--;
            break;
        case WEST:
            x--;
            break;
    }
    }

    public void moveBackward() {
    	 switch (direction) {
         case NORTH:
             y--;
             break;
         case EAST:
             x--;
             break;
         case SOUTH:
             y++;
             break;
         case WEST:
             x++;
             break;
     }
    }

    public void rotateClockwise() {
    	switch (direction) {
        case NORTH:
            direction = Direction.EAST;
            break;
        case EAST:
            direction = Direction.SOUTH;
            break;
        case SOUTH:
            direction = Direction.WEST;
            break;
        case WEST:
            direction = Direction.NORTH;
            break;
        default:
            // Handle invalid direction (optional)
            break;
    }
    }

    public void rotateAntiClockwise() {
        // Implement the logic to rotate 90 degrees counterclockwise
    	 switch (direction) {
         case NORTH:
             direction = Direction.WEST;
             break;
         case WEST:
             direction = Direction.SOUTH;
             break;
         case SOUTH:
             direction = Direction.EAST;
             break;
         case EAST:
             direction = Direction.NORTH;
             break;
         default:
             // Handle invalid direction (optional)
             break;
     }
 }

	public void setName(String name) {
		this.name = name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}






