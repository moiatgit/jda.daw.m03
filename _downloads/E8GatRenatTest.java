/* Secció: Elements essencials
 * Entrada: Classes i Objectes
 * Exercici: 8. Com està Renat?
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E8GatRenatTest {
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
    @Test
    public void testRenatNeixViu() {
        Assert.assertTrue(new GatRenat().estaViu());
    }
    @Test
    public void testRenatNoEstaViuAmbZeroVides() {
        GatRenat renat = new GatRenat();
        renat.setVides(0);
        Assert.assertFalse(renat.estaViu());
    }
    @Test
    public void testRenatDiuEstarEstiratEnNeixer() {
        Assert.assertTrue(new GatRenat().estaEstirat());
    }
    @Test
    public void testRenatDiuNoEstarEstiratQuanDret() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        Assert.assertFalse(renat.estaEstirat());
    }
    @Test
    public void testRenatDiuEstarAssegutQuanHoEsta() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        Assert.assertTrue(renat.estaAssegut());
    }
    @Test
    public void testRenatDiuNoEstarAssegutQuanNoHoEsta() {
        Assert.assertFalse(new GatRenat().estaAssegut());
    }
    @Test
    public void testRenatDiuEstarDretQuanHoEsta() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        Assert.assertTrue(renat.estaDret());
    }
    @Test
    public void testRenatDiuNoEstarDretQuanNoHoEsta() {
        Assert.assertFalse(new GatRenat().estaDret());
    }

    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E8GatRenatTest"});
    }
}
