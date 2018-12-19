package pokemongrid;

public class LevelProgressor {
	//return a list of pokemon at certain level
	
	private Level [] allLevels = new Level[2];
	private int currentLevel = 0;

	public LevelProgressor() {
		
		//remember to put pokemon in new random locations as well within world boundary
		Level level1 = new Level();
		Level level2 = new Level();

		Pokemon pok1 = Databases.pokemonDatabase.get("Rattata");
		
		Pokemon pok2 = Databases.pokemonDatabase.get("Rattata");
		Pokemon pok3 = Databases.pokemonDatabase.get("Rattata");
		
		Pokemon [] enemyList1 = {pok1,pok2,pok3};
		level1.setEnemyList(enemyList1);
		
		Pokemon pok11 = Databases.pokemonDatabase.get("Pidgey");
		Pokemon pok12 = Databases.pokemonDatabase.get("Pidgey");
		Pokemon pok13 = Databases.pokemonDatabase.get("Pidgey");

        Pokemon [] enemyList2 = {pok11,pok12,pok13};
        level2.setEnemyList(enemyList2);
        
        allLevels[0]=level1;allLevels[1]=level2;
	}
	
	public int updateLevel(World world) {
		
		   currentLevel++;
           
		   if(currentLevel == allLevels.length) {
			   return 1;
		   }
		   
	       Pokemon [] enemyList = allLevels[currentLevel].getEnemyList();
	       
	       for(Pokemon enemy: enemyList) {
	    	   world.insertPokemon(enemy);
	       }
	       
	       return 0;
	}
	
	public Level getLevel() {
		return allLevels[currentLevel];
	}
	
	
	
	
}
