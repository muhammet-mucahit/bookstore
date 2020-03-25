INSERT INTO Author (first_name, last_name) VALUES ('Suzanne', 'Collins');
INSERT INTO Author (first_name, last_name) VALUES ('J.K.', 'Rowling');
INSERT INTO Author (first_name, last_name) VALUES ('Mary', 'GrandPré');

INSERT INTO Book (name, publisher, author_id, publication_year, genre) VALUES
(
    'The Hunger Games',
    'KitapYurdu',
    (select id from Author where id = 2),
    2008,
    'Action'
);

INSERT INTO Book (name, publisher, author_id, publication_year, genre) VALUES
(
    'Harry Potter and the Philosopher''s Stone',
    'Idefix',
    (select id from Author where id = 1),
    1997,
    'Science Fiction'
);