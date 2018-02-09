package pathfinding;

public class Node {
    int x;
    int y;
    String name;
    
    Node(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public int getX()
    {
    	return x;
    }
    public int getY()
    {
    	return y;
    }
    public String getName()
    {
    	return name;
    }
    public void setName(String name)
    {
    	this.name=name;
    }
    public void changeX(int x)
    {
    	this.x=x;
    }
    public void changeY(int y)
    {
    	this.y=y;
    }
}