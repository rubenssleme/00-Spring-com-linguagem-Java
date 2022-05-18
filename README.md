# Ecossistema-Spring-com-linguagem-Java
Este teste busca avaliar quesitos técnicos para as pessoas que se candidatem às vagas de desenvolvimento back-end possam o Ecossistema Spring: Framework, Spring Boot, Spring MVC, Spring Security, Springfox-Swagger e Spring Data.

API usando Java 1.8 ou 11 e Spring Boot.
### Como executar a aplicação
Certifique-se de ter instalado:
##### Pré-requisitos
* Java JDK 11
* Maven 3.3
* Docker ([Install](https://docs.docker.com/v17.09/engine/installation/linux/docker-ce/ubuntu/)  | [Configure](https://docs.docker.com/v17.09/engine/installation/linux/linux-postinstall/))

##### Pré-requisitos de desenvolvimento
* Configurar o SonarLint no IntelliJ IDEA [SonarLint website](https://www.sonarlint.org/intellij)
* Testes unitarios para UseCase e Resource
  * Como criar Testes

###### Comandos Maven
* Compilar project mvn compile
* Limpar diretorio Target mvn clean
* Executar testes do projeto mvn test
* Executar projeto mvn spring-boot:run
* Instalar pacotes mvn install

###### Sobre o Makefile
O objetivo de Makefile é definir regras de compilação para projetos de software. Tais regras são definidas em arquivo chamado Makefile.

O programa make interpreta o conteúdo do Makefile e executa as regras lá definidas.

* Comandos
    * Exibe as opções do menu: make help
    * Constrói o projeto, gera o container e inicia a aplicação: make up

##### Definicao de Testes
Utilizar Gherkin para descrever especificações de cenários de testes, baseado na regra de negocio.

* O padrão é descrito em forma de "steps":

  * Given: Utilizado para especificar uma pré condição, dentro desse step é feita a validação de uma condição antes de se prosseguir para os próximos passos.
  * When: Utilizado quando será executada uma ação de que se espera uma reação vinda do sistema, que será validada no step “Then”.
  * Then: Valida se o esperado aconteceu. Segue sempre um passo do tipo “Quando”, pois aqui é validada a reação da ação recebida.
  * And: Caso seja necessário mais uma interação com o sistema para complementar um fluxo, mas que não necessariamente se trata de uma ação ou reação, se utiliza “And”;
  * But: No geral serve a mesma funcionalidade do “And”, porém é normalmente utilizado após uma validação negativa depois do “Then”;
* Exemplo:
  * Scenário Alguma situação do negócio
  * Given uma pré condição
  * And outra pré condição
  * When uma ação realizada pelo ator
  * And outra ação
  * Then um resultado testável é alcançado
  * And outro resultado
    * Exemplo em JAVA: Cenario: Cliente especial com saldo negativo Given: um cliente especial com saldo atual de -200 reais When: for solicitado um saque no valor de 100 reais Then: deve efetuar o saque e atualizar o saldo da conta para -300 reais

* Implementação:

```
GIT
JAVA 1.8 ou superior
MAVEN 3.6.3 ou superior

```
```
git clone https://github.com/rubenssleme/Ecossistema-Spring-com-linguagem-Java

cd Ecossistema-Spring-com-linguagem-Java/Spring-boot-curso-nelio-alves-api

mvn spring-boot:run

API será executada em 

http://localhost:8080

```
```
# SWAGGER 

Com a aplicacao em execucao acessar: 
```
```
http://localhost:8080/swagger-ui.html

```
```
# Banco de dados utilizado
H2 DataBase

para consultar as tabelas acesse 

http://localhost:8080/h2-console
```
```
JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password:

```


