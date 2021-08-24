package service;

import modelo.Desempenho;
import modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    //@BeforeAll -> Antes de todos -> roda 1x // precisa ser estatico
    //AfterAll -> Depois de todos -> roda 1x // precisa ser estatico
    //BeforeEach -> Antes de cada um dos testes -> roda nx
    //AfterEach -> Depois de ca um dos metodos -> roda nx

    @BeforeEach
    public void inicializar (){
        service = new ReajusteService();
        funcionario = new Funcionario("Carina", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveriaSerTresPercentQndDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerQuinzePercentQndDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerVintePercentQndDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
