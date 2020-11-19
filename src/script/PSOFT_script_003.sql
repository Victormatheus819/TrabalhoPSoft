-- drop table cliente
ALTER TABLE cliente
	DROP COLUMN cliente;

ALTER TABLE cliente
	ADD cpf  VARCHAR(50);
