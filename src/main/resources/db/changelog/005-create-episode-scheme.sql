--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists episode (
    id uuid primary key default gen_random_uuid(),
    episode_num int not null,
    season_num int,
    title varchar not null,
    thumbnail varchar,
    storyline varchar,
    s3_bucket_name varchar,
    content_id uuid not null,

    constraint episode_fk1 foreign key (content_id) references content (id)
);

-----

-- rollback drop table episode;
