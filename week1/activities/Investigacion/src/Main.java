import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        // Array – El Cofre Ordenado
        int [] favorites = {26,82,9,8,6};

        System.out.println("Elemento en posición 0: " + favorites[0]);
        System.out.println("Elemento en posición 4: " + favorites[4]);
        favorites[2] = 28;
        System.out.println("Elemento en posicion 2: "+ favorites[2]);

        System.out.println("\n---------------------------------\n");

        // ArrayList – La Mochila Mágica
        ArrayList<String> mochila = new ArrayList<>();
        mochila.add("Espada");
        mochila.add("Camisa");
        mochila.add("Poción");
        System.out.println("Mochila tiene: "+mochila);
        System.out.println("El segundo objeto es: "+mochila.get(1));
        mochila.remove(0);
        System.out.println("Mochila actualizada tiene: "+mochila);

        System.out.println("\n---------------------------------\n");

        // HashMap – El Mapa del Tesoro
        HashMap<String, Integer> tesoros = new HashMap<>();
        tesoros.put("Oro", 100);
        tesoros.put("Plata", 50);
        tesoros.put("Diamantes", 5);

        System.out.println("Total de Diamantes es: "+tesoros.get("Diamantes"));
        tesoros.put("Oro", 200);
        System.out.println("Total de Oro es: "+tesoros.get("Oro"));

        System.out.println("\n---------------------------------\n");

        // Desafío Final
        int [] codes = {958,576,415};
        ArrayList<String> nameExplorers = new ArrayList<>();
        nameExplorers.add("Jhon");
        nameExplorers.add("Zoe");
        nameExplorers.add("Mio");

        HashMap<String, Integer> OroExplorers = new HashMap<>();
        OroExplorers.put(nameExplorers.get(0),520);
        OroExplorers.put(nameExplorers.get(1),670);
        OroExplorers.put(nameExplorers.get(2),920);

        if (OroExplorers.get(nameExplorers.get(0)) > OroExplorers.get(nameExplorers.get(1)) && OroExplorers.get(nameExplorers.get(0)) > OroExplorers.get(nameExplorers.get(2))){
            System.out.println(nameExplorers.get(0)+" tiene más Oro que el resto");
        } else if (OroExplorers.get(nameExplorers.get(1)) > OroExplorers.get(nameExplorers.get(2))) {
            System.out.println(nameExplorers.get(1)+" tiene más Oro que el resto");
        } else {
            System.out.println(nameExplorers.get(2)+" tiene más Oro que el resto");
        }
    }
}