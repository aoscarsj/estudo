package loja.imposto;

import loja.Orcamento;

import java.math.BigDecimal;
// patern Strategy. Baseia-se em evitar que a cresca
public interface Imposto {
    BigDecimal calcular(Orcamento orcamento);
}


