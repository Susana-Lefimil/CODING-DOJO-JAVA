package cl.inacap.maestroobj2.model;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth=10;
	}
	
	public void steal(Human h){
		h.setHealth(h.getHealth()-getStealth());
		System.out.println( " Health Samurai1: " + h.getHealth());
		setHealth(getHealth() + getStealth());
		System.out.println(" Health Ninja: " + getHealth());
		
	}
	public void runAway() {
		setHealth(getHealth()-10);
		System.out.println(" Health Ninja: " + getHealth());
	}
}
