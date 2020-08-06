DROP TABLE IF EXISTS timezone;

CREATE TABLE timezone (
	id INT AUTO_INCREMENT PRIMARY KEY,
	location VARCHAR(100) not null,
	timezone VARCHAR(100) not null,
	hour_offset INT not null,
	minute_offset INT not null,
	balance VARCHAR(1) not null
);

INSERT INTO timezone (timezone, location, hour_offset, minute_offset, balance) VALUES
('Brazil', 'America/Araguaina', 3, 0, '-'),
('Brazil', 'America/Bahia', 3, 0, '-'),
('Brazil', 'America/Belem', 3, 0, '-'),
('Brazil', 'America/Boa_Vista', 4, 0, '-'),
('Brazil', 'America/Campo_Grande', 4, 0, '-'),
('Brazil', 'America/Cuiaba', 4, 0, '-'),
('Brazil', 'America/Eirunepe', 5, 0, '-'),
('Brazil', 'America/Fortaleza', 3, 0, '-'),
('Brazil', 'America/Maceio', 3, 0, '-'),
('Brazil', 'America/Manaus', 4, 0, '-'),
('Brazil', 'America/Noronha', 2, 0, '-'),
('Brazil', 'America/Porto_Velho', 4, 0, '-'),
('Brazil', 'America/Recife', 3, 0, '-'),
('Brazil', 'America/Rio_Branco', 5, 0, '-'),
('Brazil', 'America/Santarem', 3, 0, '-'),
('Brazil', 'America/Sao_Paulo', 3, 0, '-');