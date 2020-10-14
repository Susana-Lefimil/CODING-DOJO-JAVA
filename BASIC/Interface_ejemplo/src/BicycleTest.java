
public class BicycleTest {
	  public static void main(String[] args) {
	        Bicycle b = new Bicycle();
	        // print constant
	        System.out.println(Bicycle.myConstant);
	        System.out.println(Bicycle.hola+" bhjhd");
	        b.sayHello();
	        Bicycle.staticMethod();
	        b.speedUp(3);
	        b.applyBrakes(2);
	        System.out.println(b.getSpeed());
	    }
}
