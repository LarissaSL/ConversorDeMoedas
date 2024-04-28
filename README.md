# Conversor de Moedas = Challenger Oracle ONE (JAVA)

Este sistema tem como objetivo consumir a API ExchangeRate para converter valores para outras moedas, utilizando os conhecimentos adquiridos em POO com Java, consumo de API´s e tratamento dos Json com a biblioteca Gson.

## Funcionalidades 🛠️

| Funcionalidade          | Descrição                                                                                       |
|-------------------------|-------------------------------------------------------------------------------------------------|
| Converter valores de uma Moeda de Origem a uma de Destino        | O usuário informa qual a moeda de origem e qual a moeda de destino, o sistema consome a API ExchangeRate e devolve o valor já convertido. |


## Tecnologias Utilizadas 🚀

- **ExchangeRateAPI**: API para conversão de valores gratuita

## Como Usar 📋

1. Faça o download do código-fonte do projeto.
2. Importe o projeto para a IDE de sua preferencia e execute a classe Main.

## Telas 📱
### Tela Inicial
<p>Permite que o usuário digite uma das Opções</p>
<img src="https://github.com/LarissaSL/ConversorDeMoedas/assets/112571317/6192f443-49db-4749-a363-dfc9f7c41508" width="400">

### Tela para configurações da conversão
<p>Exibe as opções de moedas disponiveis para selecionar a Moeda de Origem, valor a ser convertido e a Moeda de Destino</p>
<img src="https://github.com/LarissaSL/ConversorDeMoedas/assets/112571317/7cfea6d6-29e5-4a7c-afc0-3ad2bb118f20" width="400">

### Tela de Resultado
<p>Exibe o Resultado da Conversão</p>
<img src="https://github.com/LarissaSL/ConversorDeMoedas/assets/112571317/facd3fe0-76a9-4991-ad08-4fb6fe7ce6cf" width="400">

### Tela de Exibição de Histórico
<p>Exibe o Histórico de Conversão</p>
<img src="https://github.com/LarissaSL/ConversorDeMoedas/assets/112571317/b66bc4df-d640-49e2-b3a9-026edf481f5a" width="400">



## Desenvolvimento

| Desenvolvimento                           | Descrição                                                                                                                                                                            |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Preparando o Ambiente de Desenvolvimento | Criação da pasta Model, inserção do Gson no projeto e da classe Main |
| Criação das Classes  | Planejamento das classes a serem utilizadas, começando pela da API(Conversor), seguida do Menu e por fim Histórico |
| Consumo da API | Registro no Site da ExnchangeRate para obter a API Key e iniciando os métodos de requisição para consumo da API. |
| Criação do ToString | Criação da função para obter o Simbolo da Moeda de origem e de destino, para deixar o ToString mais agradavel ao usuário |
| Criação da Classe Menu | Desenvolvimento de todos os Métodos e Menus necessários para interação com o usuário |
| Testes | Testes para ver se a conversão estava dando certo e notando que precisaria de algo para repetir as opções caso o usuário fugisse das opções deixadas das moedas |
| Criação de um novo menu para selecionar as moedas | Criação da função `definirMoeda`, permitindo que o usuário erre as opções e não interrompa o funcionamento do programa |
| Criação da Classe Histórico | Utilizando FileReader e PrintWriter para escrever e ler, criando um histórico de conversão de moedas |

## 🎥 Materiais de Apoio Utilizados

Aqui estão alguns vídeos que utilizei como apoio durante o desenvolvimento:

- [Documentação Oficial da API ExchangeRate_API](https://www.exchangerate-api.com/docs/overview)
- [Trello](https://trello.com/b/KgclcHdi/conversor-de-moeda-challenge-one-java-back-end)


## Simulação 🎬

Aqui está uma simulação do aplicativo em funcionamento:

https://github.com/LarissaSL/ConversorDeMoedas/assets/112571317/9d9653e5-23c4-476b-82a6-3c6f544ed266


