--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create extension if not exists "uuid-ossp";

create table if not exists users (
    id uuid primary key default gen_random_uuid(),
    login varchar,
    first_name varchar,
    last_name varchar,
    email varchar,
    phone varchar,
    birthday date,
    subscription_id uuid,
    created_date timestamp,

    constraint user_fk1 foreign key (subscription_id) references subscription (id)
);

-----

-- rollback drop extension "uuid-ossp";
-- rollback drop table user;
