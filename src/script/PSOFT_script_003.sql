-- ALTERAR TABELA GERENTE --
ALTER TABLE IF EXISTS gerente
	DROP COLUMN IF EXISTS codigo,
	ADD codigo VARCHAR(50) NOT NULL,
	DROP COLUMN IF EXISTS ativo,
	ADD ativo BOOLEAN NOT NULL;

-- ALTERAR TABELA VENDEDOR --
ALTER TABLE IF EXISTS vendedor
	DROP COLUMN IF EXISTS codigo,
	ADD codigo VARCHAR(50) NOT NULL,
	DROP COLUMN IF EXISTS ativo,
	ADD ativo BOOLEAN NOT NULL;

-- ALTERAR TABELA PRODUTO --
ALTER TABLE IF EXISTS produto
	DROP COLUMN IF EXISTS codigo_identificacao,
	ADD codigo_identificacao VARCHAR(50) NOT NULL;

-- ALTERAR TABELA promocao --
ALTER TABLE IF EXISTS nota_fiscal
	DROP COLUMN IF EXISTS codigo,
	ADD codigo VARCHAR(50) NOT NULL;

-- ajuste table cliente
ALTER TABLE cliente
	DROP COLUMN cpf,
	DROP COLUMN preferencial;
ALTER TABLE cliente
	ADD cpf VARCHAR(50);

-- insert na tabela de versionamento
INSERT INTO db_version(numeracao) VALUES (3);

-- ajuste constraint troca_item
ALTER TABLE troca_item
    DROP CONSTRAINT FK_troca_X_item;

ALTER TABLE troca_item 
    ADD CONSTRAINT FK_troca_X_item FOREIGN KEY (id_troca) REFERENCES troca(id);
