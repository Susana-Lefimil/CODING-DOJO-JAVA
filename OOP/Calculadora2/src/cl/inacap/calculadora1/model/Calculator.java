//Alland, Joaquin, Erick , Susana

package cl.inacap.calculadora1.model;

import java.util.ArrayList;

public class Calculator  implements java.io.Serializable {
	private double operandOne;
	private double operandTwo;
	private String operation;

	private double result;
	private ArrayList<String> arr= new ArrayList<String>();

	///// Constructores
	public Calculator () {

	}
	////
	public Calculator (double operandOne, String operation,  double operandTwo) {
		this.operandOne=operandOne;
		this.operandTwo=operandTwo;
		this.operation=operation;


	}


	public void performOperation(String a) {
		if(!a.equals("=")) {    
			arr.add(a);
		}else {
			arr.add("0");
		}
		//System.out.println("Agregar valores al Arreglo" + arr+ "\n");
	}
	

	public void recorre() {
		ArrayList<String> arr2= new ArrayList<String>();
		double mult;
		double sum=0;
		int flag=0;

		for(int i=1; i<arr.size(); i++) {
			if(arr.get(i).equals("*")) {
				mult=Double.parseDouble(arr.get(i-1)) * Double.parseDouble(arr.get(i+1));
				arr2.add(String.valueOf(mult));
				i++;
			}else {
				arr2.add(arr.get(i-1));
			}
		}
		//System.out.println("Arreglo con sumas y restas "+ arr2 + "\n");
		for( int i=1; i<arr2.size(); i++) {
			//System.out.println("i inicial "+i);
			if(arr2.get(i).equals("+")) {
				if(flag==0) {
					sum=  Double.parseDouble(arr2.get(i-1)) + Double.parseDouble(arr2.get(i+1));
					flag=1;
				}else {
					sum= sum +  Double.parseDouble(arr2.get(i+1));
				}

				i++;  
			} else if(arr2.get(i).equals("-")) {
				if(flag==0) {
					sum= Double.parseDouble(arr2.get(i-1)) - Double.parseDouble(arr2.get(i+1));
					flag=1;
				}else {
					sum= sum -  Double.parseDouble(arr2.get(i+1));
				}

				i++; 
			}
			 //System.out.println("i final "+i);
		}
		setResult(sum);
	}
	/// Getter y Setter
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}



}
