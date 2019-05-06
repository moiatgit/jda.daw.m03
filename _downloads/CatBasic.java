import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class CatBasic {
    public static ArrayList<String> llegeixFitxer(String path) {
        ArrayList<String> linies = new ArrayList<String>();

        FileReader fr = null;
        try {
            fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String linia;
            while ((linia = reader.readLine()) != null) {
                linies.add(linia);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No es troba el fitxer " + path + ": " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ops: s'ha produït una excepció d'entrada/sortida: " + e.getMessage());
        } finally{
            try {
                if (fr != null) {   // podria no estar encara inicialitzat!
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Sí, quan tanques també es pot produir una excepció!: "+ e.getMessage());
            }
        }
        return linies;
    }

    private static void mostraLinies(String path, ArrayList<String> linies) {
        System.out.println("\n\nContinguts del fitxer " + path);
        for (int linia=0; linia < linies.size(); linia++) {
            System.out.printf("Línia [%d]: '%s'\n", linia + 1, linies.get(linia));
        }
    }

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Indica un o més paràmetres");
            return;
        }
        for (String path: args) {
            ArrayList<String> linies = llegeixFitxer(path);
            mostraLinies(path, linies);
        }
    }
}
