package cl.inacap.maestroobj2.model;

public class Human {

	private int strength=3;
	private int intelligence=3;
	public int stealth=3;
	public int health=100;

	//Constructor

	public Human () {

	}
	///Ataque
	public void attack(Human h) {
		h.setHealth(h.getHealth()-this.stealth);
		System.out.println( h.getHealth()+"\n");
	}

	//getter y setter

	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public int getStealth() {
		return stealth;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

}
