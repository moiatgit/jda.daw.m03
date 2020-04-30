/*
 * Demostració de test unitari a una aplicació amb Spark
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMain{
    @Test
    public void quanLiPassoWendel() {
        String nom = "Wendel";
        String esperat = "Hola <b>Wendel</b> des de Spark";
        String obtingut = Main.composaSalutacio(nom);
        assertEquals(esperat, obtingut);
    }
    @Test
    public void quanLiPassoNull() {
        String nom = null;
        String esperat = "Hola <b>món</b> des de Spark";
        String obtingut = Main.composaSalutacio(nom);
        assertEquals(esperat, obtingut);
    }

    @Test
    public void quanLiPassoBuit() {
        String nom = "";
        String esperat = "Hola <b>món</b> des de Spark";
        String obtingut = Main.composaSalutacio(nom);
        assertEquals(esperat, obtingut);
    }
}
