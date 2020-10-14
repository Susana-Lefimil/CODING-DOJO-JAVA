
public class Bicycle implements OperateBicycle {
  
	private int speed;
	
	public static final String hola = "hello";
    public Bicycle() {
        speed = 0;
    }
    //Un método static que llama al método static de la interfaz
    public static void staticMethod() {
        OperateBicycle.staticMethod();
    }
    // implementando speedUp
    public void speedUp(int increment) {
        speed += increment;
    }
    // implementando applyBrakes
    public void applyBrakes(int decrement) {
        speed -= decrement;
    }
    public int getSpeed() {
        return speed;
    }
}
