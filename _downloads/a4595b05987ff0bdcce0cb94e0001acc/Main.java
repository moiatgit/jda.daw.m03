/*
 * Demostració bàsica d'ús de spark
 *
 * El resultat és una única ruta que retorna 
 * un missatge de salutació
 */

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFiles;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

    static String composaSalutacio(String nom) {
        if (nom == null || nom.isEmpty()) {
            nom = "món";
        }
        return nom;
    }

    public static void main(String[] args) {
        staticFiles.location("/");

        get("/holaspark",
            (rq, rs) -> {
                String nom = composaSalutacio(rq.queryParams("nom"));
                Map<String, Object> params = new HashMap<>();
                params.put("nom", nom);
                return new ModelAndView(params, "holaspark.html");
        }, new FreeMarkerEngine());
    }
}
