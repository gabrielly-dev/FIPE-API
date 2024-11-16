# Projeto Veículo API

Este é um projeto desenvolvido para consultar informações sobre veículos, utilizando a API pública **Tabela FIPE**. Ele permite obter dados como marcas, modelos, anos e valores de veículos (carros, motos e caminhões).
## Índice

- [Projeto Veículo API](#projeto-veículo-api)
- [Como funciona?](#como-funciona)
- [Instalação e uso](#instalação-e-uso)
  - [Pré-requisitos](#pré-requisitos)
  - [Passo a passo](#passo-a-passo)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Licença](#licença)
## Como Funciona

O projeto conecta-se à API **[Tabela Fipe](https://parallelum.com.br/fipe/api/v1/)** para buscar informações de veículos de diferentes categorias. o fluxo do programa funciona da seguinte forma:

1. O usuário escolhe o tipo de veículo (carro, moto ou caminhão).
2. Em seguida decide qual a marca desejada.
3. Filtra os modelos com base em trechos do nome.
4. Por fim, obtém os anos disponíveis e os detalhes do veículo como valor, marca, modelo, ano e tipo de combustível, para que possa decidir qual a melhor opção.

Os dados são consumidos via requisições HTTP e exibidos de forma interativa no terminal.
## Instalação e uso

### Pré-requisitos

- **Java 17** ou superior
- **Maven** configurado no ambiente
- Conexão com a Internet

### Passo a Passo

1. Clone o repositório:
    ```bash
    git clone https://github.com/seu-usuario/projeto-veiculo-api.git

2. Entre no diretório do projeto:
    ```bash
    cd projeto-veiculo-api
3. Compile e execute o projeto:
    ```bash 
    mvn spring-boot:run
4. O programa será iniciado no terminal. Siga as instruções para interagir com o sistema.


## Tecnologias Utilizadas

- **Java** - Linguagem de programação principal
- **Spring Boot** - Para inicialização e estruturação do projeto
- **Maven** - Gerenciador de dependências e build
- **Jackson** - Biblioteca para conversão de JSON em objetos Java
- **API Tabela FIPE** - Fonte de dados para as consultas.
A estrutura inicial do projeto foi criada com o **Spring Initializr**.
## Funcionalidades

- Consulta de veículos por categoria (carros, motos, caminhões)
- Exibição das marcas e modelos disponíveis
- Filtragem de modelos por nome
- Listagem dos anos de fabricação e seus respectivos valores.
- Detalhadamento completo do veículo (valor, marca, modelo, ano, combustível)

## Licença
Este projeto é de uso livre. Sinta-se à vontade para clonar, modificar e contribuir!
