package rh.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
    private String nome;
    private String cpf;
    private Cargo cargo;
    private BigDecimal salario;
    private LocalDate dataUltimoReajuste;

    public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }
    public void atualizarSalario(BigDecimal novoSalario){
        this.salario = novoSalario;
        this.dataUltimoReajuste = LocalDate.now();
    }
    public BigDecimal getSalario() {
        return salario;
    }
}
