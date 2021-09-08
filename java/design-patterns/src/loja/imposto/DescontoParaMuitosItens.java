package loja.imposto;

import loja.Orcamento;

import java.math.BigDecimal;

public class DescontoParaMuitosItens extends Desconto{

    public DescontoParaMuitosItens(Desconto proximo) {
        super(proximo);
    }

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        if(orcamento.getQuantidadeItens() > 5){
            return orcamento.getValor().multiply(new BigDecimal("0.1"));
        }
        return proximo.calcular(orcamento);
    }
}
