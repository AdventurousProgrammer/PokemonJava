package pokemongrid;
import java.util.ArrayList;
public class Player {
	
	private int money;
	private int wins;
	private int remainingPokemon;
	private String name;
	private ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	
	
	public int getRemainingPokemon() {
		return remainingPokemon;
	}
	
	public void setRemainingPokemon(int remainingPokemon) {
		this.remainingPokemon = remainingPokemon;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Pokemon> getPokemonList() {
		return pokemonList;
	}

	public Player(String name) {
		this.name = name;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
	}

	public int getMoney() {
		return money;
	}

	public int getWins() {
		return wins;
	}

	public ArrayList<Pokemon> getPokemon() {
		return pokemonList;
	}
	
	
	
	

}
