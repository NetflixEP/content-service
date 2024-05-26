--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists subscription_type (
    code varchar,
    description varchar,
    price numeric,

    primary key (code)
);

create table if not exists subscription (
    id uuid primary key /* [jooq ignore start]  default GEN_RANDOM_UUID() [jooq ignore stop] */,
    status boolean,
    start_date timestamp,
    end_date timestamp,
    subscription_type varchar,

    constraint subscription_fk1 foreign key (subscription_type) references subscription_type (code)
);

-----

-- rollback drop table subscription;
-- rollback drop table subscription_type;
