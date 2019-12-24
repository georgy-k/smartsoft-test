DROP TABLE IF EXISTS product
create table product
(
 id bigint NOT NULL,
 name varchar(11) NOT NULL,
 PRIMARY KEY (id)
);


DROP TABLE IF EXISTS purchase
create table purchase (
  id  bigint not null,
  age int not null,
  amount float not null,
  count int not null,
  lastname varchar(255) not null,
  name varchar(255) not null,
  purchase_date timestamp not null,
  purchase_item int not null,
  primary key (id),
  constraint purchase_and_purchase_item foreign key (purchase_item) references product
  on update cascade
  on delete restrict
  )



