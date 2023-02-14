package service;

import entities.ClientePessoaFisica;
import entities.ClientePessoaJuridica;
import entities.Clientes;
import entities.Veiculo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AluguelVeiculo {

    private Veiculo veiculo;
    private Clientes cliente;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    public AluguelVeiculo(Veiculo veiculo, Clientes cliente, LocalDateTime dataAluguel, LocalDateTime dataDevolucao) {
        if (veiculo.isAlugado()) {
            throw new RuntimeException("O veículo já está alugado.;");
        }
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataRetirada = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        veiculo.setAlugado(true);

    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public LocalDateTime getDataAluguel() {
        return dataRetirada;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double calcularValorDiarias() {
        return veiculo.getValorDiaria() * calcularDias();
    }

    public Double calcularDias() {
        return Math.ceil((double) (ChronoUnit.SECONDS.between(dataRetirada, dataDevolucao) / 86400d));
    }

    public double calcularDesconto() {
        if (cliente instanceof ClientePessoaFisica) {
            if (calcularDias() > 5) {
                return calcularValorDiarias() * 0.05;
            }
        } else if (cliente instanceof ClientePessoaJuridica) {
            if (calcularDias() > 3) {
                return calcularValorDiarias() * 0.1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "\n" +
                "Aluguel:\n"
                + "Veiculo: " + veiculo.getModelo()
                + "\n"
                + "Cliente: " + cliente.getNome()
                + "\n"
                + "Data da retirada do veículo: " + dataRetirada
                + "\n"
                + "Data da devolução do veículo: " + dataDevolucao
                + "\n"
                + "Valor: " + calcularValorDiarias()
                + "\n"
                + "Valor desconto: " + calcularDesconto();
    }
}