/*
 * Implementació de la classe Zoo
 *
 * Encapsula una col·lecció d'animals guardats a una base de dades
 *
 * En aquesta versió, de moment només s'implementen els mètodes de
 * connexió i desconnexió.
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Zoo {
    private static final String NOM_BASE_DE_DADES = "animals.bd";
    private static final String CADENA_DE_CONNEXIO = "jdbc:sqlite:" + NOM_BASE_DE_DADES;
    private Connection conn = null;

    public String connecta() throws SQLException {
        if (conn != null) {
            return "Ja connectat";
        }
        conn = DriverManager.getConnection(CADENA_DE_CONNEXIO);
        return "Connectat a " + NOM_BASE_DE_DADES;
    }

    public String desconnecta() throws SQLException {
        if (conn == null) {
            return "Ja desconnectat";
        }
        conn.close();
        return "Desconnectat";
    }
}
