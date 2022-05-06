INSERT INTO categorias VALUES (1,'Informatica'),(2,'Escritorio');
INSERT INTO produtos VALUES
(null,'Mouse normal','urlImage',50.0,'mouse',10,1),
(null,'Mesa de Computador','urlImage',500.0,'Mesa',20,2);

INSERT INTO clientes VALUES
(null,'Freguesia do O','02805050','Sao Paulo',
'fernandoguide2014@gmail.com','SP','Fernando Oliveira','Rua Emilio Monassa 188','123');
INSERT INTO PERFIS VALUES (1,1);

INSERT INTO PEDIDOS VALUES (null,current_timestamp,'escritorio','pendente',1);

INSERT INTO PEDIDO_ITENS VALUES (1,10.0,10.0,1,1);
