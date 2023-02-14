package entities;

import enums.TipoVeiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Veiculos implements Veiculo {

    private final String placa;
    private final String modelo;
    private final TipoVeiculo tipo;
    private boolean alugado;

    private List<Veiculo> list = new ArrayList<>();

    public Veiculos(List<Veiculos> veiculos, String placa, String modelo, TipoVeiculo tipo) {

        for (Veiculo v : list) {
            if (Objects.equals(v.getPlaca(), placa)) {
                throw new RuntimeException("A placa" + placa + " já está cadastrada no sistema.");
            }
        }
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.alugado = false;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public String getModelo() {
        return modelo;
    }


    @Override
    public TipoVeiculo getTipo() {
        return tipo;
    }

    @Override
    public boolean isAlugado() {
        return alugado;
    }

    @Override
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    @Override
    public double getValorDiaria() {

        if (this.tipo == TipoVeiculo.PEQUENO) {
            return 100d;
        }
        else if (this.tipo == TipoVeiculo.MEDIO) {
            return 150d;
        } else
        return 200d;
    }

    public List<Veiculo> getListaVeiculos() {
        return list;
    }

    private boolean carroExiste(List<Veiculo> listaVeiculos, String placa) {
        if (!listaVeiculos.isEmpty()) {
            for (Veiculo veiculo : listaVeiculos) {
                if (veiculo.getPlaca() == placa) {
                    return true;
                }
            }
        }
        return false;
    }
}
