CREATE TABLE veiculo (
    id BIGSERIAL PRIMARY KEY,
    placa VARCHAR(7) NOT NULL UNIQUE,
    marca VARCHAR(50) NOT NULL,
    quilometragem INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('ATIVO', 'INATIVO'))
);

CREATE TABLE pneu (
    id BIGSERIAL PRIMARY KEY,
    numero_de_fogo VARCHAR(50) NOT NULL UNIQUE,
    marca VARCHAR(50) NOT NULL,
    pressao_psi NUMERIC(5,2) NOT NULL,
    status VARCHAR(20) NOT NULL CHECK (status IN ('USO', 'DISPONIVEL'))
);

CREATE TABLE veiculo_pneu (
    id BIGSERIAL PRIMARY KEY,
    veiculo_id BIGINT NOT NULL REFERENCES veiculo(id),
    pneu_id BIGINT NOT NULL REFERENCES pneu(id),
    posicao VARCHAR(5) NOT NULL,
    UNIQUE (veiculo_id, posicao),
    UNIQUE (pneu_id)
);
