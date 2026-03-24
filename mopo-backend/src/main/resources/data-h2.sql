INSERT INTO clients (id, username, email, password, telephone,
                     is_active, created_at, updated_at, cpf, birthday)
VALUES ('a1c1c7b1-1111-4c1a-9c1a-111111111111',
        'user1', 'user1@email.com', '123456', '11999990001',
        true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '12345678901', '1995-01-10'),
       ('a1c1c7b1-1111-4c1a-9c1a-111111111112',
        'user2', 'user2@email.com', '123456', '11999990002',
        true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '12345678902', '1996-02-11'),
       ('a1c1c7b1-1111-4c1a-9c1a-111111111113',
        'user3', 'user3@email.com', '123456', '11999990003',
        true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '12345678903', '1994-03-12');

INSERT INTO revenues (id, title, description, image, preparation_time, efficiency, rating, difficulty, created_at,
                      updated_at)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Suco Detox de Limão e Couve', 'Suco refrescante e nutritivo.', null,
        10, 1,
        5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Omelete de Legumes', 'Rápido, proteico e saudável.', null, 15, 1, 4,
        2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Salada de Quinoa', 'Completa com vegetais frescos.', null, 25, 2, 5,
        2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO revenue_ingredients (revenue_id, ingredient)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', '2 folhas de couve'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111101', '1 limão siciliano'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', '3 ovos'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Meia cenoura ralada'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', '1 xícara de quinoa'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Tomate cereja');

INSERT INTO revenue_instructions (revenue_id, instruction)
VALUES ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Bata tudo no liquidificador.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111101', 'Sirva com gelo.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Bata os ovos e misture os legumes.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111102', 'Cozinhe em fogo baixo.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Cozinhe a quinoa por 15 min.'),
       ('b1c1c7b1-2222-4c1a-9c1a-111111111103', 'Misture com os vegetais.');

INSERT INTO couriers (id, username, email, password, telephone, cpf, vehicle, is_available)
VALUES ('c1c1c7b1-3333-4c1a-9c1a-111111111101', 'motoboy_pedro', 'pedro@entrega.com', 'senha123', '11988880001',
        '12312312301', 'Moto Honda CG', true),
       ('c1c1c7b1-3333-4c1a-9c1a-111111111102', 'bike_carla', 'carla@entrega.com', 'senha123', '11988880002',
        '12312312302', 'Bicicleta Elétrica', true),
       ('c1c1c7b1-3333-4c1a-9c1a-111111111103', 'utilitario_jose', 'jose@entrega.com', 'senha123', '11988880003',
        '12312312303', 'Fiat Fiorino', false);

INSERT INTO nutritionists (id, username, email, password, telephone, crn)
VALUES ('a1c1c7b1-4444-4c1a-9c1a-111111111101', 'nutri_ana', 'ana@saude.com', 'senha123', '11977770001', 'CRN-12345'),
       ('a1c1c7b1-4444-4c1a-9c1a-111111111102', 'dr_marcos', 'marcos@saude.com', 'senha123', '11977770002',
        'CRN-67890'),
       ('a1c1c7b1-4444-4c1a-9c1a-111111111103', 'nutri_julia', 'julia@saude.com', 'senha123', '11977770003',
        'CRN-11223');

INSERT INTO producers (id, username, email, password, telephone, cnpj, crea)
VALUES ('a1c1c7b1-5555-4c1a-9c1a-111111111101', 'fazenda_verde', 'contato@fazendaverde.com', 'senha123', '11966660001',
        '12345678000101', 'CREA-SP123'),
       ('a1c1c7b1-5555-4c1a-9c1a-111111111102', 'organicos_vida', 'vendas@organicos.com', 'senha123', '11966660002',
        '12345678000102', NULL),
       ('a1c1c7b1-5555-4c1a-9c1a-111111111103', 'sitio_alvorada', 'alvorada@agro.com', 'senha123', '11966660003',
        '12345678000103', 'CREA-MG456');

INSERT INTO foods (id, name, type, description, expiration_date, price, calories, carbohydrates, proteins, total_fats)
VALUES ('f1c1c7b1-6666-4c1a-9c1a-111111111101', 'Alface Crespa', 'VERDURA', 'Maço orgânico fresquinho.', '2026-03-25',
        4.50, 15, 2.9, 1.4, 0.2),
       ('f1c1c7b1-6666-4c1a-9c1a-111111111102', 'Maçã Fuji', 'FRUTA', 'Unidade de 150g aproximadamente.', '2026-04-10',
        2.80, 52, 14.0, 0.3, 0.2),
       ('f1c1c7b1-6666-4c1a-9c1a-111111111103', 'Cenoura Baby', 'LEGUME', 'Pacote de 200g higienizado.', '2026-03-30',
        6.90, 41, 10.0, 0.9, 0.2);

INSERT INTO orders (id, client_id, courier_id,
                    total_value, status_delivery, status_payment, payment_method)
VALUES ('a1c1c7b1-7777-4c1a-9c1a-111111111101',
        'a1c1c7b1-1111-4c1a-9c1a-111111111111',
        'c1c1c7b1-3333-4c1a-9c1a-111111111101',
        11.80, 'Pendente', 'Pago', 'PIX'),
       ('a1c1c7b1-7777-4c1a-9c1a-111111111102',
        'a1c1c7b1-1111-4c1a-9c1a-111111111112',
        'c1c1c7b1-3333-4c1a-9c1a-111111111102',
        20.70, 'Em Rota', 'Pago', 'CREDITO'),
       ('a1c1c7b1-7777-4c1a-9c1a-111111111103',
        'a1c1c7b1-1111-4c1a-9c1a-111111111111',
        NULL,
        2.80, 'Pendente', 'Pendente', 'BOLETO');

INSERT INTO order_items (id, order_id, food_id, quantity, price_at_purchase)
VALUES (RANDOM_UUID(),
        'a1c1c7b1-7777-4c1a-9c1a-111111111101',
        'f1c1c7b1-6666-4c1a-9c1a-111111111101',
        2,
        4.50),
       (RANDOM_UUID(),
        'a1c1c7b1-7777-4c1a-9c1a-111111111101',
        'f1c1c7b1-6666-4c1a-9c1a-111111111102',
        1,
        2.80),
       (RANDOM_UUID(),
        'a1c1c7b1-7777-4c1a-9c1a-111111111102',
        'f1c1c7b1-6666-4c1a-9c1a-111111111103',
        3,
        6.90);