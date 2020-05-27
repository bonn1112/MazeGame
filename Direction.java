package YosukeAkutsuPP01;

//This class must have the code in the run() method, sub-program/routain to slove the maze;
//seraches for the Java logo based on the provided path/direction algorithm

public class Direction extends Thread{

Maze maze;
Position location;

Direction(Maze maze, Position location) {
	
	this.maze = maze;
	this.location = location;
}

// this is the code part that needs to be programmed by students to solve the maze 
// using the provided path/direction algorithm

public void run(){

	// this is a SAMPLE code of moving the student image in the maze,
	// and updates the information in Position.jav GUI class, append text into the JTextArea object
	// you should delete this code and start your solution, you may just keep the part of updating the information
	// in the Position.java class, appending information into the JTextArea object
	
	
	while(!maze.isDone()) { //create loop
		//Avoid obstacle when moving down on even columns
		if(maze.getCurrCol() % 2 == 0) { //instruction set for even columns
			if (this.maze.moveDown()) { //movement for unblocked column
				location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					{if(this.maze.isDone()) {break;}}
			}
			else if (maze.getCurrRow() != maze.getHeight() - 1)  { //instruction set for obstacles
				this.maze.moveRight(); location.textArea.append("Obstacle found.  Initialize avoidance maneuver." + "\n"+"Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveDown(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveDown(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveLeft(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				if (!this.maze.moveDown() && (maze.getCurrRow() == maze.getHeight() - 1)) { //instruction set for floor boundary
					this.maze.moveRight(); location.textArea.append("Boundary found.  Change direction." + "\n"+"Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
				 	{if(this.maze.isDone()) {break;}}
					}	
				}
			//avoid obstacle when moving up on odd columns
			else if (maze.getCurrRow() == maze.getHeight() - 1) {
				this.maze.moveRight(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
				{if(this.maze.isDone()) {break;}}
			}
		}
		else if (maze.getCurrCol() % 2 == 1 ) { //instruction set for odd columns
			if (this.maze.moveUp()) { //movement for unblocked column
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						{if(this.maze.isDone()) {break;}}
			}
			else if (maze.getCurrRow() != 0)  { //instruction set for obstacles
				this.maze.moveLeft(); location.textArea.append("Obstacle found.  Initialize avoidance maneuver." + "\n"+"Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveUp(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveUp(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				this.maze.moveRight(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
			 	{if(this.maze.isDone()) {break;}}
				if (!this.maze.moveUp() && (maze.getCurrRow() == 0)) { //instruction set for ceiling boundary
					this.maze.moveRight(); location.textArea.append("Boundary found.  Change direction." + "\n"+"Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
				 	{if(this.maze.isDone()) {break;}}
				}	
			}
			else if (maze.getCurrRow() == 0) {
				this.maze.moveRight(); location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
				{if(this.maze.isDone()) {break;}}
			}
		}
	}	
	location.textArea.append("Logo Found \n"); //print out success
}
	

}

