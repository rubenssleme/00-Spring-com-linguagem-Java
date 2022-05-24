# API do Hackathon
<p align="center">
  <img src="https://img.shields.io/static/v1?label=Spring&message=framework&color=green&style=flat-square&logo=spring"/>
  <img src="https://img.shields.io/static/v1?label=Azure&message=deploy&color=blue&style=flat-square&logo=azure-devops"/>
  <img src="http://img.shields.io/static/v1?label=Java&message=11&color=red&style=flat-square&logo=java"/>
  <img src="http://img.shields.io/static/v1?label=SQL&message=Server&color=greer&style=flat-square&logo=SQL-Server"/>
</p>
 <img src="http://img.shields.io/static/v1?label=Status%20do%20projeto&message=EM%20DESENVOLVIMENTO&color=yellow&style=flat-square"/>

## Descrição do projeto
>TODO: Guide users through getting your code up and running on their own system. In this section you can talk about:


## Funcionalidades

## Deploy da Aplicação :dash:
> TODO
## Pré-requisitos
> Para iniciar o projeto, você precisará instalar as seguintes ferramentas em sua máquina: <br>
> [**_Java:_**](https://www.java.com/pt-BR/download/help/ie_online_install.html#download) <br>
> [**_Maven_:**](https://maven.apache.org/download.cgi) <br>
> [**_IntelliJ:_**](https://www.jetbrains.com/pt-br/idea/download/#section=windows) - Sugestão de IDE. <br>

## Como rodar a aplicação :arrow_forward:

1. No terminal, clone o projeto:
```
git clone https://tfs.avaliacao.com.br/IDT/ITC/_git/api-hackathon
```
2. Em seguida conecte-se a VPN Azure da Iteris. Se é o seu primeiro acesso a VPN,
entre no [Link: VPN Azure da Iteris](https://extranet.iteris.com.br/corporativo/npp/Pages/Conex%C3%A3o%20VPN%20Azure.aspx)
e siga o passo a passo para configuração e conexão.


3. Após conectar-se na VPN (passo 2), abra o **DBeaver** para que possa ser feita a configuração e conexão com o banco de dados (Iniciando/Configurando banco de dados)


4. Para rodar aplicação e subir a API, no browser digite a url:

```
http://localhost:8080/swagger-ui.html#
```
5. Você poderá acessar os endpoints da API com o **[Swagger Editor](https://editor.swagger.io/)**.


<b>Importante!:</b> Não se esqueça de confirmar se o servidor local está na **porta 8080**.
## Como rodar os testes

Para executar os testes digite o comando:

```
mvn test
```
Para vizualizar a cobertura de testes na aplicação, após executar o comando acima, na pasta target,
será gerado um aquivo com o nome jacoco.exec. É nesse aquivo que podemos visualizar a cobertura de
testes. Se estiver a usar a IDE IntelliJ, basta ir até no menu superior depois em **"Run"** e
em seguida **"Show Coverage Data"**, basta selecionar o arquivo jacoco.exec e será possível
visualizar a cobertura de testes.


## Iniciando/Configurando banco de dados

1. Abra o DBeaver

2. No menu principal clique em "File" e depois em "New"

3. Irá abrir uma nova janela, clique em "DBeaver" e depois em "Database Connection"

4. Uma nova janela irá abrir, clique em "SQL Server"

5. Irá abrir uma nova janela com as informações de conexão

6. No campo "_Host_" digite: **iterisdev.database.windows.net**

7. No campo "_Database/Schema_" digite: **TimeSheetDev**

8. No campo "_User name_" digite: **timesheetdev**

9. No campo "_Password_" digite: **Timesheet@2018**


**_Observações:_**

- As informações de host, schema, login e senha para acesso ao banco de dados, encontram-se no arquivo
_application.properties_ (src/main/resources/application.properties)
- Verifique sua conexão com a VPN da Iteris (Como rodar a aplicação)




## Linguagens, dependencias, business tools e libs utilizadas :books:


<code><img height="32" src="https://cdn.iconscout.com/icon/free/png-512/java-60-1174953.png" alt="Java"/></code>
<code><img height="32" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/sql/sql.png" alt="slq"/></code>
<code><img height="32" src="https://user-images.githubusercontent.com/2676579/34940598-17cc20f0-f9be-11e7-8c6d-f0190d502d64.png" alt="Postman"/></code>
<code><img height="32" src="https://dashboard.snapcraft.io/site_media/appmedia/2018/04/twitter-card-icon.png" alt="Insomnia"/></code>
<code><img height="32" src="https://raw.githubusercontent.com/github/explore/80688e429a7d4ef2fca1e82350fe8e3517d3494d/topics/git/git.png" alt="Git"/></code>
<code><img height="32" src="https://cdn.worldvectorlogo.com/logos/azure-boards.svg" alt="Azure Board"/></code>

### dependências Java:

<img src="http://img.shields.io/static/v1?label=Java&message=11&color=red&style=flat-square&logo=java"/>
<img src="https://img.shields.io/static/v1?label=Spring&message=framework&color=red&style=flat-square&logo=spring"/> <br><br>
<img src="https://img.shields.io/static/v1?label=H2&message=Database&color=yellow&style=flat-square&logo=h2"/>
<img src="https://img.shields.io/static/v1?label=SQLServer&message=Database&color=red&style=flat-square&logo="/> <br><br>
<img src="https://img.shields.io/static/v1?label=Lombok&message=dependency&color=green&style=flat-square&logo="/>
<img src="https://img.shields.io/static/v1?label=Swagger&message=dependency&color=green&style=flat-square&logo=swagger"/>
<img src="https://img.shields.io/static/v1?label=MapStruct&message=dependency&color=green&style=flat-square&logo="/>
<img src="https://img.shields.io/static/v1?label=JUnit&message=dependency&color=green&style=flat-square&logo=junit"/>
<img src="https://img.shields.io/static/v1?label=Cucumber&message=dependency&color=green&style=flat-square&logo=cucumber"/>
<img src="https://img.shields.io/static/v1?label=SonarQube&message=dependency&color=green&style=flat-square&logo=sonarqube"/> <br> <br>
<img src="https://img.shields.io/static/v1?label=Swagger&message=API Documentation&color=green&style=flat-square&logo=swagger"/> <br>

> Este projeto utiliza o swagger 2 como principal forma de documentação de API.
Para acessa-lo, execute o projeto e acesse a URL:
http://localhost:8080/swagger-ui.html, ou se preferir, [clique](<a href="http://localhost:8080/swagger-ui.html">aqui.</a>)

## Resolvendo Problemas :exclamation:

> TODO

## Tarefas em aberto

>TODO
## Desenvolvedores/Contribuintes (Mai/2022 - Dez/2022) :smiley:

# Contribute
>TODO:
