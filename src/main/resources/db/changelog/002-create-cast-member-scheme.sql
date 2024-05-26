--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true

create table if not exists employee (
    id bigserial primary key,
    full_name varchar not null unique
);

create table if not exists role (
    id serial primary key,
    name varchar not null unique
);

create table if not exists cast_member (
    id bigserial primary key,
    actor_id bigint not null,
    content_id uuid not null,
    role_id int not null,

    constraint cast_member_fk1 foreign key (actor_id) references employee (id),
    constraint cast_member_fk2 foreign key (content_id) references content (id),
    constraint cast_member_fk3 foreign key (role_id) references role (id)
);

-----

-- rollback drop table cast_member;
-- rollback drop table role;
-- rollback drop table employee;
