package cl.inacap.calculadora1.run;

import cl.inacap.calculadora1.model.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
/// Usar constructor directamente
	   Calculator v1 =new Calculator();	
	   
      v1.performOperation("10.5");
      v1.performOperation("+");
      v1.performOperation("5.2");
      v1.performOperation("*");
      v1.performOperation("10");
      v1.performOperation("+");
      v1.performOperation("10");
      v1.performOperation("-");
      v1.performOperation("10");
      v1.performOperation("=");
      
      
	  v1.recorre();
	  System.out.println("Resultado final: "+v1.getResult());
	   
	   
	   
	}

}
