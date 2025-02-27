import org.example.Calculadora;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculadoraNGLTest.class,
        OtraClaseDePruebas.class
})

public class SuiteTestNGL {

}

