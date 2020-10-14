
public interface OperateBicycle {
	/// public static final son implicitos 
	double myConstant = 3.0;

	//El metodo predeterminado no necesita implementación.
	default void sayHello() {
		System.out.println("Hola a todos.");
	}

	//El método static que no necesita implementación.
	static void staticMethod() {
		System.out.println("Hola desde el metodo static de la interfaz.");
	}
	/// implicito que es public abstract
	void speedUp(int increment);
	void applyBrakes(int decrement);
}
