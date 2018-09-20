CREATE SCHEMA IF NOT EXISTS REABFACIL;

CREATE TABLE IF NOT EXISTS  CLINICA (
	ID_CLINICA INT PRIMARY KEY,
    NOME VARCHAR(50),
    LINK VARCHAR(256)
    );

CREATE TABLE IF NOT EXISTS  UNIDADE(
	ID_UNIDADE SMALLINT,
    ID_CLINICA INT,
    NOME VARCHAR(256),
    GENERO VARCHAR(2),
    CNPJ VARCHAR(15),
    ESTADO VARCHAR(2),
    CIDADE VARCHAR(50),
    ENDERECO VARCHAR(256),
    CEP VARCHAR(8),
    CONSTRAINT PK_UNIxCLI PRIMARY KEY (ID_UNIDADE, ID_CLINICA),
    CONSTRAINT FK_CLINICA FOREIGN KEY (ID_CLINICA) REFERENCES CLINICA (ID_CLINICA)
	) ENGINE = INNODB;


CREATE TABLE IF NOT EXISTS  TRATAMENTO (
	ID_TRATAMENTO SMALLINT PRIMARY KEY,
    NOME_TRATAMENTO VARCHAR(50)
	);

CREATE TABLE IF NOT EXISTS  UNIxTRATAMENTO (
	ID_UNIDADE SMALLINT,
    ID_TRATAMENTO SMALLINT,
    CONSTRAINT PK_UNIxTRAT PRIMARY KEY (ID_UNIDADE, ID_TRATAMENTO),
    CONSTRAINT FK_UNIxTRAT FOREIGN KEY (ID_UNIDADE) REFERENCES UNIDADE (ID_UNIDADE)
    ) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS  TELEFONE (
	ID_TELEFONE SMALLINT,
    ID_UNIDADE SMALLINT,
    TELEFONE VARCHAR(11),
    CONSTRAINT PK_TELxUNI PRIMARY KEY (ID_TELEFONE,ID_UNIDADE),
    CONSTRAINT FK_UNIDADE FOREIGN KEY (ID_UNIDADE) REFERENCES UNIDADE (ID_UNIDADE)
    ) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS  AVALIACAO (
	ID_AVALIACAO SMALLINT,
    ID_UNIDADE SMALLINT,
    COMENTARIO VARCHAR(256),
    NOTA INT(2),
    USUARIO BOOLEAN,
    CONSTRAINT PK_AVALxUNI PRIMARY KEY (ID_AVALIACAO, ID_UNIDADE),
    CONSTRAINT FK_UNIDADE_AVAL FOREIGN KEY (ID_UNIDADE) REFERENCES UNIDADE (ID_UNIDADE)
    ) ENGINE = INNODB;