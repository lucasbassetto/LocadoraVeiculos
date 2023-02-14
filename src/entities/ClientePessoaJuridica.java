package entities;

import exception.BusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientePessoaJuridica implements Clientes {

    private String cnpj;
    private String companyName;

    public ClientePessoaJuridica(String cnpj, String companyName) {
        this.cnpj = cnpj;
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ClientePessoaJuridica(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public boolean verificar(List<Clientes> cliente, String ID) {
        if (!cliente.isEmpty()) {
            for (Clientes clientes: cliente){
                if (Objects.equals(clientes.getId(), cnpj)){
                    throw new BusinessException("Este cliente já está cadastrado em nosso sistema, por favor, tente novamente.");
                }
            }
        }
        return false;
    }

    @Override
    public void editar(List<Clientes> cliente, String nome, String cnpj) {
        if (verificar(cliente,cnpj)){
            throw new RuntimeException();
        }
        this.companyName = nome;
        this.cnpj = cnpj;
    }


}
