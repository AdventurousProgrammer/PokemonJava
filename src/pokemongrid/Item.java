package pokemongrid;

public class Item {
	
	private String item;
	private String effect;
	private int cost;
	
	public Item(String item, String effect, int cost)
	{
		this.item = item;
		this.effect = effect;
		this.cost = cost;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getItem() {
		return item;
	}
	public String getEffect() {
		return effect;
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	
	
	

}
