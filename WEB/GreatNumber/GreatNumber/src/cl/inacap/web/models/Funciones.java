package cl.inacap.web.models;

import java.util.Random;

public class Funciones {
	
	public static int aleatorio(){
	    
        Random random = new Random();
        int number;
        int numBase = 1;
        int numFinal = 100;
        
        number = (random.nextInt(numFinal - numBase) + numBase);
      
        return number;
    }
	
}
