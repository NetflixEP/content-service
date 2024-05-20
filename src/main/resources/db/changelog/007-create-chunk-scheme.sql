--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create extension if not exists "uuid-ossp";

create table if not exists chunk (
    id uuid primary key default gen_random_uuid(),
    episode_id uuid not null,
    time_code time not null,
    quality varchar,
    url varchar,

    constraint chunk_fk1 foreign key (episode_id) references episode (id)
);

-----

-- rollback drop extension "uuid-ossp";
-- rollback drop table chunk;
