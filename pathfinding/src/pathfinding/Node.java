package pathfinding;

public class Node {
    int x;
    int y;
    String name;
    /*
     * Instantiates variables used for the Node object.
     */
    Node(int x, int y, String name) {
    	/*
    	 * Constructs Node class object with three parameters.
    	 * int x - Stores a int x so it knows its x position on a 2D Array gameboard.
    	 * int y - Stores a int y so it knows its y position on a 2D Array gameboard.
    	 * String name - Stores the name of the object so we can return it from memory.
    	 */
        this.x = x;
        this.y = y;
        this.name = name;
        /*
         * Assigns the variables used by a Node object based on the given parameters.
         */
    }
    public int getX()
    {
    	return x;
    	//Returns x for the Node object.
    }
    public int getY()
    {
    	return y;
    	//Returns y for the Node object.
    }
    public String getName()
    {
    	return name;
    	//Returns name for the Node object.
    }
    public void setName(String name)
    {
    	this.name=name;
    	//Changes the name of the object.
    }
    public void changeX(int x)
    {
    	this.x=x;
    	//Changes the x value for the object.
    }
    public void changeY(int y)
    {
    	this.y=y;
    	//Changes the y value for the object.
    }
}