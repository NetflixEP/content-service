--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists subscription_type (
    code varchar,
    description varchar,
    price numeric default 0,

    primary key (code)
);

create table if not exists subscription (
    id serial primary key,
    status boolean,
    start_date timestamp,
    end_date timestamp,
    subscription_type_id int,

    constraint subscription_fk1 foreign key (subscription_type_id) references subscription_type (code)
);

-----

-- rollback drop table subscription;
-- rollback drop table subscription_type;
