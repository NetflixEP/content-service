--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists subscription_type (
    code varchar,
    description varchar,
    price numeric default 0,

    primary key (code)
);
-----

-- rollback drop table subscription_type;
