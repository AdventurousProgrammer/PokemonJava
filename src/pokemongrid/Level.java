package pokemongrid;

/*
 * enemyList - list of all enemy pokemon in current level, need to randomly assign their locations also
 * 
 */
public class Level {
	
	private Pokemon [] enemyList;
	private int numEnemies;
	
	Level(){
		
	}
	
	public int getNumEnemies() {
		return numEnemies;
	}
	
	public void setNumEnemies(int numEnemies) {
		this.numEnemies = numEnemies;
	}
	
	Level(Pokemon [] enemyList){
		this.enemyList = enemyList;
	}
	
	public void setEnemyList(Pokemon [] enemyList) {
		this.enemyList = enemyList;
	}
	public Pokemon[] getEnemyList() {
		return enemyList;
	}
}
