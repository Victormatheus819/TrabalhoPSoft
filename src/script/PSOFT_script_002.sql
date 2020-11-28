-- drop table item_venda
DROP TABLE item_venda;

-- alteração tabela item
ALTER TABLE item
	ADD id_venda INTEGER NOT NULL,
	ADD CONSTRAINT FK_item_X_venda FOREIGN KEY (id_venda) REFERENCES venda(id);


-- insert na tabela de versionamento
INSERT INTO db_version(numeracao) VALUES (2);