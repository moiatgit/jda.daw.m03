/* Secció: Elements essencials
 * Entrada: Excepcions
 * Exercici: 2. Hora amb excepcions
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;
import static org.hamcrest.CoreMatchers.equalTo;

public class E010002HoraTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testHoraPerDefecte000() {
        Hora hora = new Hora();
        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraVàlidaAmbConstructorEspecific() throws Exception {
        Hora hora = new Hora(1, 2, 3);
        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixCorrecteQuanValorsAmbLimitSuperior() throws Exception {
        Hora hora = new Hora(23, 59, 59);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerHores() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(24, 2, 3) fora de rang"));
        Hora hora = new Hora(24, 2, 3);
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerHores() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(-24, 2, 3) fora de rang"));
        Hora hora = new Hora(-24, 2, 3);
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerMinuts() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(1, 60, 3) fora de rang"));
        Hora hora = new Hora(1, 60, 3);
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerMinuts() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(1, -6, 3) fora de rang"));
        Hora hora = new Hora(1, -6, 3);
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerSegons() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(1, 2, 60) fora de rang"));
        Hora hora = new Hora(1, 2, 60);
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerSegons() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora(1, 2, -1) fora de rang"));
        Hora hora = new Hora(1, 2, -1);
    }

    // Test increments/decrements

    @Test
    public void testHoraIncrementaCasEstandard() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaMinut() throws Exception {
        Hora hora = new Hora(1, 2, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 3, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaHora() throws Exception {
        Hora hora = new Hora(1, 59, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 2, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasReinicia() throws Exception {
        Hora hora = new Hora(23, 59, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasEstandard() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(2);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 5, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaMinut() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(59);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 3, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaHora() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(3539);

        Assert.assertEquals("Respecte a les hores", 2, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasReinicia() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(82739);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasGranN() throws Exception {
        Hora hora = new Hora(0, 0, 0);

        hora.incrementa(172737);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 58, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 57, hora.getSegons());
    }

    // test compareTo
    @Test
    public void testCompareToReconeixMenorMajor() throws Exception {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(horaMenor.compareTo(horaMajor)<0);
    }

    @Test
    public void testCompareToReconeixMajorMenor() throws Exception {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(horaMajor.compareTo(horaMenor)>0);
    }

    @Test
    public void testCompareToReconeixHoresIguals() throws Exception {
        Hora hora1 = new Hora(1, 2, 3);
        Hora hora2 = new Hora(1, 2, 3);

        Assert.assertEquals(0, hora1.compareTo(hora2));
    }

    // Test decrementa
    @Test
    public void testHoraIncrementaSegonsNegatius() throws Exception {
        Hora hora = new Hora(1, 2, 4);

        hora.incrementa(-1);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasEstandard() throws Exception {
        Hora hora = new Hora(1, 2, 4);

        hora.decrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaMinut() throws Exception {
        Hora hora = new Hora(0, 2, 3);


        hora.decrementa(60);
        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaHora() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasReinicia() throws Exception {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(1);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasEstandard() throws Exception {
        Hora hora = new Hora(1, 2, 5);

        hora.decrementa(2);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaMinut() throws Exception {
        Hora hora = new Hora(3, 2, 4);

        hora.decrementa(60);

        Assert.assertEquals("Respecte a les hores", 3, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaHora() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasReinicia() throws Exception {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(86399);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 1, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasGranN() throws Exception {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(432001);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNegatiu() throws Exception {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(-1);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    //  test de toString()
    @Test
    public void testHoraToStringGeneral() throws Exception {
        Hora hora = new Hora(11, 21, 31);
        String expected = "11:21:31";
        Assert.assertEquals(expected, hora.toString());
    }

    @Test
    public void testHoraToStringLeadingZeros() throws Exception {
        Hora hora = new Hora(1, 2, 3);
        String expected = "1:02:03";
        Assert.assertEquals(expected, hora.toString());
    }


    // test dels mètodes estàtics

    @Test
    public void testHoraEsValidaAmbValorsValids() {
        Assert.assertTrue(Hora.esValida(1, 2, 3));
    }

    @Test
    public void testHoraEsValidaAmbMassaHores() {
        Assert.assertFalse("Les hores no són vàlides", Hora.esValida(24, 2, 3));
    }

    @Test
    public void testHoraEsValidaAmbMassaPoquesHores() {
        Assert.assertFalse("Les hores no són vàlides", Hora.esValida(-1, 2, 3));
    }

    @Test
    public void testHoraEsValidaAmbMassaMinuts() {
        Assert.assertFalse("Els minuts no són vàlids", Hora.esValida(1, 60, 3));
    }

    @Test
    public void testHoraEsValidaAmbMassaPocsMinuts() {
        Assert.assertFalse("Els minuts no són vàlids", Hora.esValida(1, -1, 3));
    }

    @Test
    public void testHoraEsValidaAmbMassaSegons() {
        Assert.assertFalse("Els segons no són vàlids", Hora.esValida(1, 2, 60));
    }

    @Test
    public void testHoraEsValidaAmbMassaPocsSegons() {
        Assert.assertFalse("Els segons no són vàlids", Hora.esValida(1, 2, -1));
    }

    @Test
    public void testCompareToStaticReconeixMenorMajor() throws Exception {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(Hora.compareTo(horaMenor, horaMajor)<0);
    }

    @Test
    public void testCompareToStaticReconeixMajorMenor() throws Exception {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(Hora.compareTo(horaMajor, horaMenor)>0);
    }

    @Test
    public void testCompareToStaticReconeixHoresIguals() throws Exception {
        Hora hora1 = new Hora(1, 2, 3);
        Hora hora2 = new Hora(1, 2, 3);

        Assert.assertEquals(0, Hora.compareTo(hora1, hora2));
    }

    @Test
    public void testDuplicaHoraResultatAmbMateixosValors() throws Exception {
        Hora hora = new Hora(1, 2, 3);
        Hora duplicada = Hora.duplica(hora);

        Assert.assertEquals("Respecte a les hores", hora.getHores(), duplicada.getHores());
        Assert.assertEquals("Respecte als minuts", hora.getMinuts(), duplicada.getMinuts());
        Assert.assertEquals("Respecte als segons", hora.getSegons(), duplicada.getSegons());
    }

    @Test
    public void testDuplicaHoraResultatEsUnaAltraInstancia() throws Exception {
        Hora hora = new Hora(1, 2, 3);
        Hora duplicada = Hora.duplica(hora);

        Assert.assertFalse("L'hora duplicada no ha de ser la mateixa instància", hora == duplicada);
    }

    // Test dels setters amb excepcions

    @Test
    public void testSetHores_acceptaValorValid() throws Exception {
        Hora hora = new Hora();
        hora.setHores(23);
        Assert.assertEquals(23, hora.getHores());
    }

    @Test()
    public void testSetHores_acceptaValorMassaBaix() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setHores(-1) fora de rang"));
        hora.setHores(-1);
    }

    @Test
    public void testSetHores_acceptaValorMassaAlt() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setHores(24) fora de rang"));
        hora.setHores(24);
    }

    @Test
    public void testSetMinuts_acceptaValorValid() throws Exception {
        Hora hora = new Hora();
        hora.setMinuts(59);
        Assert.assertEquals(59, hora.getMinuts());
    }

    @Test
    public void testSetMinuts_acceptaValorMassaBaix() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setMinuts(-1) fora de rang"));
        hora.setMinuts(-1);
    }

    @Test
    public void testSetMinuts_acceptaValorMassaAlt() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setMinuts(60) fora de rang"));
        hora.setMinuts(60);
    }

    @Test
    public void testSetSegons_acceptaValorValid() throws Exception {
        Hora hora = new Hora();
        hora.setSegons(59);
        Assert.assertEquals(59, hora.getSegons());
    }

    @Test
    public void testSetSegons_acceptaValorMassaBaix() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setSegons(-1) fora de rang"));
        hora.setSegons(-1);
    }

    @Test
    public void testSetSegons_acceptaValorMassaAlt() throws Exception {
        Hora hora = new Hora();
        exception.expect(Exception.class);
        exception.expectMessage(equalTo("Hora.setSegons(60) fora de rang"));
        hora.setSegons(60);
    }


    public static void main(String[] args) {
        JUnitCore.main(new String[]{"E010002HoraTest"});
    }
}
