# parceiros-petz-api
API Rest usando Java 8 e Spring Boot.

# Como executar a aplicação

Certifique se de ter baixado parceiros petz api

Acesse através do console
CMD ou GitBash

cd parceiros petz api

Execute o comando

./mvnw spring boot:run

API será executada em:

http://localhost:8080

Para Testar pode usar o Firefox Mozzila

http://localhost:8080/parceiros

http://localhost:8080/clientes

http://localhost:8080/categorias

http://localhost:8080/pedidos
# SWAGGER
Com a aplicação em execução acessar:
http://localhost:8080/swagger-ui.html

Collection
na raiz do projeto

# Banco de dados utilizado
# H2 DataBase 
para consultar as tabelas

acesse:
http://localhost:8080/h2-console

spring.datasource.url = jdbc:h2:mem:parceirosdb

UserName : sa
Password:
