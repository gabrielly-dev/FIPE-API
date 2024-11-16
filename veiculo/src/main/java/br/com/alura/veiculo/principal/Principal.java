package br.com.alura.veiculo.principal;

import br.com.alura.veiculo.modelo.Dados;
import br.com.alura.veiculo.modelo.Modelos;
import br.com.alura.veiculo.modelo.Veiculo;
import br.com.alura.veiculo.servicos.ConsumoAPI;
import br.com.alura.veiculo.servicos.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        System.out.println("\nDigite um trecho do nome do carro a ser buscado: ");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(modeloVeiculo -> modeloVeiculo.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo para consulta:");
        var codigoModelo = scanner.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumoAPI.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);

        List<Veiculo> veiculos = new ArrayList<>();

        for(int i = 0; i < anos.size(); i++){
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumoAPI.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);
    }
}
