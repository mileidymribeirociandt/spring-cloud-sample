USE db_tshake_test;

CREATE TABLE pagamento(
    id INT PRIMARY KEY AUTO_INCREMENT,
    valor decimal(19,2) NOT NULL,
    nome varchar(100) DEFAULT NULL,
    numero varchar(19) DEFAULT NULL,
    expiracao varchar(7) DEFAULT NULL,
    codigo varchar(3) DEFAULT NULL,
    status varchar(10) NOT NULL,
    forma_de_pagamento varchar(16) NOT NULL,
    pedido_id INT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);SA