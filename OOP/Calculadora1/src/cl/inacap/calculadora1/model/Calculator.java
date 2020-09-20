package cl.inacap.calculadora1.model;

public class Calculator  implements java.io.Serializable {
	private double operandOne;
	private double operandTwo;
	private String operation;
	
    private double result;
	
    ///// Constructores
    public Calculator () {
    	
    }
	////
    public Calculator (double operandOne, String operation,  double operandTwo) {
    	this.operandOne=operandOne;
    	this.operandTwo=operandTwo;
    	this.operation=operation;
    	
    
    }
    
    public void performOperation() {
    	if (getOperation().equals("+")) {
    		setResult(getOperandOne()+ getOperandTwo());
    	}
    	else if (getOperation().equals("-")) {
    		setResult(getOperandOne()- getOperandTwo());
    	}
    	
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
