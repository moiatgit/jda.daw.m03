/*
 * Programa que ofereix una interfície de l'EntornOperatiu
 * als usuaris per Web
 */

import static spark.Spark.get;

public class Main {

    public static void main(String[] args) {
        EntornOperatiu entorn = new EntornOperatiu();
        get("/renat", (rq, rs) -> {
            String comanda = rq.queryParams("comanda");
            if (comanda == null) {
                comanda = "";
            }
            String resultat = entorn.processaEntrada(comanda);
            return resultat;
        });
    }

}
