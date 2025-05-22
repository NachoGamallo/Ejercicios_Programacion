import org.example.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.Assert.assertEquals;

public class CalculadoraNGLTest {

    private Calculadora calc;

    @BeforeEach
    public void inicioPruebas(){
        calc = new Calculadora(30, 10);
    }
    @AfterEach
    public void finPruebas(){
        calc = null;
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "4, 5, 9", "-1, -2, -3", "0, 0, 0"})
    public void testSumaConCvsSource(int a, int b, int valorEsperado){
        Calculadora calc = new Calculadora(a, b);
        int valorDevuelto = calc.suma();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testSumaConValueSource(int num){
        Calculadora calc = new Calculadora(num,5);
        int valorEsperado = num + 5;
        int valorDevuelto = calc.suma();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @Test
    public void testSuma(){
        int valorEsperado = 40;
        int valorDevuelto = calc.suma();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 1", "4, 5, -1", "1, 2, -1", "0, 0, 0"})
    public void testrestaConCvsSource(int a, int b, int valorEsperado){
        Calculadora calc = new Calculadora(a, b);
        int valorDevuelto = calc.resta();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testrestaConValueSource(int num){
        Calculadora calc = new Calculadora(num,5);
        int valorEsperado = num - 5;
        int valorDevuelto = calc.resta();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @Test
    public void testResta(){
        int valorEsperado = 20;
        int valorDevuelto = calc.resta();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 2", "4, 5, 20", "2, 2, 4", "0, 0, 0"})
    public void testmultConCvsSource(int a, int b, int valorEsperado){
        Calculadora calc = new Calculadora(a, b);
        int valorDevuelto = calc.multiplica();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testmultConValueSource(int num){
        Calculadora calc = new Calculadora(num,5);
        int valorEsperado = num * 5;
        int valorDevuelto = calc.multiplica();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @Test
    public void testMultiplicacion(){
        int valorEsperado = 300;
        int valorDevuelto = calc.multiplica();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @ParameterizedTest
    @CsvSource({"2, 1, 2", "5, 2, 2", "10, 5, 2", "10, 2, 5"})
    public void testdivConCvsSource(int a, int b, int valorEsperado){
        Calculadora calc = new Calculadora(a, b);
        int valorDevuelto = calc.divide();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testdivConValueSource(int num){
        Calculadora calc = new Calculadora(num,5);
        int valorEsperado = num/5;
        int valorDevuelto = calc.divide();
        assertEquals(valorEsperado,valorDevuelto);
    }

    @Test
    public void testDivide(){
        int valorEsperado = 3;
        int valorDevuelto = calc.divide();
        assertEquals(valorEsperado,valorDevuelto);
    }
    @Test
    public void testDivisionException(){
        Calculadora calc = new Calculadora(6,0);
        String valorEsperado = "Division por 0";
        String valorDevuelto = "";
        try {
            calc.divide();
        }catch (ArithmeticException e){
            valorDevuelto = e.getMessage();
        }
        assertEquals(valorEsperado,valorDevuelto);
    }
}



