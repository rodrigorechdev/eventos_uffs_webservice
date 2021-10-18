--psql
drop database eventos_uffs;
create database eventos_uffs;

CREATE TABLE modalidade(
	mod_id SERIAL,
	mod_nome VARCHAR(50) NOT NULL,
	PRIMARY KEY(mod_id)
);

CREATE TABLE area_conhecimento(
	area_id SERIAL,
	area_nome VARCHAR(50) NOT NULL,
	PRIMARY KEY(area_id)
);

CREATE TABLE evento(
	ev_id SERIAL,
	ev_nome VARCHAR(50) NOT NULL,
	ev_data DATE DEFAULT CURRENT_DATE NOT NULL,
	ev_quantidade_horas DOUBLE PRECISION NOT NULL,
	ev_horario VARCHAR(5) NOT NULL,
	ev_custo DOUBLE PRECISION,
	mod_id INTEGER NOT NULL,
	area_id INTEGER NOT NULL,
	PRIMARY KEY(ev_id),
	FOREIGN KEY(mod_id) REFERENCES modalidade(mod_id),
	FOREIGN KEY(area_id) REFERENCES area_conhecimento(area_id)
);

CREATE TABLE cargo(
	cargo_id SERIAL,
	cargo_nome VARCHAR (50) NOT NULL,

	PRIMARY KEY(cargo_id)		
);


CREATE TABLE usuario(
	user_id SERIAL,
	user_nome VARCHAR(50) NOT NULL,
	user_email VARCHAR (50) NOT NULL,
	user_senha VARCHAR (20) NOT NULL, 
	user_id_cargo INTEGER NOT NULL,
		
	PRIMARY KEY(user_id),
	FOREIGN KEY(user_id_cargo) REFERENCES cargo(cargo_id)	
);



INSERT INTO modalidade(mod_nome)
VALUES ('pesquisa'),('extensao'),('empreendedorismo');

INSERT INTO area_conhecimento(area_nome)
VALUES ('saude'),('tecnologia'),('didatica');

SELECT * FROM modalidade;

INSERT INTO evento(ev_nome, mod_id, ev_data, area_id, ev_custo, ev_horario, ev_quantidade_horas)
VALUES ('semana academica computacao', 2, '2021-10-03', 2, 50.00, 5, 1);

INSERT INTO evento(ev_nome, mod_id, area_id, ev_horario, ev_quantidade_horas)
VALUES ('calourada', 3, 2, 6, 1);



INSERT INTO cargo(cargo_nome)
VALUES ('Administrador'),('Gestor'),('Usuário');

INSERT INTO usuario(user_nome, user_email, user_senha,user_id_cargo) VALUES ('Fulano de Tal','fuluano@evento.com.br','Ful4n0@T4l', 1);
INSERT INTO usuario(user_nome, user_email, user_senha,user_id_cargo) VALUES ('Joao Da Silva','joao@evento.com.br','Jo4o@T4l', 2);
INSERT INTO usuario(user_nome, user_email, user_senha,user_id_cargo) VALUES ('Ciclano de Tal','cliclano@evento.com.br','cicl4n0@T4l', 3);
