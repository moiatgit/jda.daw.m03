/* Secció: Elements essencials
 * Entrada: Excepcions
 * Exercici: 1. Hora amb control d'errors
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class E010001HoraTest {

    @Test
    public void testHoraPerDefecte000() {
        Hora hora = new Hora();
        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixCorrecteQuanValorsAmbLimitSuperior() {
        Hora hora = new Hora(23, 59, 59);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraConstructorEspecific() {
        Hora hora = new Hora(1, 2, 3);
        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerHores() {
        Hora hora = new Hora(24, 2, 3);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerHores() {
        Hora hora = new Hora(-24, 2, 3);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerMinuts() {
        Hora hora = new Hora(1, 60, 3);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerMinuts() {
        Hora hora = new Hora(1, -6, 3);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNoValidPerSegons() {
        Hora hora = new Hora(1, 2, 60);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraConstrueixPerDefecteQuanValorNegatiuPerSegons() {
        Hora hora = new Hora(1, 2, -1);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasEstandard() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaMinut() {
        Hora hora = new Hora(1, 2, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 3, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasIncrementaHora() {
        Hora hora = new Hora(1, 59, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 2, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaCasReinicia() {
        Hora hora = new Hora(23, 59, 59);

        hora.incrementa();

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 0, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasEstandard() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(2);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 5, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaMinut() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(59);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 3, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasIncrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(3539);

        Assert.assertEquals("Respecte a les hores", 2, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasReinicia() {
        Hora hora = new Hora(1, 2, 3);

        hora.incrementa(82739);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 2, hora.getSegons());
    }

    @Test
    public void testHoraIncrementaNCasGranN() {
        Hora hora = new Hora(0, 0, 0);

        hora.incrementa(172737);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 58, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 57, hora.getSegons());
    }

    // test compareTo
    @Test
    public void testCompareToReconeixMenorMajor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(horaMenor.compareTo(horaMajor)<0);
    }

    @Test
    public void testCompareToReconeixMajorMenor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(horaMajor.compareTo(horaMenor)>0);
    }

    @Test
    public void testCompareToReconeixHoresIguals() {
        Hora hora1 = new Hora(1, 2, 3);
        Hora hora2 = new Hora(1, 2, 3);

        Assert.assertEquals(0, hora1.compareTo(hora2));
    }

    // Test decrementa
    @Test
    public void testHoraIncrementaSegonsNegatius() {
        Hora hora = new Hora(1, 2, 4);

        hora.incrementa(-1);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasEstandard() {
        Hora hora = new Hora(1, 2, 4);

        hora.decrementa();

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaMinut() {
        Hora hora = new Hora(0, 2, 3);


        hora.decrementa(60);
        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasDecrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaCasReinicia() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(1);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasEstandard() {
        Hora hora = new Hora(1, 2, 5);

        hora.decrementa(2);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaMinut() {
        Hora hora = new Hora(3, 2, 4);

        hora.decrementa(60);

        Assert.assertEquals("Respecte a les hores", 3, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 1, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasDecrementaHora() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(3600);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 3, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasReinicia() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(86399);

        Assert.assertEquals("Respecte a les hores", 0, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 0, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 1, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNCasGranN() {
        Hora hora = new Hora(0, 0, 0);

        hora.decrementa(432001);

        Assert.assertEquals("Respecte a les hores", 23, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 59, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 59, hora.getSegons());
    }

    @Test
    public void testHoraDecrementaNegatiu() {
        Hora hora = new Hora(1, 2, 3);

        hora.decrementa(-1);

        Assert.assertEquals("Respecte a les hores", 1, hora.getHores());
        Assert.assertEquals("Respecte als minuts", 2, hora.getMinuts());
        Assert.assertEquals("Respecte als segons", 4, hora.getSegons());
    }

    //  test de toString()
    @Test
    public void testHoraToStringGeneral() {
        Hora hora = new Hora(11, 21, 31);
        String expected = "11:21:31";
        Assert.assertEquals(expected, hora.toString());
    }

    @Test
    public void testHoraToStringLeadingZeros() {
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
    public void testCompareToStaticReconeixMenorMajor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(Hora.compareTo(horaMenor, horaMajor)<0);
    }

    @Test
    public void testCompareToStaticReconeixMajorMenor() {
        Hora horaMenor = new Hora(1, 2, 3);
        Hora horaMajor = new Hora(1, 2, 4);

        Assert.assertTrue(Hora.compareTo(horaMajor, horaMenor)>0);
    }

    @Test
    public void testCompareToStaticReconeixHoresIguals() {
        Hora hora1 = new Hora(1, 2, 3);
        Hora hora2 = new Hora(1, 2, 3);

        Assert.assertEquals(0, Hora.compareTo(hora1, hora2));
    }

    @Test
    public void testDuplicaHoraResultatAmbMateixosValors() {
        Hora hora = new Hora(1, 2, 3);
        Hora duplicada = Hora.duplica(hora);

        Assert.assertEquals("Respecte a les hores", hora.getHores(), duplicada.getHores());
        Assert.assertEquals("Respecte als minuts", hora.getMinuts(), duplicada.getMinuts());
        Assert.assertEquals("Respecte als segons", hora.getSegons(), duplicada.getSegons());
    }

    @Test
    public void testDuplicaHoraResultatEsUnaAltraInstancia() {
        Hora hora = new Hora(1, 2, 3);
        Hora duplicada = Hora.duplica(hora);

        Assert.assertFalse("L'hora duplicada no ha de ser la mateixa instància", hora == duplicada);
    }

    // Test dels setters amb valor de retorn
    @Test
    public void testSetHores_acceptaValorValid() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setHores(23);
        Assert.assertEquals(23, hora.getHores());
        Assert.assertTrue(valorModificat);
    }

    @Test
    public void testSetHores_acceptaValorMassaBaix() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setHores(-1);
        Assert.assertEquals(0, hora.getHores());
        Assert.assertFalse(valorModificat);
    }

    @Test
    public void testSetHores_acceptaValorMassaAlt() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setHores(24);
        Assert.assertEquals(0, hora.getHores());
        Assert.assertFalse(valorModificat);
    }

    @Test
    public void testSetMinuts_acceptaValorValid() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setMinuts(59);
        Assert.assertEquals(59, hora.getMinuts());
        Assert.assertTrue(valorModificat);
    }

    @Test
    public void testSetMinuts_acceptaValorMassaBaix() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setMinuts(-1);
        Assert.assertEquals(0, hora.getMinuts());
        Assert.assertFalse(valorModificat);
    }

    @Test
    public void testSetMinuts_acceptaValorMassaAlt() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setMinuts(60);
        Assert.assertEquals(0, hora.getMinuts());
        Assert.assertFalse(valorModificat);
    }

    @Test
    public void testSetSegons_acceptaValorValid() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setSegons(59);
        Assert.assertEquals(59, hora.getSegons());
        Assert.assertTrue(valorModificat);
    }

    @Test
    public void testSetSegons_acceptaValorMassaBaix() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setSegons(-1);
        Assert.assertEquals(0, hora.getSegons());
        Assert.assertFalse(valorModificat);
    }

    @Test
    public void testSetSegons_acceptaValorMassaAlt() {
        Hora hora = new Hora();
        boolean valorModificat = hora.setSegons(60);
        Assert.assertEquals(0, hora.getSegons());
        Assert.assertFalse(valorModificat);
    }


    public static void main(String[] arrstring) {
        JUnitCore.main(new String[]{"E010001HoraTest"});
    }
}
