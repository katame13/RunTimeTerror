CREATE TABLE reviews
(
    id SERIAL PRIMARY KEY,
    user_name VARCHAR DEFAULT 'Anonymous',
    rating INTEGER NOT NULL,
    review TEXT,
    longest_relationship INTEGER,
    site_id INTEGER REFERENCES sites(id) NOT NULL
);