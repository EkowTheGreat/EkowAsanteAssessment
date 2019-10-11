package theInfiniteTerrainSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

	static ArrayList<Obstacle> obstacles = new ArrayList<>();
	static ArrayList<Enemy> enemies = new ArrayList<>();
	static int playerXpos = 0;
	static int playerYpos = 0;
	static boolean found = false;
	static int numOfObstacles = 10;
	static int level = 0;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Grey foggy clouds float oppressively close to you, \r\n"
				+ "reflected in the murky grey water which reaches up your shins.\r\n"
				+ "Some black plants barely poke out of the shallow water.\r\n" + "");
		boolean playing = true;

		while (playing == true) {
			populateTerrain(numOfObstacles+level);
			play();
			playing = isGameOver();

		}
		scan.close();
	}

	public static boolean treasureFound(int x, int y, Treasure t) {
		if (t.getTreasureInitialXDisplacement() == x && t.getTreasureInitialyDisplacement() == y) {
			System.out.println("You see a box sitting on the plain. It’s filled with treasure! You win! The end.");

			return true;
		} else {

			return false;
		}

	}

	public static boolean collision(int x, int y) {
		for (Obstacle obs : obstacles) {
			if (obs.getObXDisplacement() == x && obs.getObYDisplacement() == y) {
				System.out.println("bump...\r\n"+"Something becomes more hungy in the distance");
				return true;

			}

		}
		for (Enemy e: enemies) {
			if (e.getEnXDisplacement() == x && e.getEnYDisplacement() == y) {
				System.out.println("You Have been consumed by the endless hunger");
				System.out.println("You are forver lost in the infinite edges of the terrain");
				level--;
				isGameOver();
				//return true;

			}
		}
		return false;
	}

	public static void populateTerrain(int n) {
		Random randyP = new Random();
		for (int x = 0; x < n; x++) {
			Obstacle obj = new Obstacle(randyP.nextInt(10), randyP.nextInt(10));
			obstacles.add(obj);
		}
	}

	public static void play() {
		String input = "";
		Random randyP = new Random();
		if(level>0)
		{
			
			for (int x = 0; x < level; x++) {
				Enemy obj = new Enemy(randyP.nextInt(10), randyP.nextInt(10));
				enemies.add(obj);
			}
		}
		
		//Treasure ter = new Treasure(1,0);
		Treasure ter = new Treasure(randyP.nextInt(20), randyP.nextInt(20));
//		playerXpos = 0;
//		playerYpos = 0;
		playerXpos = randyP.nextInt(20);
		playerYpos = randyP.nextInt(20);
		while (found == false) {

			System.out.println("Enter north,south east or west to explore The Infinite Terrain");

			System.out.println("The Dial Reads : " + ter.getDistance(playerXpos, playerYpos));
			if(level>0)
			{
				if(level==1)
				{
					System.out.println(enemies.size()+" Infinite Hunger beckon you.... Be on guard Navigator!! ");
				}
				else
				{
				System.out.println(enemies.size()+" Infinite Hungers beckon you.... Be on guard Navigator!! ");
				}
				for (Enemy e: enemies) {
					
					if(e.getDistance(playerXpos, playerYpos)<2)
					{
						System.out.println("An Infinite Hunger beckons you : " + e.getDistance(playerXpos, playerYpos));
					}
					
					

					}
				
			}
			try {
				input = scan.nextLine();
				// System.out.println("Input: " + input);
			} catch (Exception e) {
				System.out.println("Bad Input");
			}

			switch (input) {
			case "north": {
				if (collision(playerXpos, playerYpos + 1) == false) {
					playerYpos++;
				}

				break;
			}
			case "south": {
				if (collision(playerXpos, playerYpos - 1) == false) {
					playerYpos--;
				}
				break;
			}
			case "east": {
				if (collision(playerXpos + 1, playerYpos) == false) {
					playerXpos++;
				}
				break;
			}
			case "west": {
				if (collision(playerXpos - 1, playerYpos) == false) {
					playerXpos--;
				}
				break;
			}
			default: {
				break;
			}
			}

			found = treasureFound(playerXpos, playerYpos, ter);
		}

	}

	public static boolean isGameOver() {
		System.out.println("Type 'quit' to quit  or  'play' to play again");
		System.out.println("Enter summin:");

		String input = "";
		input = scan.nextLine();
		if (input.equals("play")) {
			found =false;
			level++;
			play();
			return true;
		} else if (input.equals("quit")) {
			level++;
			return false;
		} else {
			return isGameOver();
		}

	}
}
