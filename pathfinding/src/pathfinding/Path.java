package pathfinding; //Organized group of classes named pathfinding

import java.util.ArrayList; //Imports the ArrayList package from the java.util library

public class Path
{
	
	int gridsize = 4;
	//Initialize Integer for the gridsize, cana be changed to determine the Square size of the gameboard
	ArrayList<Node> nodes = new ArrayList<Node>();
	//Create an ArrayList named nodes that contains Node objects to fill gameboard.
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
		 * Needs Algorithm so the Tuna can move.
		 */
		
		grid[tuna.getX()][tuna.getY()] = tuna;
		grid[shark.getX()][shark.getY()] = shark;
		/*
		 * When the move has been completed the 2D array grid gets updated
		 * and stores the tuna and shark Node objects.
		 */
		
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
		System.out.println();
		//Prints a line between turns for readablity.
		
		}
		
		}
	
		
	
	public static void main(String[] args)
	 /*
	   *Creates a method named main that is accessable in the package movietest
	   *Method is class related
	   *Method does not return any value
	   *Contains a paramater of an String array type called args
	   */
	{
		Path way = new Path();
		//main method runs new object of type Path named way
		
	}
}
