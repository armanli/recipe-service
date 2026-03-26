INSERT INTO recipes (id, title, description, image, preparation_time, efficiency, rating, difficulty, created_at,
                      updated_at)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Suco Detox de Limão e Couve', 'Suco refrescante e nutritivo.', null,
        10, 1,
        5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Omelete de Legumes', 'Rápido, proteico e saudável.', null, 15, 1, 4,
        2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Salada de Quinoa', 'Completa com vegetais frescos.', null, 25, 2, 5,
        2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO recipe_ingredients (recipe_id, ingredient)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', '2 folhas de couve'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111101', '1 limão siciliano'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', '3 ovos'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Meia cenoura ralada'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', '1 xícara de quinoa'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Tomate cereja');

INSERT INTO recipe_instructions (recipe_id, instruction)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Bata tudo no liquidificador.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Sirva com gelo.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Bata os ovos e misture os legumes.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Cozinhe em fogo baixo.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Cozinhe a quinoa por 15 min.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Misture com os vegetais.');
