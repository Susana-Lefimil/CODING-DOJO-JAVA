import java.util.ArrayList;
public class Excepciones {
    public static void main(String[] args){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        myList.add(0.5);
        
        for(int i = 0; i < myList.size(); i++) {
           // System.out.println(myList.get(i));
            try {
            Integer castedValue = (Integer) myList.get(i);
            System.out.println("Es un numero entero: "+castedValue);
            } catch (ClassCastException e){
                System.out.println("No es numero entero: " + myList.get(i));
            }  
            
    }

  }
}