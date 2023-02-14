package entities;

import exception.BusinessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientePessoaFisica implements Clientes {

    private String nome;
    private String cpf;

    private List<Clientes> pessoaFisica = new ArrayList<>();

    public ClientePessoaFisica(List<Clientes> clientes, String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getId() {
        return this.cpf;
    }

    // Método para verificar se já existe um cliente cadastrado.
    @Override
    public boolean verificar(List<Clientes> pessoaFisica, String iD) {
        if (!pessoaFisica.isEmpty()) {
            for (Clientes clientes : pessoaFisica) {
                if (Objects.equals(clientes.getId(), cpf)) {
                    throw new BusinessException("ERRO: ESSE CLIENTE JÁ POSSUI CADASTRO. TENTE NOVAMENTE");
                }
            }
        }
        return false;
    }

    // Método para alterar/editar o cadastro do cliente Pessoa Física.
    @Override
    public void editar(List<Clientes> pessoaFisica, String nome, String cpf) {
        if(verificar(pessoaFisica, cpf)) {
            throw new BusinessException("Erro ao alterar os dados");
        }
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Clientes> getPessoaFisica() {
        return pessoaFisica;
    }

    @Override
    public String toString() {
        return "Cliente: Pessoa Física\n"
                + "nome: " + nome
                + "CPF: " + cpf;
    }

}
