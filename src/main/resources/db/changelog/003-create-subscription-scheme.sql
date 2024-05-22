--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create extension if not exists "uuid-ossp";

create table if not exists subscription_type (
    code varchar,
    description varchar,
    price numeric default 0,

    primary key (code)
);

create table if not exists subscription (
    id uuid primary key default gen_random_uuid(),
    status boolean,
    start_date timestamp,
    end_date timestamp,
    subscription_type varchar,

    constraint subscription_fk1 foreign key (subscription_type) references subscription_type (code)
);

-----

-- rollback drop table subscription;
-- rollback drop table subscription_type;
