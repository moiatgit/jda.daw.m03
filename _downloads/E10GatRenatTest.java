/* Secció: Elements essencials
 * Entrada: Classes i Objectes
 * Exercici: 10. Protegim encara més l’estat del Renat
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E10GatRenatTest {
    @Test
    public void testRenatNeixEstirat() {
        Assert.assertEquals("estirat", new GatRenat().getEstatComString());
    }
    @Test
    public void testRenatPotEstarDret() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        Assert.assertEquals("dret", renat.getEstatComString());
    }
    @Test
    public void testRenatPotEstarAssegut() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        Assert.assertEquals("assegut", renat.getEstatComString());
    }
    @Test
    public void testRenatPotEstirarse() {
        GatRenat renat = new GatRenat();
        renat.setEstat("assegut");
        renat.setEstat("estirat");
        Assert.assertEquals("estirat", renat.getEstatComString());
    }
    @Test
    public void testRenaNoPotCorrer() {
        GatRenat renat = new GatRenat();
        renat.setEstat("corrent");
        Assert.assertEquals("estirat", renat.getEstatComString());
    }
    public void testRenatSetEstatPotRebreNull() {
        GatRenat renat = new GatRenat();
        renat.setEstat((String)null);
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

    @Test
    public void testRenatSEstira() {
        GatRenat renat = new GatRenat();
        renat.setEstat("dret");
        String resposta = renat.estirat();
        Assert.assertTrue(renat.estaEstirat());
        Assert.assertEquals("m'estiro", resposta);
    }
    @Test
    public void testRenatSeu() {
        GatRenat renat = new GatRenat();
        String resposta = renat.seu();
        Assert.assertTrue(renat.estaAssegut());
        Assert.assertEquals("m'assec", resposta);
    }
    @Test
    public void testRenatSAixeca() {
        GatRenat renat = new GatRenat();
        String resposta = renat.aixecat();
        Assert.assertTrue(renat.estaDret());
        Assert.assertEquals("m'aixeco", resposta);
    }
    @Test
    public void testRenatNoFaResQuanDemanemQueSEstiriIJaHoEstava() {
        GatRenat renat = new GatRenat();
        String resposta = renat.estirat();
        Assert.assertEquals("no faig res", resposta);
    }
    @Test
    public void testRenatNoFaResQuanDemanemQueSAsseguiIJaHoEstava() {
        GatRenat renat = new GatRenat();
        renat.seu();
        String resposta = renat.seu();
        Assert.assertEquals("no faig res", resposta);
    }

    @Test
    public void testRenatNoFaResQuanDemanemQueSAixequiIJaHoEstava() {
        GatRenat renat = new GatRenat();
        renat.aixecat();
        String resposta = renat.aixecat();
        Assert.assertEquals("no faig res", resposta);
    }

    @Test
    public void testRenatCanviaEstatAmbGatEstat() {
        GatRenat renat = new GatRenat();
        renat.setEstat(GatEstat.ESTIRAT);
        renat.setEstat(GatEstat.ASSEGUT);
        renat.setEstat(GatEstat.DRET);
        Assert.assertEquals(GatEstat.DRET, renat.getEstat());
    }

    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E10GatRenatTest"});
    }
}
