--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true

create table if not exists users (
    id uuid primary key /* [jooq ignore start]  default GEN_RANDOM_UUID() [jooq ignore stop] */,
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

-- rollback drop table user;
