package pokemongrid;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Ask user user name
 * What pokemon wanted 
 * Creates computer team registration (happens later)
 * Asks the user for a command move,money,world,heal
 */
public class GameProgressor {
	
	private static LevelProgressor levelProgressor = new LevelProgressor();
	
	public static void main(String [] args){
		//create user account
		Player nikhil = new Player("nikhil");
		Scanner sc = new Scanner(System.in);
		String input;
		World world = new World();
		Databases databaseSystem = new Databases();
		
		try {
			databaseSystem.initialize();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		LevelProgressor levelprg = new LevelProgressor();
		Level level = levelprg.getLevel();
		
		System.out.println("Welcome to Pokemon Grid");
		
		System.out.println("Please enter the pokemon you will be using on this playthrough");
		
		for(int i = 0; i < 6; i++) {
			
			String pokemon = sc.next();
			Pokemon pkmn = databaseSystem.getPokemon(pokemon);
			nikhil.addPokemon(pkmn);
			
		}
		
		while(true) {
			
			if(nikhil.getRemainingPokemon() == 0) {
			System.out.println("YOU LOSE GAME OVER");
			return;
		}
		
			if(level.getNumEnemies() == 0) {
				if(levelprg.updateLevel(world) == 1) {
					System.out.println("YOU WIN CONGRATULATIONS POKEMON MASTER");
				}
				level = levelprg.getLevel();
		}
			
		
		System.out.println("Please execute your turn");
		System.out.println("Here are the options: q, move, world, pokemon, money, heal");
	    input = sc.nextLine();
	    String [] inputArgs = input.split(" ");
	    String cmd = inputArgs[0];
	    
	    switch(cmd) {
	    case "q" :
			System.exit(0);
			break;
	    case "move":
	    	
	    	System.out.println("Please choose a pokemon to move");
	        String movingPokemon = sc.nextLine();
	        
	        ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	        
	        for(Pokemon pok: nikhil.getPokemon()) {
	        	if(pok.getName().equals(movingPokemon)) {
	        		pokemonList = world.checkLocation(pok);
	        		
	        		 if(pokemonList.size() != 0) {
	        			 System.out.println("The following pokemon is in the same location as your current pokemon: " + pok.getName() + " enemy pokemon: " + pokemonList.get(0).getName());
	     	        	 System.out.println("Would you like to battle Y/y N/n?");
	     	        	 String ans = sc.next();
	     	        	 
	     	        	 if(ans.toLowerCase().equals("y") || ans.toLowerCase().equals("n")) {
	     	        		 if(pok.battle(pokemonList.get(0), sc, databaseSystem, world) == 0) {
	     	        			 nikhil.setRemainingPokemon(nikhil.getRemainingPokemon() - 1);
	     	        		 }
	     	        		 else {
	     	        			 level.setNumEnemies(level.getNumEnemies() - 1);
	     	        		 }
	     	        	 }
	     	        }
	        	}
	        }
	       

	       //RUN FROM BATTLE
	        System.out.println("Please enter the number of spaces and direction, you want pokemon to move");
	        String movement = sc.nextLine();
	        String [] movementDescription = movement.split(" ");
	        for(Pokemon pok: nikhil.getPokemon()) {
	        	if(pok.getName().equals(movingPokemon)) {
	        		int x_old = pok.getX_coord();
	        		int y_old = pok.getY_coord();
		        	locationChange(pok,movementDescription[0],Integer.valueOf(movementDescription[1]));
		        	world.updateLocation(pok, x_old, y_old);
	        	}
	        }
	        //need to find which pokemon to move
	        break;
	    case "world":
	    	world.displayWorld();
	    	break;
	    case "pokemon":
	    	String names = null;
	    	
	    	for(Pokemon pokemon: nikhil.getPokemon()) {
	    		names += pokemon + " ";
	    	}
	        System.out.println(names);
	        break;
	    case "money":
	    	System.out.println("PLAYER MONEY: " + nikhil.getMoney());
	    	break;
	    case "heal":
	    	System.out.println("Here is a list of all the items " + databaseSystem.getItemDatabase().keySet());
	    	System.out.println("Please enter which pokemon you would like to heal");
	    	String healPokemon = sc.next();
	    	System.out.println( "How would you like to heal " + healPokemon + " ?");
	    	String healItem = sc.nextLine();
	    	//need to check if actually healing item
	    	Item item = databaseSystem.getItemDatabase().get(healItem);
	    	
	    	 for(Pokemon pok: nikhil.getPokemon()) {
		        	if(pok.getName().equals(healPokemon)) {
		        		pok.setHP(pok.getHP() + Integer.valueOf(item.getEffect()));
		        	}
	    	
	        break;	
	    }
	    } 
	 }
}
		
		
		
		//if command is heal <pokemon_name> <potion_name>
		//possible exceptions wrong pokemon name or potion name
		//get the potion from the potion database and heal the pokemon with its effect
		
		//if command is fight
		//if there are pokemon to fight
		  //display to the user the pokemon that is fighting with current HP
		//Get the name of pokemon your pokemon fighting against along with HP
		//Ask if user wants to run
		//while(user still wants to battle or opposing pokemon is alive or user pokemon is alive)
		//Give user movepool options run is always an option
		//get move user selects 
		 //calculate battle damage
		//subtract damage from opponents hp
		
	
	//this function belongs somewhere else doesnt have to deal with game progression
	//who should update pokemon locations
	public static void locationChange(Pokemon pok, String dir, Integer spacesMoved) {
		// TODO Auto-generated method stub
		switch(dir) {
		case "U":
			pok.setY_coord(pok.getY_coord() - spacesMoved);
			break;
		case "URD":
			pok.setX_coord(pok.getX_coord() + spacesMoved);
			pok.setY_coord(pok.getY_coord() - spacesMoved);
			break;
		case "R":
			pok.setX_coord(pok.getX_coord() + spacesMoved);
			break;
		case "DRD":
			pok.setX_coord(pok.getX_coord() + spacesMoved);
			pok.setY_coord(pok.getY_coord() + spacesMoved);
			break;
		case "D":
			pok.setY_coord(pok.getY_coord() + spacesMoved);
			break;
		case "DLD":
			pok.setX_coord(pok.getX_coord() - spacesMoved);
			pok.setY_coord(pok.getY_coord() + spacesMoved);
			break;
		case "L":
			pok.setX_coord(pok.getX_coord() - spacesMoved);
			break;
		case "ULD":
			pok.setX_coord(pok.getX_coord() - spacesMoved);
			pok.setY_coord(pok.getY_coord() - spacesMoved);
			break;


		}
		//refactor this if else block
		//if too far off the right
		//wrap around to the left edge, starting from 0, and adding how far over you went from the right boundary
		if(pok.getX_coord() > World.worldWidth - 1) {//done for off by 1 error
			pok.setX_coord(pok.getX_coord() - World.worldWidth);
		}
		//too far off the left
		if(pok.getX_coord() < 0) {
			pok.setX_coord(pok.getX_coord() + World.worldWidth);
		}
		//too far off the bottom
		if(pok.getY_coord() > World.worldHeight - 1) {
			pok.setY_coord(pok.getY_coord() - World.worldHeight);
		}
		if(pok.getY_coord() < 0) {
			pok.setY_coord(pok.getY_coord() + World.worldHeight);
		}
		

		
	}

}
