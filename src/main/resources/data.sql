DROP TABLE IF EXISTS tb_model;
DROP TABLE IF EXISTS tb_category;
DROP TABLE IF EXISTS tb_line;

CREATE TABLE tb_line(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE tb_category(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    line_id BIGINT NOT NULL,
    CONSTRAINT fk_category_line FOREIGN KEY (line_id)
        REFERENCES tb_line (id)
        ON DELETE CASCADE
);

CREATE TABLE tb_model(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT fk_model_category FOREIGN KEY (category_id)
        REFERENCES tb_category (id)
        ON DELETE CASCADE
);

INSERT INTO tb_line (id, name) VALUES
    (1, 'Cronos'),
    (2, 'Ares');

INSERT INTO tb_category (id, name, line_id) VALUES
    (1, 'Cronos Old', 1),
    (2, 'Cronos L', 1),
    (3, 'Cronos-NG', 1),
    (4, 'Ares TB', 2),
    (5, 'Ares THS', 2);

INSERT INTO tb_model (id, name, category_id) VALUES
    (1, 'Cronos 6001-A', 1),
    (2, 'Cronos 6003', 1),
    (3, 'Cronos 7023', 1),
    (4, 'Cronos 6021L', 2),
    (5, 'Cronos 7023L', 2),
    (6, 'Cronos 6001-NG', 3),
    (7, 'Cronos 6003-NG', 3),
    (8, 'Cronos 6021-NG', 3),
    (9, 'Cronos 6031-NG', 3),
    (10, 'Cronos 7021-NG', 3),
    (11, 'Cronos 7023-NG', 3),
    (12, 'Ares 7021', 4),
    (13, 'Ares 7031', 4),
    (14, 'Ares 7023', 4),
    (15, 'Ares 8023 15', 5),
    (16, 'Ares 8023 200', 5),
    (17, 'Ares 8023 2,5', 5);