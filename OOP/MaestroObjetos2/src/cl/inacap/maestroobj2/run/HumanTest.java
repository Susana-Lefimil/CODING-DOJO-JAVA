package cl.inacap.maestroobj2.run;

import cl.inacap.maestroobj2.model.Human;
import cl.inacap.maestroobj2.model.Ninja;
import cl.inacap.maestroobj2.model.Samurai;
import cl.inacap.maestroobj2.model.Wizard;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Human Wizard1= new Human();
		//Human Ninja1= new Human();
		//Human Wizard2= new Human();
		Human Ninja2= new Human();
		Human Samurai1= new Human();

		System.out.println("\n1. Metodo deathBlow Samurai a Wizard1");
		Samurai s1 = new Samurai();
		System.out.println(" Health inicial Samurai: "+ s1.getHealth()+ " // Health incial Wizard1: "+ Wizard1.getHealth());
		s1.deathBlow(Wizard1);
		
		System.out.println("\n2. Metodo meditate");
		s1.meditate();
		System.out.println(" Health Samurai :"+s1.meditate());
        
		System.out.println("\n3. Metodo howMany");
		System.out.println(" Número de samurai s1: "+ s1.howMany());
		Samurai s2= new Samurai();
		System.out.println(" Número de samurai s2: "+ s2.howMany());
		Samurai s3= new Samurai();
		System.out.println(" Número de samurai s3: "+ s3.howMany());
		
		System.out.println("\n4. Metodo heal Wizard a Ninja2");
		Wizard w1 = new Wizard();
		System.out.println(" Health inicial Wizard: "+ w1.getHealth()+ " // Health incial Ninja2: "+ Ninja2.getHealth());
		w1.heal(Ninja2);
		
		System.out.println("\n6. Metodo fireball Wizard a Ninja2");
		w1.fireBall(Ninja2);
		
		System.out.println("\n7. Metodo steal Ninja a Samurai1");
		Ninja n1 = new Ninja();
		System.out.println(" Health inicial Ninja: "+ n1.getHealth()+ " // Health incial Samurai1: "+ Samurai1.getHealth());
		n1.steal(Samurai1);
		
		System.out.println("\n8. Metodo run Away");
		n1.runAway();
		
	}

}
