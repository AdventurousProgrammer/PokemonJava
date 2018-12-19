package pokemongrid;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {

	private String name;
	private String screenName;
	private String trainer;
	private ArrayList<String> type; //member object
	private int HP;
	private int Atk;
	private int SAtk;
	private int Def;
	private int SDef;
	private int spd;
	private Attack [] attacks;
	private int x_coord;
	private int y_coord;
	
	public Pokemon() {
		
	}
	public Pokemon(String name) {
		this.name = name;
	}
	
	public String getTrainer() {
		return trainer;
	}


	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public int getX_coord() {
		return x_coord;
	}


	public int getY_coord() {
		return y_coord;
	}


	public void setX_coord(int x_coord) {
		this.x_coord = x_coord;
	}


	public void setY_coord(int y_coord) {
		this.y_coord = y_coord;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setType(ArrayList<String> type) {
		this.type = type;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public void setAtk(int atk) {
		Atk = atk;
	}

	public void setSAtk(int sAtk) {
		SAtk = sAtk;
	}

	public void setDef(int def) {
		Def = def;
	}

	public void setSDef(int sDef) {
		SDef = sDef;
	}
    public void setSpd(int spd)
    {
    	this.spd = spd;
    }
	public void setAttacks(Attack[] attacks) {
		this.attacks = attacks;
	}

	public String getName() {
		return name;
	}

	public String getScreenName() {
		return screenName;
	}

	public int getHP() {
		return HP;
	}

	public int getAtk() {
		return Atk;
	}

	public int getSAtk() {
		return SAtk;
	}

	public int getDef() {
		return Def;
	}

	public int getSDef() {
		return SDef;
	}

	public Attack[] getAttacks() {
		return attacks;
	}
	public int getSpd()
	{
		return spd;
	}
	public ArrayList<String> getType() {
		return type;
	}
	public int battle(Pokemon enemy, Scanner sc, Databases db, World world) {
		//level is 10 by default
		String ans = null;
		
		while(true) {
		System.out.println("Would you like to exit the battle? Y/y N/n");
		ans = sc.next().toLowerCase();
		
		if(ans.equals("y")) {
			return -1;
		}
		if(enemy.getHP() <= 0) {
			System.out.println(this.getName() + " wins");
			world.world[enemy.getY_coord()][enemy.getX_coord()] = " ";
			return 1;
		}
		if(this.getHP() <= 0) {
			System.out.println("enemy " + enemy.getName() + " wins");
			world.world[this.getY_coord()][this.getX_coord()] = " ";
			return 0;
		}
		
		//write code as if speed doesnt matter
		System.out.println("Here are your move choices: Just type in 1,2,3 or 4");
		System.out.println("1: " + this.getAttacks()[0].getAttack() + " 2: " + this.getAttacks()[1].getAttack());
		System.out.println("3: " + this.getAttacks()[2].getAttack() + " 4: " + this.getAttacks()[3].getAttack());
		ans = sc.next();
	    Attack attack = this.getAttacks()[Integer.valueOf(ans)];
		double effectiveness = determineEffectiveness(attack,enemy,db);
		double stab = determineStabValue(attack,this);
		int power = attack.getPower();
		int A = this.getAtk();
		int D = enemy.getDef();
		double random = ((new Random()).nextInt(16) + 85)/100;
		
		double damage = (6 * power * (A/D))/50 + 2;
		
		enemy.setHP(enemy.getHP() - (int)damage);
		}
	    
	}


	private double determineStabValue(Attack attack, Pokemon pokemon) {
		// TODO Auto-generated method stub
		if(in(attack.getType(),pokemon.getType())) {
		return 1.5;
		}
		return 1.0;
	}


	private double determineEffectiveness(Attack attack, Pokemon enemy, Databases db) {
		// TODO Auto-generated method stub
		double effectiveness = 0;
		
		String type = attack.getType();

		Type pokemonType = db.getType(type);
		ArrayList<String> listOfUnaffectedTypesForAttack = pokemonType.getUnaffectedDamageTypes();
        ArrayList<String> listOfWeaknessTypesForAttack = pokemonType.getSuperDamageTypes();
        ArrayList<String> listOfNeutralTypesForAttack = pokemonType.getNeutralDamageTypes();
        ArrayList<String> listOfResistedTypesForAttack = pokemonType.getResistantDamageTypes();
        
       boolean enemyIsDoubleTyped = enemy.getType().size() == 2;
       ArrayList<String> enemyTypes = enemy.getType();
       
	   if(enemyIsDoubleTyped)
    	   {
			String firstType = enemyTypes.get(0);
			String secondType = enemyTypes.get(1);

    	    if(in(firstType,listOfUnaffectedTypesForAttack) || in(secondType,listOfUnaffectedTypesForAttack)) {
    	    	 return 0.0;   
    	    }
    	    
    	    if(in(firstType,listOfResistedTypesForAttack) && in(secondType,listOfResistedTypesForAttack)) {
    	    	return 0.25;
    	    }
    	    
    	    if(in(firstType,listOfWeaknessTypesForAttack) && in(secondType,listOfWeaknessTypesForAttack)) {
    	    	return 4.0;
    	    }
    	    
    	    if(in(firstType,listOfWeaknessTypesForAttack) && in(secondType,listOfResistedTypesForAttack)) {
    	    	return 1.0;
    	    }
    	    
    	    if(in(firstType,listOfResistedTypesForAttack) && in(secondType,listOfWeaknessTypesForAttack)) {
    	    	return 1.0;
    	    }
    	    
    	    if(in(firstType,listOfNeutralTypesForAttack) && in(secondType,listOfNeutralTypesForAttack)){
    	    	return 1.0;
    	    }
    	    
    	    if(in(firstType,listOfWeaknessTypesForAttack) && in(secondType,listOfNeutralTypesForAttack)) {
    	    	return 2.0;
    	    }
    	    
    	    if(in(firstType,listOfNeutralTypesForAttack) && in(secondType,listOfWeaknessTypesForAttack)) {
    	    	return 2.0;
    	    }
    	    
    	    if(in(firstType,listOfNeutralTypesForAttack) && in(secondType,listOfResistedTypesForAttack)) {
    	    	return 0.5;
    	    }
    	    
    	    if(in(firstType,listOfResistedTypesForAttack) && in(secondType,listOfNeutralTypesForAttack)) {
    	    	return 0.5;
    	    }
    	    
    	   }
       
		String enemyType = enemyTypes.get(0);
		
		 if(in(enemyType,listOfUnaffectedTypesForAttack)) {
	    	 return 0.0;   
	     }
		 
		 if(in(enemyType,listOfNeutralTypesForAttack)) {
	    	 return 1.0;   
	     }
		 
		 if(in(enemyType,listOfWeaknessTypesForAttack)) {
	    	 return 2.0;   
	     }
		 
		 if(in(enemyType,listOfResistedTypesForAttack)) {
	    	 return 0.5;   
	     }
		 
		return effectiveness;
	}


	private boolean in(String string, ArrayList<String> list) {
		// TODO Auto-generated method stub
		for(String item : list) {
			if(string.equals(item)) {
				return true;
			}
		}
		return false;
	}
	

	
}
