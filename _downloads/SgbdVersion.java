/*
 * Obté la versió del servidor de PostgreSQL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
public class SgbdVersion {
    /* (2) realitza la connexió i la retorna */
    private static Connection connecta() throws SQLException {
        // (1) construcció del conjunt de Properties
        Properties prop = new Properties();
        prop.put("user",  "usuaribd");
        prop.put("password",  "pass");
        String host = "192.168.33.10";
        String bd   = "testbd";
        String cadenaConnexio = "jdbc:postgresql://" + host + "/" + bd;
        return DriverManager.getConnection(cadenaConnexio, prop);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = connecta();
        Statement st = conn.createStatement(); // (3) crea un Statement
        String query = "SELECT version()";     // defineix la query
        ResultSet rs = st.executeQuery(query); // (4) crea un ResultSet
        rs.next();                             // (5) recupera el resultat
        String versio = rs.getString(1);
        System.out.println("Versió: " + versio);
        rs.close();                            // tanca ResultSet
        st.close();                            // tanca Statement
        conn.close();                          // tanca connexió
    }
}

