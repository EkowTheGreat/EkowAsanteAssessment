package theInfiniteTerrainSystem;

public class Obstacle 
{
	private int obXDisplacement;
	private int obYDisplacement;
	

	
	
	public Obstacle(int x, int y)
	{
		obXDisplacement =x;
		obYDisplacement=y;
	}
	
	
	
	public int getObXDisplacement() {
		return obXDisplacement;
	}



	public void setObXDisplacement(int obXDisplacement) {
		this.obXDisplacement = obXDisplacement;
	}



	public int getObYDisplacement() {
		return obYDisplacement;
	}



	public void setObYDisplacement(int obYDisplacement) {
		this.obYDisplacement = obYDisplacement;
	}



	public double getDistance(int x,int y)
	{
		
		int xdist= obXDisplacement- x;
		int ydist= obYDisplacement- y;
		//System.out.println(treasureInitialXDisplacement);
		//System.out.println(treasureInitialYDisplacement);
		return Math.hypot(xdist, ydist);
	}
}
