--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists users (
    id uuid primary key default gen_random_uuid(),
    login varchar,
    first_name varchar,
    last_name varchar,
    email varchar,
    phone varchar,
    birthday date,
    created_date timestamp,

    subscription_status boolean,
    subscription_start_date timestamp,
    subscription_end_date timestamp,
    subscription_type varchar,

    constraint user_fk1 foreign key (subscription_type) references subscription_type (code)
);

-----

-- rollback drop table user;
