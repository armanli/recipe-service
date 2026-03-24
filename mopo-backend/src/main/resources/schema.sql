CREATE TABLE IF NOT EXISTS clients (
    id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    telephone VARCHAR(15),
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cpf VARCHAR(11) UNIQUE,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS revenues (
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(300),
    image BYTEA,
    -- @Lob mapeia para BYTEA no Postgres
    -- @Lob mapeia para TEXT ou OID no Postgres
    preparation_time INT NOT NULL DEFAULT 0,
    efficiency INT NOT NULL DEFAULT 0,
    rating INT DEFAULT 0,
    difficulty INT DEFAULT 1,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS revenue_ingredients (
    revenue_id UUID NOT NULL,
    ingredient VARCHAR(255) NOT NULL,
    CONSTRAINT fk_revenue_ingredients FOREIGN KEY (revenue_id) REFERENCES revenues (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS revenue_instructions (
    revenue_id UUID NOT NULL,
    instruction VARCHAR(255) NOT NULL,
    CONSTRAINT fk_revenue_instructions FOREIGN KEY (revenue_id) REFERENCES revenues (id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_clients_email ON clients(email);
CREATE INDEX IF NOT EXISTS idx_clients_cpf ON clients(cpf);
CREATE INDEX IF NOT EXISTS idx_revenue_ingredients_id ON revenue_ingredients(revenue_id);
CREATE INDEX IF NOT EXISTS idx_revenue_instructions_id ON revenue_instructions(revenue_id);

CREATE TABLE IF NOT EXISTS couriers (
    id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    telephone VARCHAR(15),
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cpf VARCHAR(11) UNIQUE,
    vehicle VARCHAR(50),
    is_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS nutritionists (
    id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    telephone VARCHAR(15),
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    crn VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS producers (
    id UUID PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    telephone VARCHAR(15),
    is_active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cnpj VARCHAR(14) UNIQUE NOT NULL,
    crea VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS foods (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50),
    -- Enum: VERDURA, FRUTA, LEGUME
    description TEXT,
    expiration_date DATE,
    price DECIMAL(10, 2),
    calories DOUBLE PRECISION,
    carbohydrates DOUBLE PRECISION,
    proteins DOUBLE PRECISION,
    total_fats DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS orders (
    id UUID PRIMARY KEY,
    client_id UUID NOT NULL,
    courier_id UUID,
    total_value DECIMAL(10, 2) NOT NULL,
    status_delivery VARCHAR(50),
    -- Enum: Entregue, Pendente, etc.
    status_payment VARCHAR(50),
    -- Enum: Pago, Pendente, etc.
    payment_method VARCHAR(50),
    -- Enum: Pix, Credito, etc.
    delivery_date TIMESTAMP,
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_order_client FOREIGN KEY (client_id) REFERENCES clients(id),
    CONSTRAINT fk_order_courier FOREIGN KEY (courier_id) REFERENCES couriers(id)
);

CREATE TABLE IF NOT EXISTS order_items (
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    food_id UUID NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    price_at_purchase DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_item_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
    CONSTRAINT fk_item_food FOREIGN KEY (food_id) REFERENCES foods(id)
);