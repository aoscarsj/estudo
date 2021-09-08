package loja.imposto;

import loja.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento){
        Desconto desconto = new DescontoParaMuitosItens(new DescontoParaValorAlto(
                new SemDesconto()
        ));
        return desconto.calcular(orcamento);
    }
}
