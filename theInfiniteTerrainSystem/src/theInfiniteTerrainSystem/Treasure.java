package theInfiniteTerrainSystem;

public class Treasure 
{
	
	private int treasureInitialXDisplacement;
	private int treasureInitialYDisplacement;
	

	
	
	public Treasure(int x, int y)
	{
		treasureInitialXDisplacement =x;
		treasureInitialYDisplacement=y;
	}
	
	public int getTreasureInitialXDisplacement() {
		return treasureInitialXDisplacement;
	}
	public void setTreasureInitialXDisplacement(int treasureInitialXDisplacement) {
		this.treasureInitialXDisplacement = treasureInitialXDisplacement;
	}
	public int getTreasureInitialyDisplacement() {
		return treasureInitialYDisplacement;
	}
	public void setTreasureInitialyDisplacement(int treasureInitialyDisplacement) {
		this.treasureInitialYDisplacement = treasureInitialyDisplacement;
	}
	public double getDistance(int x,int y)
	{
		
		int xdist= treasureInitialXDisplacement- x;
		int ydist= treasureInitialYDisplacement- y;
		//System.out.println(treasureInitialXDisplacement);
		//System.out.println(treasureInitialYDisplacement);
		return Math.hypot(xdist, ydist);
	}
	
}
