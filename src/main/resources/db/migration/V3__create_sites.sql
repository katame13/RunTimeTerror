CREATE TABLE sites(
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
url VARCHAR(255) NOT NULL,
category_id INTEGER REFERENCES categories(id)
);