import java.util.ArrayList;
import java.util.Scanner;
public class EjerciciosTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner imput = new Scanner(System.in);
		Ejercicios n= new Ejercicios();


		System.out.printf("\n--------------- EJERCICIO 1---------------");
		System.out.printf("\n--------- Imprimir del 1 a n numeros---------------");	
		
		/// EJERCICIO 1
		int ran=0;
		System.out.printf("\nIngresa Numero:");
		ran=imput.nextInt();
		int res = n.numero1(ran);
		ran=0;

		System.out.printf("\n--------------- EJERCICIO 2---------------");
		System.out.printf("\n--------------- Mayor numero---------------");
		//////EJERCICIO 2
		int num1;
		int num2;

		System.out.printf("\nIngresa un numero :");
		num1=imput.nextInt();
		System.out.printf("\nIngresa otro numero :");
		num2=imput.nextInt();
		n.numero2(num1, num2);

		System.out.printf("\n--------------- EJERCICIO 3---------------");
		System.out.printf("\n----Ingresar varios numeros y finalizar con un negativo-----");
		////EJERCICO 3
		int contador=0;
		ArrayList<Integer> arrnew = new ArrayList<Integer>();

		//contador=imput.nextInt();
		while (contador>=0) {
			System.out.println("\nTeclee un numero"); 
			contador=imput.nextInt();
			arrnew.add(contador);
		}
		System.out.println(arrnew);
		n.teclear(arrnew);

		System.out.printf("\n--------------- EJERCICIO 4---------------");	
		System.out.printf("\n--------- Calcular salario semanal---------");	
		//EJERCICIO 4 
		float horas=0;
		float pago=0;

		System.out.println("\nIngrese horas semanales de trabajo");
		horas=imput.nextInt();
		System.out.println("\nIngrese salario por hora");
		pago=imput.nextInt();
		System.out.println("\nSu pago semanal es: "+ n.pagoSemanal(horas, pago));


		System.out.printf("\n--------------- EJERCICIO 5---------------");	
		System.out.printf("\n--------Calculo de semanas, días y horas--------");	
		//EJERCICIO 5    
		System.out.println("\nIngrese horas totales de trabajo");
		int horastotales=imput.nextInt();
		n.calculoHoras(horastotales);
	}
}

