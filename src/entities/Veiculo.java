package entities;

import enums.TipoVeiculo;

public interface Veiculo {

    String getPlaca();

    String getModelo();

    TipoVeiculo getTipo();

    boolean isAlugado();

    void setAlugado(boolean alugado);

    double getValorDiaria();

}
