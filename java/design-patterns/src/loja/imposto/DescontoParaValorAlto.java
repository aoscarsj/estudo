package loja.imposto;

import loja.Orcamento;

import java.math.BigDecimal;

public class DescontoParaValorAlto extends Desconto{

    public DescontoParaValorAlto(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getValor().compareTo(new BigDecimal("500")) > 0){
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        }
        return proximo.calcular(orcamento);
    }
}
