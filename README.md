# Automation-Exercise---Selenium-WebDriver
Este repositório contém um framework de automação de testes para o site Automation Exercise, 
desenvolvido com o objetivo de demonstrar práticas de engenharia de QA, padrão Page Object Model (POM) e Herança.

## Tecnologias Utilizadas
Java 17: Linguagem base para o desenvolvimento dos scripts.

Selenium WebDriver (v4.40.0): Ferramenta principal para interação com o navegador.

JUnit (v6.0.3): Framework de testes para execução e asserções.

WebDriverManager (v6.3.3): Gerenciamento automático de binários (ChromeDriver).

Maven 24: Gerenciamento de dependências e automação de builds.

## Arquitetura do Projeto
O projeto segue o padrão Page Object Model, focado na manutenibilidade e no reuso de código:

BasePage: Classe abstrata que centraliza o WebDriver e o WebDriverWait.

AutomationExercisePage: Mapeamento da home e página de produtos, incluindo lógica de busca e adição de item ao carrinho.

CartPage: Mapeamento e validação do item adicionado no carrinho de compras.

AddProductInCart: Classe de teste que orquestra o fluxo de negócio e realiza as asserções (Assertions).

## Desafios Técnicos & Soluções
Durante o desenvolvimento, foram aplicadas as seguintes soluções para problemas que surgiram:

Tratamento de Anúncios (Interstitials): Implementação de lógica de contorno para anúncios do Google Ads que interceptam 
o clique do usuário, garantindo a resiliência do teste.

Sincronização Dinâmica: Uso de WebDriverWait e ExpectedConditions para lidar com o carregamento assíncrono de elementos.

Simulação de Mouse para acionar o Hover: Uso da classe Actions para interagir com elementos que só se tornam visíveis ao passar o mouse.

Validação de Contexto: Estruturação dos testes para garantir que as interações ocorram apenas quando o navegador 
estiver na página correta, evitando erros de TimeoutException.

## Melhoria de Usabilidade Identificada para o Site:
O campo de busca não permite enviar o texto ao apertar a tecla "Enter" do teclado, sendo necessário realizar o click no botão de enviar.
