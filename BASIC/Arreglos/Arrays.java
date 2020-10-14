import java.util.ArrayList;
public class Arrays {
    public static void main(String[] args){

        int numero;

        int[] myArray;
        myArray = new int[5];    // Inicialización,5 es el tamaño que tendrá el arreglo(se pueden poner un tamaño mayor a lo ocupado pero no menor)
        myArray[0] = 4;
        myArray[1] = 8;
        myArray[2] = 8;
        myArray[3] = 5;
        myArray[4] = 9;

        int[] myNewArray = {4, 8, 8, 5, 9};
        System.out.println(myNewArray.length);

        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(10);//0
        myList.add(100);//1
        myList.add(500);//2

        System.out.println(myList.get(0));
        System.out.println(myList.size());

        ArrayList<Object> list = new ArrayList<Object>();
        list.add(10);
        list.add("Hola");
        list.add(new ArrayList<Integer>());
        list.add(new Double(12.0)); // Agregando un Double con valor 12.0
        System.out.println(list);//[10,"Hola",[],12.0]

    }
}