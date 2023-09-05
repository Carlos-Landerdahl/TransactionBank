INSERT INTO users (name, lastName, password, document, email, balance, userType)
VALUES 
('Carlos', 'Landerdahl', 'senha123', '12345678901', 'carlos@email.com', 1000.00, 'CUSTOMER'),
('Maria', 'Silva', 'senha456', '98765432109', 'maria@email.com', 2000.00, 'CUSTOMER'),
('João', 'Pereira', 'senha789', '11223344556', 'joao@email.com', 1500.00, 'CUSTOMER');
create table transactions (amount numeric(38,2), id bigserial not null, local_stemp timestamp(6), receiver_id bigint, sender_id bigint, primary key (id));
create table users (balance numeric(38,2), user_type smallint check (user_type between 0 and 1), id bigserial not null, document varchar(255) unique, email varchar(255) unique, last_name varchar(255), name varchar(255), password varchar(255), primary key (id));
alter table if exists transactions add constraint FK5nn8ird7idyxyxki68gox2wbx foreign key (receiver_id) references users;
alter table if exists transactions add constraint FK3ly4r8r6ubt0blftudix2httv foreign key (sender_id) references users;
