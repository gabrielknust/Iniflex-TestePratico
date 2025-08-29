# Teste prático Iniflex

## Descrição

Esse projeto foi desenvolvido como teste prático com foco na linguagem Java.

Nele foram desenvolvidas 4 Classes. A classe Pessoa é uma classe abstrata e serve como base para a classe Funcionário,
que por sua vez representa as informações de um funcionário (nome e data de nascimento herdados de Pessoa e salário e função como atributos pessoais). A classe FuncionarioService serve para declarar funções que auxiliam 
na execução dos requisitos propostos no desafio e a classe Principal é o corpo principal do desafio onde as outras classes são instanciadas e os requisitos são cumpridos.

As classes de domínio (Pessoa e Funcionario) estão na pasta src/main/java/model e a classe com a lógica de negócio (FuncionarioService) está na pasta src/main/java/service.


## Pré-requisitos
Antes de executar é importante garantir que o JDK (Java Development Kit) 11 ou superior está instalado corretamente na sua máquina.

## Como executar

### Via IDE

1. Clone o repositório.
2. Abra o projeto na sua IDE preferida.
3. Localize e execute o arquivo src/main/java/Principal.java

### Via Linha de Comando

1. Clone o repositório.
2. Navegue até a pasta do projeto.
3. Compile os arquivos .java para uma pasta de saída (exemplo: bin)
   ```bash
     javac -d bin src/main/java/model/*.java src/main/java/service/*.java src/main/java/*.java
   ```
4. Execute a classe principal:
   ```bash
      java -cp bin Principal
   ```
