package cl.demo.cal.models;

import java.util.ArrayList;

public class Calculadora {

	private String currentNumber ="";
	private ArrayList<String> rest= new ArrayList<>();
	private ArrayList<Object> parameters= new ArrayList<>();
	
	public Calculadora() {
		super();
	}
	public void addCurrentNumber(String nro) {
		currentNumber+= nro;
	}

    public void operation(String k) {
    	if(currentNumber.equals("")) {
    		currentNumber="0";
    	}
    	Double d= Double.parseDouble(currentNumber);
    	parameters.add(d);
    	parameters.add(k);
    	currentNumber="";   	
    }
    
    public void calculate() {
    	if(currentNumber.equals("")) {
    		currentNumber="0";
    	}
    	Double d= Double.parseDouble(currentNumber);
    	parameters.add(d);
    	currentNumber="";  
    	
    	Double res=(Double) parameters.get(0);
    	for(int i=1; i<parameters.size(); i+=2) {
   		if(parameters.get(i).equals("+")) {
    			res+=(Double) parameters.get(i+1);
    		}else if (parameters.get(i).equals("-")) {
    			res-=(Double) parameters.get(i+1);
    	    }else if(parameters.get(i).equals("x")) {
    			res*=(Double) parameters.get(i+1); 	
    	    }else if(parameters.get(i).equals("/")) {
    			res/=(Double) parameters.get(i+1);
    	    }
    	}
      String out=String.valueOf(res);
      rest.add(out);
      parameters.clear();
      
    }
    
    public void clear() {
    	parameters.clear();
    }
	public String getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}
	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}
	public ArrayList<String> getRest() {
		return rest;
	}
	public void setRest(ArrayList<String> rest) {
		this.rest = rest;
	}

   
	
	
	
}
