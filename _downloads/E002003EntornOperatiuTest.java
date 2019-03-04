/* Secció: Elements essencials
 * Entrada: Constructors I
 * Exercici: 3. L'entorn operatiu
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;

public class E002003EntornOperatiuTest {
    private EntornOperatiu entornAmbGatIntern;
    private EntornOperatiu entornAmbGatExtern;
    private GatRenat renat;

    @Before
    public void start() {
        entornAmbGatIntern = new EntornOperatiu();
        renat = new GatRenat();
        entornAmbGatExtern = new EntornOperatiu(renat);
    }

    @Test
    public void testEntornOperatiuEsPotCrear() {
        Assert.assertEquals("estic dret", entornAmbGatIntern.processaEntrada("com estàs?"));
        Assert.assertEquals("dret", renat.getEstatComString());
    }

    @Test
    public void testProcessaAdeu() {
        String resposta = entornAmbGatIntern.processaEntrada("adéu");
        Assert.assertEquals("adéu", resposta);
        Assert.assertTrue(entornAmbGatIntern.demanaSortir("adéu"));
    }

    @Test
    public void testComandaDesconeguda() {
        String resposta = entornAmbGatIntern.processaEntrada("hola");
        Assert.assertEquals("no t'entenc", resposta);
    }

    @Test
    public void testNoConsideraCase() {
        String resposta = entornAmbGatIntern.processaEntrada("AdéU");
        Assert.assertEquals("adéu", resposta);
    }

    @Test
    public void testProcessaSeu() {
        String resposta = entornAmbGatIntern.processaEntrada("seu");
        Assert.assertEquals("m'assec", resposta);

        entornAmbGatExtern.processaEntrada("seu");
        Assert.assertEquals("assegut", renat.getEstatComString());
    }

    @Test
    public void testProcessaAixecat() {
        String resposta = entornAmbGatIntern.processaEntrada("aixeca't");
        Assert.assertEquals("no faig res", resposta); // està dret d'inici

        renat.seu();    // perquè no estigui dret
        entornAmbGatExtern.processaEntrada("aixeca't");
        Assert.assertEquals("dret", renat.getEstatComString());
    }

    @Test
    public void testProcessaEstirat() {
        String resposta = entornAmbGatIntern.processaEntrada("seu");
        Assert.assertEquals("m'assec", resposta);

        entornAmbGatExtern.processaEntrada("seu");
        Assert.assertEquals("assegut", renat.getEstatComString());
    }


    public static void main(String[] args) {
        JUnitCore.main(new String[]{"E002003EntornOperatiuTest"});
    }

}
