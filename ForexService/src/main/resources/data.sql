CREATE TABLE EXCHANGE_VALUE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    currency_from VARCHAR(10),
    currency_to VARCHAR(10),
    conversion_multiple DOUBLE,
    port NUMERIC
);

insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10001,'USD','LKR',296,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10002,'EUR','LKR',321,0);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple,port)
values(10003,'YEN','LKR',1.98,0);
