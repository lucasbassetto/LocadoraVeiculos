package entities;

import java.util.List;

public interface Clientes {

    public String getNome();

    public String getId();

    boolean verificar(List<Clientes> cliente, String id);
    public void editar(List<Clientes> cliente, String nome, String id);

}
