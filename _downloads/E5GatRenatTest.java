/* Secció: Elements essencials
 * Entrada: Classes i Objectes
 * Exercici: 5. Renat té estat
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E5GatRenatTest {
    @Test
    public void testRenatNeixEstirat() {
        Assert.assertEquals("estirat", new GatRenat().estat);
    }

    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E5GatRenatTest"});
    }
}
