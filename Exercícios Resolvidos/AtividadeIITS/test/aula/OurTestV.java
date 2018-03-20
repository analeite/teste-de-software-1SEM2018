package aula;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ OurTest.class, OurTestII.class, OurTestIII.class, OurTestIV.class })
public class OurTestV {

}

//Questão 6
//Na Classe parametrizada, não é possível aplicar a mesma classe (construtor) para todos os testes, pois em algumas
//situações, é necessário mudar alguns parametros (como por exemplo, os tipos).

//Questão 7
//O Suite de testes é utilizado para agrupar alguns casos de testes de unidade e executa-los juntos.
