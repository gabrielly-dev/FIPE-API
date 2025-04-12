# 🚗 Projeto Veículo API - Consulta Tabela FIPE

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=java)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.0-green?logo=spring)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

🔍 Uma API Java para consulta de veículos na Tabela FIPE, desenvolvida como parte do curso da Alura.

## 📌 Índice
- [Visão Geral](#-visão-geral)
- [✨ Funcionalidades](#-funcionalidades)
- [🚀 Como Usar](#-como-usar)
  - [Pré-requisitos](#pré-requisitos)
  - [Instalação](#instalação)
- [🔧 Tecnologias](#-tecnologias)
- [📚 Exemplos](#-exemplos)
- [🤝 Contribuição](#-contribuição)

## 🌟 Visão Geral
Este projeto permite consultar informações completas sobre veículos (carros, motos e caminhões) através da API pública da Tabela FIPE. Desenvolvido em Java com Spring Boot, oferece uma interface simples para acesso a dados como marcas, modelos, anos e valores de veículos.

## ✨ Funcionalidades

### 🔹 Consulta Completa de Veículos
- Listagem de todas as categorias disponíveis (carros, motos, caminhões)
- Busca de marcas por categoria
- Filtro de modelos por trecho do nome
- Detalhamento completo do veículo selecionado

### 📊 Dados Retornados
| Campo          | Descrição                          |
|----------------|-----------------------------------|
| Valor          | Preço médio do veículo            |
| Marca          | Fabricante do veículo             |
| Modelo         | Nome do modelo                    |
| Ano            | Ano de fabricação/modelo          |
| Combustível    | Tipo de combustível               |
| Código FIPE    | Código único na tabela FIPE       |

## 🚀 Como Usar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+
- Conexão com internet

### Instalação
1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/projeto-veiculo-api.git
```

2. Acesse o diretório:
```bash
cd projeto-veiculo-api/veiculo
```

3. Execute o projeto:
```bash
mvn spring-boot:run
```

## 🔧 Tecnologias
- **Java 17** - Linguagem principal
- **Spring Boot** - Framework backend
- **Jackson** - Processamento de JSON
- **Maven** - Gerenciamento de dependências
- **HTTP Client** - Comunicação com API FIPE

## 📚 Exemplos

### Fluxo de Consulta
1. Selecione o tipo de veículo:
```
1 - Carros
2 - Motos
3 - Caminhões
```

2. Escolha uma marca:
```
1 - Volkswagen
2 - Fiat
3 - Chevrolet
...
```

3. Filtre modelos:
```
Digite um trecho para filtrar: golf
```

4. Veja os resultados:
```
Modelo: Golf 1.6
Valor: R$ 45.290,00
Ano: 2020
Combustível: Gasolina
```

## 🤝 Contribuição
Contribuições são bem-vindas! Siga estes passos:
1. Faça um fork do projeto
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.
