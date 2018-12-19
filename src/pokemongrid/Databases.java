package pokemongrid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Databases {
	
	protected static HashMap<String,Pokemon> pokemonDatabase = new HashMap<String,Pokemon>();
	private static HashMap<String,Attack> attackDatabase = new HashMap<String,Attack>();
	private static HashMap<String,Type> typeDatabase= new HashMap<String,Type>();
	private static HashMap<String,Item> itemDatabase= new HashMap<String,Item>();
	
	
	public static void main(String [] args) throws FileNotFoundException {
		(new Databases()).populatePokemonDatabase();
	}
	private void populatePokemonDatabase() throws FileNotFoundException
	{
		File pokemonFile = new File("Pokemon.txt");
		System.out.println("done");
		Scanner input = new Scanner(pokemonFile);
		
		
		while(input.hasNext())
		{
			String line = input.nextLine();
			String [] lineContents = line.split(": | ");
			System.out.println("Items in linecontents");
			
			for(String lineparts : lineContents)
			{
				System.out.println(lineparts);
			}
			
			
			Pokemon pokemon = new Pokemon();
			for(int i = 0; i < lineContents.length; i+=2)
			{
				String expr = lineContents[i];
				
				switch(expr)
				{
				case "Pokemon":
					System.out.println("Pokemon: " + lineContents[i+1]);
					pokemon.setName(lineContents[i+1]);
					break;
				case "Type(s)":
					String type = lineContents[i + 1];
					System.out.println("Type(s): " + type);
					ArrayList<String> typeList = new ArrayList<>();
					if(type.contains("/"))
					{
						String [] types = type.split("/");
						
						System.out.println("printing types");
						
						for(String Type : types)
						{
							System.out.println(Type);
							typeList.add(Type);
						}

					}
					else
						typeList.add(type);
					pokemon.setType(typeList);
					break;
				case "HP":
					int hp = Integer.parseInt(lineContents[i+1]);
					System.out.println("HP: " + hp);
					pokemon.setHP(hp);
					break;
				case "Atk":
					int atk = Integer.parseInt(lineContents[i+1]);
					System.out.println("Atk: " + atk);
					pokemon.setAtk(atk);
					break;
				case "Def":
					int def = Integer.parseInt(lineContents[i+1]);
					System.out.println("Def: " + def);
					pokemon.setDef(def);
					break;
				case "SAtk":
					int satk = Integer.parseInt(lineContents[i+1]);
					System.out.println("SAtk: " + satk);
					pokemon.setSAtk(satk);
					break;
				case "SDef":
					int sdef = Integer.parseInt(lineContents[i+1]);
					System.out.println("SDef: " + sdef);
					pokemon.setSDef(sdef);
					break;
				case "Spd":
					int spd = Integer.parseInt(lineContents[i+1]);
					System.out.println("Spd: " + spd);
					pokemon.setSpd(spd);
					break;
				}
			}
			
			String pokemonName = pokemon.getName();
			String screenName  = pokemonName.substring(0, 2);
			System.out.println("screen name: " + screenName);
			pokemon.setScreenName(screenName);
			pokemonDatabase.put(pokemonName, pokemon);
			
			
			
		}
			

		//Pokemon
		//Blue Jellicent Water Ghost
		//Clefable-Fairy Normal
		//Nuzleaf Grass Dark
		//Naganadel
		//Furret
		//Landorus
		//Sandygast
		//Mareep
		//Nosepass
		//Haunter
		//Squirtle
		//Morelull
		//Grimer
		//Typhlosion
		//Gabite
		//Dragalge
		//Cosmog
		//Delibird
		//Blissey
		//Kingler
		
	}
	
	private void populateAttackDatabase() throws FileNotFoundException{
		File attackFile = new File("Attack.txt");
		System.out.println("done");
		Scanner input = new Scanner(attackFile);
		
		while(input.hasNext()){
			
			String line = input.nextLine();
			String [] lineContents = line.split("Attack: | Power: | Type: | Category: ");
			Attack attack = new Attack();
			
			attack.setAttack(lineContents[0]);
			attack.setPower(Integer.valueOf(lineContents[1]));
			attack.setType(lineContents[2]);
			attack.setCategory(lineContents[3]);
		}
	}
	
	private void populatetypeDatabase() throws FileNotFoundException{
		File typeFile = new File("Type.txt");
		System.out.println("done");
		Scanner input = new Scanner(typeFile);
		
		while(input.hasNext()){
			
			String line = input.nextLine();
			String [] lineContents = line.split("Type: | Types strong against: | Types weak against: | Types no damage: ");
			Type type = new Type();
			
			type.setType(lineContents[0]);
			
		    String [] typesStrongAgainst = lineContents[1].split(", ");
		    
		    for(String types: typesStrongAgainst) {
		    	type.getSuperDamageTypes().add(types);
		    }
		    
		    String [] typesResistantToType = lineContents[2].split(", ");
		    
		    for(String types: typesResistantToType) {
		    	type.getResistantDamageTypes().add(types);
		    }
		    
		    String [] typesUnaffectedByType = lineContents[3].split(", ");
		    
		    for(String types: typesUnaffectedByType) {
		    	type.getUnaffectedDamageTypes().add(types);
		    }
		    
		    typeDatabase.put(type.getType(),type);
		  
			
		
	}
}
	
	private void populateitemDatabase()
	{
		Item water = new Item("water","+20",30);
		Item potion = new Item("potion","+50",100);
		Item superPotion = new Item("super potion","+100", 250);
		Item hyperPotion = new Item("hyper potion","+200",700);
	}
	
	public void initialize() throws FileNotFoundException {
		populateitemDatabase();
		populatetypeDatabase();
		populateAttackDatabase();
		populatePokemonDatabase();
	}
	
	public Pokemon getPokemon(String pokemonName)
	{
		return pokemonDatabase.get(pokemonName);
	}
	
	public HashMap<String, Pokemon> getPokemonDatabase() {
		return pokemonDatabase;
	}

	public HashMap<String, Attack> getAttackDatabase() {
		return attackDatabase;
	}

	public HashMap<String, Type> getTypeDatabase() {
		return typeDatabase;
	}

	public static HashMap<String, Item> getItemDatabase() {
		return itemDatabase;
	}

	public Attack getAttack(String attackName)
	{
		return attackDatabase.get(attackName);
	}
	
	public Type getType(String type)
	{
		return typeDatabase.get(type);
	}
	
	public Item getItem(String item)
	{
		return itemDatabase.get(item);
	}
	

}
