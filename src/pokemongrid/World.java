package pokemongrid;

import java.util.ArrayList;
import java.util.LinkedList;

public class World {
	
	protected final static int worldWidth = 5;
	protected final static int worldHeight = 6;
	protected String [][] world = new String [worldHeight][worldWidth];
	protected LinkedList<Pokemon>[] Grid = new LinkedList[worldHeight];

	
	/**
	 * displays names in all of the pokemon in world
	 */
	
	public void displayWorld(){
		printFirstRow();
		printMap();
		printLastRow();
	}
	
	private void printFirstRow() {
		String firstRow = "+";
		
		for(int i = 0; i < worldWidth; i++) {
			firstRow += " -";
		}
		firstRow += " +";
		System.out.println(firstRow);
	}
	private void printMap() {
		for(int k = 0; k < worldHeight; k++) {
			
			String row = "|";
			
			for(int j = 0; j < worldWidth; j++) {
				row += "  ";
			}
			
			row += " |";
			
			System.out.println(row);
			}
	}
	private void printLastRow() {
		String lastRow = "+";
		
		for(int i = 0; i < worldWidth; i++) {
			lastRow += " -";
		}
		lastRow += " +";
		System.out.println(lastRow);
	}
	
	/**
	 * updateLocation
	 * @param pokemon-pokemon that needs to be moved
	 * @param x_old- old x position of pokemon that needs to be moved
	 * @param y_old- old y position of pokemon that needs to be moved
	 *
	 * Erase pokemon at its original location in the world, add it to the new place
	 * in the world 
	 */
	public void updateLocation(Pokemon pokemon, int x_old,int y_old){
		
		ArrayList<Pokemon> otherPokemonAtSameLocation = checkLocation(pokemon);
		

		if(otherPokemonAtSameLocation.size() == 0) {
			world[y_old][x_old] = " ";
		}
		else {
			world[y_old][x_old] = otherPokemonAtSameLocation.get(0).getScreenName();
		}
		world[pokemon.getY_coord()][pokemon.getX_coord()] = pokemon.getScreenName();
		
		//consider all cases
		//size one
		LinkedList<Pokemon> yOldRow = Grid[y_old];
		
		if(yOldRow == null) {
			System.out.println("ERROR: PROBLEM IN INSERTING, FIX THIS");
		}
		if(yOldRow.size() == 1) {
			yOldRow.remove(0);
			Grid[y_old] = null;
		}
		else {
			for(int i = 0; i < yOldRow.size(); i++) {
				
				boolean sameName = yOldRow.get(i).getName().equals(pokemon.getName());
				boolean sameTrainer = yOldRow.get(i).getTrainer().equals(pokemon.getTrainer());
				
				if(sameName && sameTrainer) {
					yOldRow.remove(i);
				}
			}
		}
		insertPokemon(pokemon);
		
		
	}
	
	public void insertPokemon(Pokemon pokemon) {
		LinkedList<Pokemon> insertRow = Grid[pokemon.getY_coord()];
		
		world[pokemon.getY_coord()][pokemon.getX_coord()] = pokemon.getScreenName();
		
		for(int i = 0; i < insertRow.size(); i++) {
			if(pokemon.getX_coord() <= insertRow.get(i).getX_coord()) {
				insertRow.add(i, pokemon);
				return;
			}
		}
		insertRow.add(pokemon);
		
	}

	/**
	 * updateLocation
	 * @param pokemon- pokemon whose location we need to compare against
	 * @return ArrayList containing all the enemy pokemon in same location as user pokemon
	 * 
	 * Returns arraylist of all enemy pokemon in same location as current pokemon
	 */
	public ArrayList<Pokemon> checkLocation(Pokemon pokemon){
		ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		LinkedList<Pokemon> yRow = Grid[pokemon.getY_coord()];
		
		for(int i = 0; i < yRow.size(); i++) {
			Pokemon pok = yRow.get(i);
			
			if(!pok.getName().equals(pokemon.getName()) || !pok.getTrainer().equals(pokemon.getTrainer())) {
				pokemonList.add(pok);
			}
		}
		return pokemonList;
	}

}
