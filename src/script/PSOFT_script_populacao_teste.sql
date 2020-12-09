-- Gerente: codigo = 123; senha = 123
INSERT INTO gerente (nome, senha, codigo, ativo) VALUES ('Gerente_Teste','123','123', true);

-- Vendedor: codigo = 123; senha = 123
INSERT INTO vendedor (nome, senha, codigo, ativo) VALUES ('Vendedor_Teste','123','123', true);

-- Cliente: CPF = 123
INSERT INTO cliente (nome, email, endereco, identidade, pontos, cpf, preferencial) VALUES ('Cliente_Teste', 'teste@teste.com', 'Rua de teste, n 0', '123', 324, '123', true);

-- Produto: codigoBarras = 123
INSERT INTO produto (nome, codigo_barras, quantidade_estoque, preco, codigo_identificacao) VALUES ('Produtinho', '123', 149, 38, 'codigo para fornecedor');

-- Promocao: Para o produto criado acima
INSERT INTO promocao (id_produto, data_inicial, data_final, porcentagem_desconto) VALUES (1,'2020-09-28','2021-01-25',10);

-- Tipos pagamentos
INSERT INTO tipo_pagamento (metodo) VALUES ('Cartão de Débito');
INSERT INTO tipo_pagamento (metodo) VALUES ('Cartão de Crédito');
INSERT INTO tipo_pagamento (metodo) VALUES ('Dinheiro');