CREATE TABLE IF NOT EXISTS recipes (
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

CREATE TABLE IF NOT EXISTS recipe_ingredients (
    recipe_id UUID NOT NULL,
    ingredient VARCHAR(255) NOT NULL,
    CONSTRAINT fk_recipe_ingredients FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS recipe_instructions (
    recipe_id UUID NOT NULL,
    instruction VARCHAR(255) NOT NULL,
    CONSTRAINT fk_recipe_instructions FOREIGN KEY (recipe_id) REFERENCES recipes (id) ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_recipe_ingredients_id ON recipe_ingredients(recipe_id);
CREATE INDEX IF NOT EXISTS idx_recipe_instructions_id ON recipe_instructions(recipe_id);

