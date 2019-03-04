/* Secció: Elements essencials
 * Entrada: Classes i Objectes
 * Exercici: 7. L’estat del Renat és sempre bo!
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E7GatRenatTest {
    @Test
    public void testRenatNeixEstirat() {
        Assert.assertEquals("estirat", new GatRenat().getEstat());
    }
    @Test
    public void testRenatPotEstarDret() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        Assert.assertEquals("dret", renat.getEstat());
    }
    @Test
    public void testRenatPotEstarAssegut() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        Assert.assertEquals("assegut", renat.getEstat());
    }
    @Test
    public void testRenatPotEstirarse() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        renat.setEstat("estirat");
        Assert.assertEquals("estirat", renat.getEstat());
    }
    @Test
    public void testRenaNoPotCorrer() {
        GatRenat renat = new GatRenat();
        renat.setEstat("corrent");
        Assert.assertEquals("estirat", renat.getEstat());
    }
    @Test
    public void testRenatSetEstatPotRebreNull() {
        GatRenat renat = new GatRenat();
        renat.setEstat(null);
        Assert.assertEquals("estirat", renat.getEstat());
    }

    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E7GatRenatTest"});
    }
}
