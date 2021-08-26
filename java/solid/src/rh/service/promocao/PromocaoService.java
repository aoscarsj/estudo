package rh.service.promocao;

import rh.ValidacaoException;
import rh.model.Cargo;
import rh.model.Funcionario;

public class PromocaoService {

    public void promover(Funcionario funcionario, boolean metaBatida){
        Cargo cargoAtual = funcionario.getCargo();
        if(cargoAtual == Cargo.GERENTE){
            throw new ValidacaoException("Gerentes nao podem ser promovidos!");
        }
        if(!metaBatida){
            throw new ValidacaoException("Funcionario nao bateu a meta!");
        }
        Cargo novoCargo = cargoAtual.getProximoCargo();
        funcionario.promover(novoCargo);
    }
}
