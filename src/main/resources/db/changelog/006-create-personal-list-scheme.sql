--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists personal_list (
    id uuid primary key default gen_random_uuid(),
    created_date timestamp,
    user_id uuid,

    constraint personal_list_fk1 foreign key (user_id) references users (id)
);

create table if not exists personal_list_content (
    user_id uuid references users (id),
    content_id uuid references content (id),

    primary key (user_id, content_id)
);

-----

-- rollback drop table personal_list_content;
-- rollback drop table personal_list;
