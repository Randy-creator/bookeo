-- ============================
-- USERS
-- password = "password"
-- ============================

INSERT INTO users (id, username, password_hash, role, created_at) VALUES
(1, 'admin', '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'ADMIN', now()),
(2, 'alice', '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'USER', now()),
(3, 'bob',   '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'USER', now());

-- ============================
-- BOOKS (10 livres)
-- ============================

INSERT INTO books (id, title, author, isbn, stock, created_at) VALUES
(1, 'Clean Code', 'Robert C. Martin', 'ISBN-001', 5, now()),
(2, 'Effective Java', 'Joshua Bloch', 'ISBN-002', 4, now()),
(3, 'Spring in Action', 'Craig Walls', 'ISBN-003', 6, now()),
(4, 'Design Patterns', 'GoF', 'ISBN-004', 3, now()),
(5, 'Refactoring', 'Martin Fowler', 'ISBN-005', 2, now()),
(6, 'Java Concurrency in Practice', 'Brian Goetz', 'ISBN-006', 4, now()),
(7, 'Domain-Driven Design', 'Eric Evans', 'ISBN-007', 3, now()),
(8, 'Clean Architecture', 'Robert C. Martin', 'ISBN-008', 5, now()),
(9, 'Microservices Patterns', 'Chris Richardson', 'ISBN-009', 4, now()),
(10,'Head First Design Patterns', 'Eric Freeman', 'ISBN-010', 6, now());

-- ============================
-- BORROWINGS
-- ============================

INSERT INTO borrowings (id, user_id, book_id, borrowed_at, returned_at) VALUES
(1, 2, 1, now() - interval '10 days', null),
(2, 2, 2, now() - interval '8 days', now() - interval '2 days'),
(3, 3, 1, now() - interval '5 days', null),
(4, 3, 3, now() - interval '3 days', null);
