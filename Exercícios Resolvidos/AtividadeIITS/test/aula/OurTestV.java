package aula;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OurTest.class, OurTestII.class, OurTestIII.class, OurTestIV.class })
public class OurTestV {

}

//Quest�o 6
//Na Classe parametrizada, n�o � poss�vel aplicar a mesma classe (construtor) para todos os testes, pois em algumas
//situa��es, � necess�rio mudar alguns parametros (como por exemplo, os tipos).

//Quest�o 7
//O Suite de testes � utilizado para agrupar alguns casos de testes de unidade e executa-los juntos.
