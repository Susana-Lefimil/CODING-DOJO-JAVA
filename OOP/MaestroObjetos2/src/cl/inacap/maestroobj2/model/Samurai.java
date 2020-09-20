package cl.inacap.maestroobj2.model;

public class Samurai extends Human {
	static int conta;
	//Constructor
	public Samurai(){
	   this.health = 200;
	   conta+=1;
		
	}
   public void deathBlow(Human h) {
	   h.setHealth(0);
	   setHealth(getHealth()/2); 
	   System.out.println( " Health: " + h.getHealth()+" , Wizard1 está muerto!!");
	   System.out.println( " Health Samurai: " + getHealth());
   }
   
   public int meditate() {
	   setHealth(getHealth()/2 + getHealth());
	   return this.health;
   }
   public int howMany() {
	
	return conta;
   }
}
