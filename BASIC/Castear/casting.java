public class casting {

    public static void hello(String name) {
        System.out.println("Hola " + name);
    }

    public static void sum(int a, int b) {
        int c = a + b;
        String mensaje = "El numero resultado es:";
        System.out.println(mensaje + c);
    }

    public static void main(String[] args) {
        int asd = 35;
        float f = asd;

        String str = "El numero es: " + f;
        System.out.println(str);

        casting.hello("Jaime");
        casting.sum(3, 3);

        int dd = 10;
        byte i = (byte) dd;
        str = "El numero es: " + i;
        System.out.println(str);

    }
}

    //Convirtiendo del valor de double dd en un int
    /*
    * comentario bloque
    
    int ii=(int) dd;
    System.out.println(i);
    System.out.println(ii);
    System.out.println(x);


    int asd=35;
    float f =asd;
    System.out.println("EL numero es: " + f);
    System.out.println(str);

*/

