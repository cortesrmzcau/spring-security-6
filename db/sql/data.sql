/*insert into users (username, password, enabled) VALUES
    ('admin', '123', true),
    ('user', '123', true);

insert into authorities (username, authority) VALUES
    ('admin', 'admin'),
    ('user', 'user');*/

insert into customers(email, pwd) VALUES
    ('cortesrmzcau@gmail.com', 'cesar'),
    ('user@gmail.com', 'cesar'),
    ('yo@gmail.com', 'cesar'),
    ('tu@gmail.com', 'cesar');

insert into roles(role_name, description, id_customer) values
    /*('ROLE_ADMIN', 'cant view account endpoint', 1),
    ('ROLE_ADMIN', 'cant view cards endpoint', 2),
    ('ROLE_USER', 'cant view loans endpoint', 3),
    ('ROLE_USER', 'cant view balance endpoint', 4);*/

('VIEW_ACCOUNT', 'cant view account endpoint', 1),
('VIEW_CARDS', 'cant view cards endpoint', 2),
('VIEW_LOANS', 'cant view loans endpoint', 3),
('VIEW_BALANCE', 'cant view balance endpoint', 4);
