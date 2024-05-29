--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists cast_member (
    id uuid primary key default gen_random_uuid(),
    employee_full_name varchar not null,
    content_id uuid not null,
    role_name varchar not null,

    constraint cast_member_fk1 foreign key (content_id) references content (id)
);

-----

-- rollback drop table cast_member;
-- rollback drop table role;
-- rollback drop table employee;
