package pokemongrid;

import java.util.ArrayList;

public class Type {//info for a specific type

	private String type;
	
	private ArrayList<String> typesUnaffectedByYou = new ArrayList<String>();
	private ArrayList<String> typesResistantToYou = new ArrayList<String>();
	private ArrayList<String> typesWeakToYou = new ArrayList<String>();//types that are weak to your attack
	private ArrayList<String> typesNeutralToYou = new ArrayList<String>();
	
	
	public String getType() {
		return type;
	}
	public void setType(String string) {
		this.type = string;
	}
	public void setUnaffectedDamageTypes(ArrayList<String> unaffectedDamageTypes) {
		this.typesUnaffectedByYou = unaffectedDamageTypes;
	}
	public void setResistantDamageTypes(ArrayList<String> resistantDamageTypes) {
		this.typesResistantToYou = resistantDamageTypes;
	}
	public void setSuperDamageTypes(ArrayList<String> superDamageTypes) {
		this.typesWeakToYou = superDamageTypes;
	}
	public void setNeutralDamageTypes(ArrayList<String> neutralDamageTypes) {
		this.typesNeutralToYou = neutralDamageTypes;
	}
	public ArrayList<String> getUnaffectedDamageTypes() {
		return typesUnaffectedByYou;
	}
	public ArrayList<String> getResistantDamageTypes() {
		return typesResistantToYou;
	}
	public ArrayList<String> getSuperDamageTypes() {
		return typesWeakToYou;
	}
	public ArrayList<String> getNeutralDamageTypes() {
		return typesNeutralToYou;
	}
	
	
    


}
