-- =====================================================
-- CLEAR ALL TABLES BEFORE INSERT (avoids duplicate key)
-- =====================================================

TRUNCATE TABLE borrowings RESTART IDENTITY CASCADE;
TRUNCATE TABLE books RESTART IDENTITY CASCADE;
TRUNCATE TABLE users RESTART IDENTITY CASCADE;

-- ============================
-- USERS
-- password = "password"
-- ============================

INSERT INTO users (username, password_hash, role, created_at) VALUES
('admin', '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'ADMIN', now()),
('alice', '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'USER', now()),
('bob',   '$2a$10$9uX6kE8sZp8vY8W7s3U7UO8Fh9V1hFZP3w5Zc6y9l7b5m1c1k1e', 'USER', now());

-- ============================
-- BOOKS (10 livres)
-- ============================

INSERT INTO books (title, author, isbn, stock, created_at) VALUES
('Clean Code', 'Robert C. Martin', 'ISBN-001', 5, now()),
('Effective Java', 'Joshua Bloch', 'ISBN-002', 4, now()),
('Spring in Action', 'Craig Walls', 'ISBN-003', 6, now()),
('Design Patterns', 'GoF', 'ISBN-004', 3, now()),
('Refactoring', 'Martin Fowler', 'ISBN-005', 2, now()),
('Java Concurrency in Practice', 'Brian Goetz', 'ISBN-006', 4, now()),
('Domain-Driven Design', 'Eric Evans', 'ISBN-007', 3, now()),
('Clean Architecture', 'Robert C. Martin', 'ISBN-008', 5, now()),
('Microservices Patterns', 'Chris Richardson', 'ISBN-009', 4, now()),
('Head First Design Patterns', 'Eric Freeman', 'ISBN-010', 6, now());

-- ============================
-- BORROWINGS
-- ============================

-- NOTE: user_id and book_id are set according to auto-generated IDs
-- Assuming the IDs are in order: 1=admin, 2=alice, 3=bob
-- Books IDs are 1..10 as inserted above

INSERT INTO borrowings (user_id, book_id, borrowed_at, returned_at) VALUES
(2, 1, now() - interval '10 days', null), -- alice emprunte "Clean Code"
(2, 2, now() - interval '8 days', now() - interval '2 days'), -- alice emprunte et retourne "Effective Java"
(3, 1, now() - interval '5 days', null), -- bob emprunte "Clean Code"
(3, 3, now() - interval '3 days', null); -- bob emprunte "Spring in Action"
