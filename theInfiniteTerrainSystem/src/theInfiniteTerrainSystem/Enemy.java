package theInfiniteTerrainSystem;

public class Enemy 
{
	private int enXDisplacement;
	private int enYDisplacement;
	
	public Enemy(int x, int y)
	{
		enXDisplacement =x;
		enYDisplacement=y;
	}

	public int getEnXDisplacement() {
		return enXDisplacement;
	}

	public void setEnXDisplacement(int enXDisplacement) {
		this.enXDisplacement = enXDisplacement;
	}

	public int getEnYDisplacement() {
		return enYDisplacement;
	}

	public void setEnYDisplacement(int enYDisplacement) {
		this.enYDisplacement = enYDisplacement;
	}
	public double getDistance(int x,int y)
	{
		
		int xdist= enXDisplacement- x;
		int ydist= enYDisplacement- y;
		//System.out.println(treasureInitialXDisplacement);
		//System.out.println(treasureInitialYDisplacement);
		return Math.hypot(xdist, ydist);
	}
}
