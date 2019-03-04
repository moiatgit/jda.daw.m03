/* Secció: Elements essencials
 * Entrada: Membres d'instància i de classe
 * Exercici: 2. Propietats de classe
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E004002GatRenatTest {
    @Test
    public void testGatRenatImplementaIds() {
        // no es pot realitzar aquest test amb mètodes separats doncs no es pot garantir l'ordre
        // d'execució dels mètodes i aquest és important a l'hora de comprovar el valor de la
        // propietat estàtica.

        // comprovació del primer id assignat
        GatRenat renat1 = new GatRenat();
        Assert.assertEquals("El primer gat ha de tenir id 1.", 1, renat1.getId());

        // comprovació del segon id assignat
        GatRenat renat2 = new GatRenat();
        Assert.assertEquals("El segon gat ha de tenir id 2.", 2, renat2.getId());

        // comprovació de que el primer gat continua mantenint l'id
        Assert.assertEquals("El primer gat ha de mantenir id.", 1, renat1.getId());

        // comprovació del retorn adequat per toString()
        Assert.assertEquals("Gat Renat (2) amb 7 vides", renat2.toString());
    }

    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E004002GatRenatTest"});
    }
}
