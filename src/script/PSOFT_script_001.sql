-- Ser executado somente se não tiver sido criado o usuario 'postgres' 
CREATE USER postgres WITH PASSWORD 'postgres';
--

-- Ser executado somente se já tiver sido criado o usuario 'postgres' 
ALTER USER postgres WITH PASSWORD 'postgres';
--

-- criacao da DATABASE necessária para a aplicação
CREATE DATABASE "trabalhoPSOFT"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

-- criacao tabela de versionamento
CREATE TABLE db_version
(
	id SERIAL NOT NULL,
	numeracao INTEGER NOT NULL,
	CONSTRAINT PK_db_version PRIMARY KEY(id)
);

-- criacao tabela gerente
CREATE TABLE gerente
(
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,
    codigo INTEGER NOT NULL,
    senha VARCHAR(50) NOT NULL,
    ativo BIT NOT NULL,
    CONSTRAINT PK_gerente PRIMARY KEY (id)
);

-- criacao tabela vendedor
CREATE TABLE vendedor
(
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,
    codigo INTEGER NOT NULL,
    senha VARCHAR(50) NOT NULL,
    ativo BIT NOT NULL,
    CONSTRAINT PK_vendedor PRIMARY KEY (id)
);

-- criacao tabela cliente
CREATE TABLE cliente 
(
	id SERIAL NOT NULL,
    nome VARCHAR(50),
	cpf INTEGER NOT NULL,
	email VARCHAR(50) NOT NULL,
	endereco VARCHAR(50) NULL,
	identidade VARCHAR(50) NOT NULL,
	preferencial BIT NOT NULL,
	pontos INTEGER NULL,
	CONSTRAINT PK_cliente PRIMARY KEY (id)
);

-- criacao tabela produto
CREATE TABLE produto
(
    id SERIAL NOT NULL,
    nome VARCHAR(50) NOT NULL,
    codigo_identificacao INTEGER NOT NULL,
    codigo_barras VARCHAR(50) NOT NULL,
    quantidade_estoque INTEGER NULL,
    preco DECIMAL,
    CONSTRAINT PK_produto PRIMARY KEY (id)
);

-- criacao tabela promocao
CREATE TABLE promocao 
(
	id SERIAL NOT NULL,
	id_produto INTEGER NOT NULL,
	data_inicial DATE NOT NULL,
	data_final DATE NULL,
	CONSTRAINT PK_promocao PRIMARY KEY (id),
	CONSTRAINT FK_promocao_X_produto FOREIGN KEY (id_produto) REFERENCES produto(id)
);

-- criacao tabela reclamacao
CREATE TABLE reclamacao
(
    id SERIAL NOT NULL,
    id_cliente INTEGER NOT NULL,
    comentario VARCHAR(100) NOT NULL,
    data DATE NOT NULL,
    CONSTRAINT PK_reclamacao PRIMARY KEY (id)
);

-- criacao tabela nota_fiscal
create table nota_fiscal 
(
    id SERIAL NOT NULL,
    codigo INTEGER NOT NULL,
    CONSTRAINT PK_nota_fiscal PRIMARY KEY (id)
);

-- criacao tabela tipo_pagamento
create table tipo_pagamento
(
    id SERIAL NOT NULL,
    metodo VARCHAR(50) NOT NULL,
    CONSTRAINT PK_tipo_pagamento PRIMARY KEY (id)
);

-- criacao tabela venda
CREATE TABLE venda 
(
	id SERIAL NOT NULL,
	id_cliente INTEGER NOT NULL,
	id_vendedor INTEGER NOT NULL,
	id_tipo_pagamento INTEGER NOT NULL,
	data_final DATE NULL,
	status VARCHAR(50) NULL,
	CONSTRAINT PK_venda PRIMARY KEY (id),
	CONSTRAINT FK_venda_X_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id),
	CONSTRAINT FK_venda_X_vendedor FOREIGN KEY (id_vendedor) REFERENCES vendedor(id),
	CONSTRAINT FK_venda_X_tipo_pagamento FOREIGN KEY (id_tipo_pagamento) REFERENCES tipo_pagamento(id)
);

-- criacao tabela item
CREATE TABLE item
(
    id SERIAL NOT NULL,
    id_produto INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    CONSTRAINT FK_item_X_produto FOREIGN KEY (id_produto) REFERENCES produto(id),
    CONSTRAINT PK_item PRIMARY KEY (id)
);

-- criacao tabela conversao pontuacao
CREATE TABLE conv_pontuacao
(
    id SERIAL NOT NULL,
    valor_dinheiro DECIMAL NOT NULL,
    valor_pontos DECIMAL NOT NULL,
    percentual_desconto DECIMAL NOT NULL,
    CONSTRAINT PK_conv_pontuacao PRIMARY KEY (id)
);

-- criacao tabela troca
CREATE TABLE troca
(
    id SERIAL NOT NULL,
    id_venda INTEGER NOT NULL,
    data DATE NOT NULL,
    CONSTRAINT PK_troca PRIMARY KEY (id)
);

-- criacao tabela troca_item
CREATE TABLE troca_item
(
    id_troca INTEGER NOT NULL,
    id_item INTEGER NOT NULL,
    CONSTRAINT FK_troca_X_item FOREIGN KEY (id_troca) REFERENCES cliente(id),
	CONSTRAINT FK_item_X_troca FOREIGN KEY (id_item) REFERENCES item(id)
);

-- criacao tabela fornecedor
CREATE TABLE fornecedor
(
    id serial NOT NULL,
    nome VARCHAR(50) NOT NULL,
    endereco VARCHAR (50) NOT NULL,
    CONSTRAINT PK_fornecedor PRIMARY KEY (id)
);

-- criacao tabela item_venda
CREATE TABLE item_venda
(
    id_venda INTEGER NOT NULL,
    id_item INTEGER NOT NULL,
    CONSTRAINT FK_venda_X_item FOREIGN KEY (id_venda) REFERENCES venda(id),
	CONSTRAINT FK_item_X_venda FOREIGN KEY (id_item) REFERENCES item(id)
);

-- criacao tabela troca_nota
CREATE TABLE troca_nota
(
    id_troca INTEGER NOT NULL,
    id_nota INTEGER NOT NULL,
    CONSTRAINT FK_troca_X_nota FOREIGN KEY (id_troca) REFERENCES troca(id),
    CONSTRAINT FK_nota_X_troca FOREIGN KEY (id_nota) REFERENCES nota_fiscal(id)
);

-- criacao tabela produto_fornecedor
CREATE TABLE produto_fornecedor
(
    id SERIAL NOT NULL,
    id_produto INTEGER NOT NULL,
    id_fornecedor INTEGER NOT NULL,
    valor DECIMAL NOT NULL,
    CONSTRAINT PK_produto_fornecedor PRIMARY KEY (id),
    CONSTRAINT FK_produto_X_fornecedor FOREIGN KEY (id_produto) REFERENCES produto(id),
    CONSTRAINT FK_fornecedor_X_produto FOREIGN KEY (id_fornecedor) REFERENCES fornecedor(id)
);

-- criacao tabela venda_nota
CREATE TABLE venda_nota
(
    id_venda INTEGER NOT NULL,
    id_nota INTEGER NOT NULL,
    CONSTRAINT fk_venda_X_venda FOREIGN KEY (id_venda) REFERENCES venda (id),
    CONSTRAINT fk_nota_X_venda FOREIGN KEY (id_nota) REFERENCES nota_fiscal (id)
);

-- insert na tabela de versionamento
INSERT INTO db_version(numeracao) VALUES (1);
