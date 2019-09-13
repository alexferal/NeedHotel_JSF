CREATE TABLE usuario(
	cpf VARCHAR(14),
	nome VARCHAR(50) NOT NULL ,
	sobreNome VARCHAR(200) NOT NULL ,
	telefone VARCHAR(20) NOT NULL ,
	dataNascimento DATE NOT NULL ,
	email VARCHAR(200) UNIQUE,
	senha VARCHAR(50) NOT NULL ,
	foto VARCHAR(50),
    CONSTRAINT cpf_pk PRIMARY KEY(cpf)
);

INSERT INTO usuario(cpf, nome, sobreNome, telefone, dataNascimento, email, senha, foto)
VALUES ('111.111.111-11', 'Tester', 'Padrão', '(83)99633-8557', '1999-09-09', 'teste@teste.com', '1234', 'teste.jpg');

CREATE TABLE imovel(
    id VARCHAR(100),
    proprietario VARCHAR(14),
    nome VARCHAR(200),
    rua VARCHAR(200),
    bairro VARCHAR(100),
    numero VARCHAR(10),
    cep VARCHAR(9),
    cidade VARCHAR(100),
    estado VARCHAR(100),
    valor FLOAT,
    disponibilidade BOOLEAN,
    foto VARCHAR(200),
    descricao VARCHAR(500),
    CONSTRAINT id_pk PRIMARY KEY(id),
    CONSTRAINT proprietario_fk FOREIGN KEY(proprietario)
        REFERENCES usuario(cpf)
);

CREATE TABLE comodidade(
    id_imovel VARCHAR(100),
    recurso VARCHAR(200),
    CONSTRAINT comodidade_pk PRIMARY KEY(id_imovel, recurso),
    CONSTRAINT id_fk FOREIGN KEY(id_imovel)
        REFERENCES imovel(id)

);

CREATE TABLE foto(
   id_imovel VARCHAR(100),
   foto VARCHAR(100),
   CONSTRAINT foto_pk PRIMARY KEY(id_imovel, foto),
   CONSTRAINT id_fk FOREIGN KEY(id_imovel)
       REFERENCES imovel(id)

);

CREATE TABLE cartao(
	numero VARCHAR(20),
	titular VARCHAR(100),
	cvv VARCHAR(3),
	datavalidade VARCHAR(5),
	CONSTRAINT numerocartao_pk PRIMARY KEY(numero)
);

CREATE TABLE pagamento(
	codigo VARCHAR(20),
	datapagamento DATE,
	cartao VARCHAR(20),
	CONSTRAINT codigopagamento_pk PRIMARY KEY(codigo),
    CONSTRAINT cartao_fk FOREIGN KEY(cartao)
        REFERENCES cartao(numero)
);

CREATE TABLE reserva(
	codigo VARCHAR(20),
	checkin DATE,
	checkout DATE,
	usuario VARCHAR(14),
	imovel VARCHAR(100),
	codpagamento VARCHAR(20),
	CONSTRAINT codigoreserva_pk PRIMARY KEY(codigo),
    CONSTRAINT codpagamento_fk FOREIGN KEY(codpagamento)
        REFERENCES pagamento(codigo),
	CONSTRAINT usuario_fk FOREIGN KEY(usuario)
        REFERENCES usuario(cpf),
	CONSTRAINT imovel_fk FOREIGN KEY(imovel)
        REFERENCES imovel(id)
);