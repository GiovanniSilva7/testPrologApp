CREATE TABLE veiculo(
    id SERIAL PRIMARY KEY,
    placa VARCHAR(7)  UNIQUE NOT NULL,
    marca VARCHAR (50) NOT  NULL,
    quilometragem INTEGER NOT NULL, 
    status VARCHAR NOT NULL CHECK (status IN ('ATIVO', 'INATIVO'))

);

CREATE TABLE pneu(
    id SERIAL PRIMARY KEY,
    numero_de_fogo INTEGER NOT NULL, 
    marca VARCHAR(50) NOT NULL,
    pressao_psi NUMERIC(5,2) NOT NULL,
    status VARCHAR NOT NULL CHECK(status IN ('USO', 'DISPONIVEL'))
);

CREATE TABLE veiculo_pneu (
    id SERIAL PRIMARY KEY,
    veiculo_id INTEGER NOT NULL REFERENCES veiculo(id),
    pneu_id INTEGER NOT NULL REFERENCES pneu(id),
    posicao VARCHAR(5) NOT NULL,
    UNIQUE (veiculo_id, posicao),
    UNIQUE (pneu_id)
);
