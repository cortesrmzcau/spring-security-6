/*insert into users (username, password, enabled) VALUES
    ('admin', '123', true),
    ('user', '123', true);

insert into authorities (username, authority) VALUES
    ('admin', 'admin'),
    ('user', 'user');*/

insert into customers(email, pwd, rol) VALUES
    ('cortesrmzcau@gmail.com', 'cesar', 'admin'),
    ('user@gmail.com', 'user', 'user')

insert into roles(role_name, description, id_customer) values
    ('VIEW_ACCOUNT', 'cant view account endpoint', 1)
    ('VIEW_CARDS', 'cant view cards endpoint', 2),
    ('VIEW_LOANS', 'cant view loans endpoint', 3),
    ('VIEW_BALANCE', 'cant view balance endpoint', 4)