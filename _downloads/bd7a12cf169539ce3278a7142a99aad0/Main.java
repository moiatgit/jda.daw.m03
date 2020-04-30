/*
 * Demostració bàsica d'ús de spark
 *
 * El resultat és una única ruta que retorna 
 * un missatge de salutació
 */
import static spark.Spark.get;

public class Main {

    static String composaSalutacio(String nom) {
        if (nom == null || nom.isEmpty()) {
            nom = "món";
        }
        return "Hola <b>" + nom + "</b> des de Spark";
    }

    public static void main(String[] args) {
        get("/holaspark",
            (rq, rs) -> composaSalutacio(rq.queryParams("nom")));
    }
}
