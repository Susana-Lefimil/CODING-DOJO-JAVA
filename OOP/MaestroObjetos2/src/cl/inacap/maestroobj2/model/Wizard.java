package cl.inacap.maestroobj2.model;

public class Wizard extends Human {
  int inteligence;
	//Constructor
	public Wizard(){
		this.health=50;
		this.inteligence=8;
	}
	
	public void heal(Human h) {
		h.setHealth(h.getHealth()+inteligence);
		System.out.println(" Health Ninja2: " + h.getHealth());
	}
	
	public void fireBall(Human h) {
		h.setHealth(getHealth()+inteligence*3);
		System.out.println(" Health Ninja2: " + h.getHealth());
	}
}
