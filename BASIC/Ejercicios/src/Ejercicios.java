
import java.util.ArrayList;


public class Ejercicios {
	
	//1.	Pedir un número N por la terminal, y mostrar todos los números de 1 a N.
	public int numero1(int num) {
		for (int i=1 ; i<=num; i++)	{
			System.out.print(i+" ");

		}
		return num;
	}

	//2.	Pedir dos números y decir cual de los dos es mayor o si son iguales.
	public void numero2(int num1, int num2) {
		if (num1<num2) {
			System.out.println(num2+ " es mayor");
		}else if(num1>num2) {
			System.out.println(num1+ " es mayor");
		}else {
			System.out.println("Los numeros son iguales");
		}

	}
	//3.	Pedir números hasta que se teclee uno negativo y mostrar cuantos números se han introducido.

	public void teclear (ArrayList<Integer> arr){ 
		int cuantos=0;
		for (Integer array: arr) {	  	
			cuantos++;    	 
		}
		System.out.println("tecleo: "+ cuantos + " numeros");

	}

	//    }

	//4.	Calcule e imprima el salario semanal de un empleado a partir de sus horas semanales trabajadas y de su salario por hora.
	//El programa debe solicitar las horas semanales y el salario por hora.

	public float pagoSemanal(float hora, float salario) {

		float salariototal=hora*salario;

		return salariototal;
	}    



	//5.	Construir un programa que, dado un número total de horas devuelve el número de semanas, días y horas equivalentes. Por ejemplo, dado un total de 100 horas debe mostrar 5 semanas, 6 días y 16 horas.


	public void calculoHoras(int horas) {

		int sem=horas/168;
		int dis=(sem*168-horas)/-24;
		int hrs=horas-(sem*168+dis*24);

		System.out.printf("Semanas: %d  Dias: %d Horas: %d \n ", sem, dis, hrs);

	}

}
