package br.com.alura.veiculo.principal;

import br.com.alura.veiculo.modelo.Dados;
import br.com.alura.veiculo.modelo.Modelos;
import br.com.alura.veiculo.servicos.ConsumoAPI;
import br.com.alura.veiculo.servicos.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void menu() {
        System.out.println("Digite o tipo de veículo que está procurando como carro, moto ou caminhão.");
        var tipoVeiculo = scanner.nextLine();
        String endereco;

        if (tipoVeiculo.toLowerCase().contains("car")) {
            endereco = ENDERECO + "carros/marcas/";
        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = ENDERECO + "motos/marcas/";
        } else {
            endereco = ENDERECO + "caminhoes/marcas";
        }

        var json = consumoAPI.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumoAPI.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);
        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

    }
}
