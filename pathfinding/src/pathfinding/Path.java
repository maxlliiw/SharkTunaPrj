package pathfinding;

import java.util.ArrayList;
import java.util.List;

public class Path
{
	int gridsize = 4;
	int move = 1;
	ArrayList<Node> nodes = new ArrayList<Node>();
	public Path()
	{
		Node[][] grid = new Node[gridsize][gridsize];
		
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
		
		
		Node tuna = new Node(3,3,"Tunaa");
		Node shark = new Node(0,0,"Shark");
		grid[tuna.getX()][tuna.getY()] = tuna;
		grid[shark.getX()][shark.getY()] = shark;
		
		
		
		
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
		
		grid[tuna.getX()][tuna.getY()] = tuna;
		grid[shark.getX()][shark.getY()] = shark;
		
		for(int m = 0;m<gridsize;m++)
		{
			for(int n = 0;n<gridsize;n++)
			{
				System.out.print(grid[m][n].getName() + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		}
		
		}
	
		
	
	public static void main(String[] args)
	{
		Path way = new Path();
		
	}
}
