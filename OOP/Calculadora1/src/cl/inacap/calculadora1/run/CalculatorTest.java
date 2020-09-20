package cl.inacap.calculadora1.run;

import cl.inacap.calculadora1.model.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
/// Usar constructor directamente
	   Calculator v1 =new Calculator(5.6 , "-", 9.6);	
	   Calculator v2 =new Calculator();
	   v1.performOperation();
	   System.out.println(v1.getResult());
	   
/// Usar constructor vacío 	   
	   v2.setOperandOne(10.5);
	   v2.setOperandTwo(5.5);
	   v2.setOperation("+");
	   v2.performOperation();
	   System.out.println(v2.getResult());
	   
	   
	}

}
