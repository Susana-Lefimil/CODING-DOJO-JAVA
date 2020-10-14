import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String,String> listSong = new HashMap<String, String>();
        listSong.put("knight_of_cydonia", "Muse, Matt Bellamy, No one's going to take me alive Time has come to make things right ");
        listSong.put("The_death_of_you_and_me", "Noel Gallagher's High Flying Birds, Noel Gallagher, Calling out to me I seem to spend my whole life, running");
        listSong.put("Love_will_tear_us_apart_again", "Joy division, Ian Curtis, When routine bites hard And ambitions are low");
        listSong.put("Sweet_Dreams_TN", "The Last Shadow Puppets, Alex Turner, I just sort of always feel sick without you baby");
        
        System.out.printf("\n");
        System.out.printf("--------------------Letra Knight of Cydonia--------------- \n");
        String user = listSong.get("knight_of_cydonia");
        String [] datos = user.split(", ");
        System.out.println("\n Letra : " + datos[2]);
       
       
        System.out.printf("\n --------------------Listado de canciones---------------\n \n");
        // get the keys by using the keySet method
        Set<String> keys = listSong.keySet();
        for(String key : keys) {
           // System.out.println(key);
           // System.out.println(listSong.get(key));
            System.out.printf("%s : %s \n", key, listSong.get(key));    
            System.out.printf("\n");
        }
    }
}