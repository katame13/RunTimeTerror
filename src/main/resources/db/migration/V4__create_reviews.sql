CREATE TABLE reviews(
  id SERIAL PRIMARY KEY,
   user_name VARCHAR NOT NULL DEFAULT 'Anonymous',
   rating INTEGER MIN 1 MAX 5 NOT NULL,
   review TEXT,
   site_id NOT NULL INTEGER REFERENCES site(id)
);