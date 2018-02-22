package pathfinding; //Organized group of classes named pathfinding

import java.util.ArrayList; //Imports the ArrayList package from the java.util library
import java.util.Scanner;;

public class Path
{
	
	int gridsize = 7;
	//Initialize Integer for the gridsize, can be changed to determine the Square size of the gameboard
	ArrayList<Node> nodes = new ArrayList<Node>();
	//Create an ArrayList named nodes that contains Node objects to fill gameboard.
	String move = "";
	private Scanner scan;
	
	public Path()
	{
		Node[][] grid = new Node[gridsize][gridsize];
		/*
		 * Creates a 2D Array named grid that stores Node objects.
		 * Used to create our gameboard and determined upon the gridsize integer.
		 */
		
		for(int i = 0; i<gridsize; i++)
		{
			for(int j = 0; j<gridsize; j++)
			{
				nodes.add(new Node(i,j,"Ocean"));
				for(int k = 0; k<nodes.size();k++)
				{
					grid[i][j]=nodes.get(k);
				}
			}
		}
		/*
		 * Creates and Adds Node objects with name "Ocean" to the ArrayList nodes then...
		 * retrives those objects stored in the ArrayList then stores them in our 2D array gameboard.
		 */
		
		
		Node tuna = new Node(3,3,"Tuna ");
		Node shark = new Node(0,0,"Shark");
		
		grid[tuna.getX()][tuna.getY()] = tuna;
		grid[shark.getX()][shark.getY()] = shark;
		
		/*
		 * Creates Node objects for the shark and tuna that store an int x, int y, String name.
		 * 
		 * Shark and tuna contain x and y variables so the object stores its location.
		 * 
		 * The shark and tuna get placed in the gameboard with their location determined...
		 * by the Node objects stored x and y value.
		 */
		System.out.println("Controls for Shark v. Tuna \n"
				+ "TL - Moves Tuna to the Top Left \n"
				+ "T  - Moves Tuna to the Top \n"
				+ "TR - Moves Tuna to the Top Right \n"
				+ "L  - Moves Tuna to the Left \n"
				+ "R  - Moves Tuna to the Right \n"
				+ "BL - Moves Tuna to the Bottom Left \n"
				+ "B  - Moves Tuna to the Bottom \n"
				+ "BR - Moves Tuna to the Bottom Right \n"
				+ "Any blank or incorrect entry will have the Tuna remain in the same position.\n");
		/*
		 * List of controls for the User
		 */
		System.out.println("Starting Board");
		for(int m = 0;m<gridsize;m++)
		{
			for(int n = 0;n<gridsize;n++)
			{
				System.out.print(grid[m][n].getName() + " ");
			}
			System.out.println();
		}
		
		while(!((shark.getX()==tuna.getX())&&(shark.getY()==tuna.getY())))
		{
		
		if((tuna.getX()>shark.getX()))
		{
			
			shark.changeX(shark.getX()+1);
			grid[shark.getX()-1][shark.getY()]= new Node(shark.getX()-1,shark.getY(),"Ocean");
		
		}
		else if((tuna.getX()<shark.getX()))
		{
			shark.changeX(shark.getX()-1);
			grid[shark.getX()+1][shark.getY()]= new Node(shark.getX()+1,shark.getY(),"Ocean");
		}
		if((tuna.getY()>shark.getY()))
		{
			shark.changeY(shark.getY()+1);
			grid[shark.getX()][shark.getY()-1]= new Node(shark.getX(),shark.getY()-1,"Ocean");
		}
		else if((tuna.getY()<shark.getY()))
		{
			shark.changeY(shark.getY()-1);
			grid[shark.getX()][shark.getY()+1]= new Node(shark.getX(),shark.getY()+1,"Ocean");
		}
		/*
		 * Algorithm to allow the shark to move closer to the tuna determined by the...
		 * stored x and y values in the Node objects of shark and tuna.
		 * 
		 * Updates the x and y values of the shark and tuna objects and replaces its previous...
		 * position in the grid with a new Node object with its name being "Ocean"
		 * 
		 * 
		 * 
		 * Needs logic bounds for the Shark and Tuna so the Node objects int x, and int y aren't...
		 * out of bounds for the 2D array grid once the Tuna starts to move.
		 * 
		 */
		
		grid[tuna.getX()][tuna.getY()] = tuna;
		grid[shark.getX()][shark.getY()] = shark;
		/*
		 * When the move has been completed the 2D array grid gets updated
		 * and stores the tuna and shark Node objects.
		 */
		System.out.println("Robot's Move...");
		for(int m = 0;m<gridsize;m++)
		{
			for(int n = 0;n<gridsize;n++)
			{
				System.out.print(grid[m][n].getName() + " ");
			}
			System.out.println();
		}
		/*
		 * Prints out all the strings contained in the Node objects which are...
		 * stored in the 2D array grid.
		 */
		System.out.println("Your Move...");

		scan = new Scanner(System.in);
		move = scan.nextLine().toUpperCase().trim();
			if(move.equals("")) {
				tuna.changeX(tuna.getX());
				tuna.changeY(tuna.getY());
				//Does not move
			}
			else if(move.equals("B")) {
				tuna.changeX(tuna.getX()+1);
				grid[tuna.getX()-1][tuna.getY()]= new Node(tuna.getX()-1,tuna.getY(),"Ocean");
				//Bottom
				
			}
			else if(move.equals("T")) {
				tuna.changeX(tuna.getX()-1);
				grid[tuna.getX()+1][tuna.getY()]= new Node(tuna.getX()+1,tuna.getY(),"Ocean");
				//Top				
			}
			else if(move.equals("BR")) {
				tuna.changeX(tuna.getX()+1);
				tuna.changeY(tuna.getY()+1);
				grid[tuna.getX()-1][tuna.getY()-1]= new Node(tuna.getX()-1,tuna.getY()-1,"Ocean");
				//Bottom Right
			}
			else if(move.equals("TR")) {
				tuna.changeY(tuna.getY()+1);
				tuna.changeX(tuna.getX()-1);
				grid[tuna.getX()+1][tuna.getY()-1]= new Node(tuna.getX()+1,tuna.getY()-1,"Ocean");
				//Top Right
			}
			else if(move.equals("R")) {
				tuna.changeY(tuna.getY()+1);
				grid[tuna.getX()][tuna.getY()-1]= new Node(tuna.getX(),tuna.getY()-1,"Ocean");
				//Right
			}
			else if(move.equals("TL")) {
				tuna.changeX(tuna.getX()-1);
				tuna.changeY(tuna.getY()-1);
				grid[tuna.getX()+1][tuna.getY()+1]= new Node(tuna.getX()+1,tuna.getY()+1,"Ocean");
				//Top Left
			}
			else if(move.equals("L")) {
				tuna.changeY(tuna.getY()-1);
				grid[tuna.getX()][tuna.getY()+1]= new Node(tuna.getX(),tuna.getY()+1,"Ocean");
				//Left
			}
			else if(move.equals("BL")) {
				tuna.changeX(tuna.getX()+1);
				tuna.changeY(tuna.getY()-1);
				grid[tuna.getX()-1][tuna.getY()+1]= new Node(tuna.getX()-1,tuna.getY()+1,"Ocean");
				//Bottom Left
			}
			else
			{
				System.out.println("Invalid Move Tuna Remains In Same Position...");
				tuna.changeX(tuna.getX());
				tuna.changeY(tuna.getY());
				//Does not move
			}
			/*
			 * Controller for the Tuna object so the user can use a String input read by the Scanner object
			 * scan to return the String which is then compared with a String for one of the moves to return a
			 * boolean to satisfy a if then statement.
			 */
			grid[tuna.getX()][tuna.getY()] = tuna;
			grid[shark.getX()][shark.getY()] = shark;
			//Changes the Tuna and shark positions on the gameboard grid.
			
			for(int m = 0;m<gridsize;m++)
			{
				for(int n = 0;n<gridsize;n++)
				{
					System.out.print(grid[m][n].getName() + " ");
				}
				System.out.println();
			}
			/*
			 * Prints out all the strings contained in the Node objects which are...
			 * stored in the 2D array grid.
			 */		
			}
			
		}
	
	public static void main(String[] args)
	 /*
	   *Creates a method named main that is accessible in the package movietest
	   *Method is class related
	   *Method does not return any value
	   *Contains a parameter of an String array type called args
	   */
	{
		Path way = new Path();
		//main method runs new object of type Path named way
		
	}
}
