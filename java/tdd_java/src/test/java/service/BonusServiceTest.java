package service;

import modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveSerZeroParaFuncionarioComSalarioAlto(){
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Artur", LocalDate.now(), new BigDecimal("30000") ) ));

    }

    @Test
    void bonusDeveSerDezPercentDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Oscar", LocalDate.now(), new BigDecimal("250")));

        assertEquals(new BigDecimal("25.00"), bonus);
    }
    @Test
    void bonusDeveSerDezPercentParaSalario10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Junior", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}