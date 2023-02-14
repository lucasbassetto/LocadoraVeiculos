import entities.ClientePessoaFisica;
import entities.ClientePessoaJuridica;
import entities.Clientes;
import entities.Veiculos;
import enums.TipoVeiculo;
import service.AluguelVeiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Veiculos> veiculos = new ArrayList<>();
        List<Clientes> clientes = new ArrayList<>();

        veiculos.add(new Veiculos(veiculos,"ACB-123", "CIVIC", TipoVeiculo.MEDIO));
        veiculos.add(new Veiculos(veiculos,"BCA-123", "GOL", TipoVeiculo.PEQUENO));
        veiculos.add(new Veiculos(veiculos,"CAB-123", "EVOQUE", TipoVeiculo.SUV));

        clientes.add(new ClientePessoaFisica(clientes,"Lucas", "123456"));
        clientes.add(new ClientePessoaJuridica("009201", "JAGUAR LTDA"));
        clientes.add(new ClientePessoaFisica(clientes,"Marina", "12211221"));
        clientes.add(new ClientePessoaFisica(clientes,"Marina", "12211221"));


        List<AluguelVeiculo> aluguelVeiculos = new ArrayList<>();
        LocalDateTime retirada =  LocalDateTime.of(2023, 1, 29, 14, 30, 00);
        LocalDateTime devolucao1 = LocalDateTime.of(2023, 2, 1, 12, 22, 00);
        LocalDateTime devolucao2 = LocalDateTime.of(2023, 2, 8, 11, 15, 00);

        aluguelVeiculos.add(new AluguelVeiculo(veiculos.get(0), clientes.get(0), retirada, devolucao1));
        aluguelVeiculos.add(new AluguelVeiculo(veiculos.get(2), clientes.get(2), retirada, devolucao1));
        aluguelVeiculos.add(new AluguelVeiculo(veiculos.get(1), clientes.get(1), retirada, devolucao2));

        for(AluguelVeiculo aluguel: aluguelVeiculos){
            System.out.println(aluguel.toString());
        }

    }
}