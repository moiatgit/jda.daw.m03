/*
 * Aquesta classe comprova la funcionalitat de la classe Zoo
 */

import java.sql.SQLException;

public class Main {
    public static void main( String args[]) throws SQLException {
        Zoo zoo = new Zoo();

        System.out.print("Primer connectem amb la base de dades: ");
        String resposta = zoo.connecta();
        System.out.println(resposta);

        System.out.print("Finalment tanquem la connexió amb la base de dades: ");
        resposta = zoo.desconnecta();
        System.out.println(resposta);
    }
}
