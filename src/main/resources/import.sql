INSERT INTO book (id, title, author, publication_year, isbn) VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', 1925, '9780743273565');
INSERT INTO book (id, title, author, publication_year, isbn) VALUES (2, '1984', 'George Orwell', 1949, '9780451524935');

INSERT INTO patron (id, name, contact_info) VALUES (1, 'John Doe', 'john.doe@example.com');
INSERT INTO patron (id, name, contact_info) VALUES (2, 'Jane Smith', 'jane.smith@example.com');

INSERT INTO borrowing_record (id, book_id, patron_id, borrowing_date) VALUES (1, 1, 1, '2024-01-01');
INSERT INTO borrowing_record (id, book_id, patron_id, borrowing_date) VALUES (2, 2, 2, '2024-02-01');