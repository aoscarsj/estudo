package loja.imposto;

import loja.Orcamento;

import java.math.BigDecimal;
//Usando o padrao Chain Of Responsibility
public abstract class Desconto {
    protected Desconto proximo;

    public Desconto(Desconto proximo) {
        this.proximo = proximo;
    }
    public abstract BigDecimal calcular (Orcamento orcamento);

}
