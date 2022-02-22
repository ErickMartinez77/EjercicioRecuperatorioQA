package ejercicioRecuperatorioTest;

import ejercicioRecuperatorio.Helpers;
import ejercicioRecuperatorio.Utils;
import ejercicioRecuperatorio.VerificarBeca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class VerificarBecaTest {
    Utils utilsMock = Mockito.mock(Utils.class);
    @BeforeAll
    public static void before(){
        MockedStatic<Helpers> helpersMockedStatic = Mockito.mockStatic(Helpers.class);

        helpersMockedStatic.when(()->Helpers.aplicaBeca(123)).thenReturn(false);

        helpersMockedStatic.when(()->Helpers.aplicaBeca(1234)).thenReturn(true);

        helpersMockedStatic.when(()->Helpers.aplicaBeca(12345)).thenReturn(true);
    }
    @Test
    public void verifyBecaA(){
        Mockito.when(utilsMock.getNota(123)).thenReturn(90);

        VerificarBeca verificarBeca = new VerificarBeca(utilsMock);
        Assertions.assertEquals("EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS", verificarBeca.recomendacionBeca(123),"ERROR");
    }
    @Test
    public void verifyBecaB(){
        Mockito.when(utilsMock.getNota(1234)).thenReturn(90);

        VerificarBeca verificarBeca = new VerificarBeca(utilsMock);
        Assertions.assertEquals("SI APLICA BECA", verificarBeca.recomendacionBeca(1234),"ERROR");
    }
    @Test
    public void verifyBecaC(){
        Mockito.when(utilsMock.getNota(12345)).thenReturn(60);

        VerificarBeca verificarBeca = new VerificarBeca(utilsMock);
        Assertions.assertEquals("NO APLICA A BECA POR PROMEDIO ACADEMICO", verificarBeca.recomendacionBeca(12345),"ERROR");
    }

}
