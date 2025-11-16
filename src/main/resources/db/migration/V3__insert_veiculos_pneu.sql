INSERT INTO veiculo (placa, marca, quilometragem, status)
VALUES 
    ('AAA1A11', 'Scania', 120000, 'ATIVO'),
    ('BBB2B22', 'Volvo', 85000,  'ATIVO'),
    ('CCC3C33', 'Mercedes', 210000, 'INATIVO');

INSERT INTO pneu (numero_de_fogo, marca, pressao_psi, status)
VALUES
    ('F188-001', 'Pirelli', 100.00, 'USO'),
    ('F188-002', 'Pirelli', 100.00, 'USO'),
    ('F188-003', 'Pirelli', 100.00, 'USO'),
    ('F188-004', 'Pirelli', 100.00, 'USO'),
    ('F200-001', 'Michelin', 95.00, 'DISPONIVEL'),
    ('F200-002', 'Michelin', 95.00, 'DISPONIVEL'),
    ('F300-001', 'Bridgestone', 110.00, 'DISPONIVEL'),
    ('F300-002', 'Bridgestone', 110.00, 'DISPONIVEL');


INSERT INTO veiculo_pneu (veiculo_id, pneu_id, posicao)
SELECT v.id, p.id, 'A'
FROM veiculo v
JOIN pneu p ON p.numero_de_fogo = 'F188-001'
WHERE v.placa = 'AAA1A11';

INSERT INTO veiculo_pneu (veiculo_id, pneu_id, posicao)
SELECT v.id, p.id, 'B'
FROM veiculo v
JOIN pneu p ON p.numero_de_fogo = 'F188-002'
WHERE v.placa = 'AAA1A11';

INSERT INTO veiculo_pneu (veiculo_id, pneu_id, posicao)
SELECT v.id, p.id, 'C'
FROM veiculo v
JOIN pneu p ON p.numero_de_fogo = 'F188-003'
WHERE v.placa = 'AAA1A11';

INSERT INTO veiculo_pneu (veiculo_id, pneu_id, posicao)
SELECT v.id, p.id, 'D'
FROM veiculo v
JOIN pneu p ON p.numero_de_fogo = 'F188-004'
WHERE v.placa = 'AAA1A11';