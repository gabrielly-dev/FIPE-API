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
            var tipoVeiculo = scanner.nextLine().toLowerCase();
            String endereco;

            // Construindo o endpoint base
            if (tipoVeiculo.contains("car")) {
                endereco = ENDERECO + "carros/marcas";
            } else if (tipoVeiculo.contains("mot")) {
                endereco = ENDERECO + "motos/marcas";
            } else {
                endereco = ENDERECO + "caminhoes/marcas";
            }

            // Obtendo marcas
            var json = consumoAPI.obterDados(endereco);
            if (json == null || json.isEmpty()) {
                System.out.println("Erro ao consultar marcas. Verifique sua conexão.");
                return;
            }

            var marcas = conversor.obterLista(json, Dados.class);
            if (marcas == null || marcas.isEmpty()) {
                System.out.println("Nenhuma marca encontrada para este tipo de veículo.");
                return;
            }

            marcas.stream()
                    .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);

            System.out.println("Informe o código da marca para consulta: ");
            var codigoMarca = scanner.nextLine();

            // Construindo URL para modelos
            endereco = ENDERECO + "carros/marcas/" + codigoMarca + "/modelos";
            json = consumoAPI.obterDados(endereco);

            var modeloLista = conversor.obterDados(json, Modelos.class);
            if (modeloLista == null || modeloLista.modelos() == null || modeloLista.modelos().isEmpty()) {
                System.out.println("Nenhum modelo encontrado para esta marca.");
                return;
            }

            modeloLista.modelos().stream()
                    .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);

            System.out.println("\nDigite um trecho do nome do carro a ser buscado: ");
            var nomeVeiculo = scanner.nextLine();

            // Filtrando modelos
            var modelosFiltrados = modeloLista.modelos().stream()
                    .filter(modelo -> modelo.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                    .collect(Collectors.toList());

            if (modelosFiltrados.isEmpty()) {
                System.out.println("Nenhum modelo encontrado com o nome informado.");
                return;
            }

            modelosFiltrados.forEach(System.out::println);

            System.out.println("Digite o código do modelo para consulta:");
            var codigoModelo = scanner.nextLine();

            // Construindo URL para anos
            endereco = ENDERECO + "carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos";
            json = consumoAPI.obterDados(endereco);

            var anos = conversor.obterLista(json, Dados.class);
            if (anos == null || anos.isEmpty()) {
                System.out.println("Nenhum ano disponível para o modelo selecionado.");
                return;
            }

            List<Veiculo> veiculos = new ArrayList<>();
            for (var ano : anos) {
                var enderecoAnos = endereco + "/" + ano.codigo();
                json = consumoAPI.obterDados(enderecoAnos);
                Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
                if (veiculo != null) {
                    veiculos.add(veiculo);
                }
            }

            if (veiculos.isEmpty()) {
                System.out.println("Nenhum veículo encontrado.");
                return;
            }

            System.out.println("\nTodos os veículos filtrados com avaliações por ano:");
            veiculos.forEach(System.out::println);
        }
    }
