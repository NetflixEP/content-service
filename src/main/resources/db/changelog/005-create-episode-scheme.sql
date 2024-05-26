--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists episode_detail (
    id uuid primary key default gen_random_uuid(),
    title varchar not null,
    thumbnail varchar,
    storyline varchar,
    content_id uuid not null,
    season_num int,

    constraint episode_detail_fk1 foreign key (content_id) references content (id)
);

create table if not exists episode (
    id uuid primary key default gen_random_uuid(),
    episode_detail_id uuid,
    s3_bucket_name varchar,

    constraint episode_fk1 foreign key (episode_detail_id) references episode_detail (id)
);

-----

-- rollback drop table episode;
-- rollback drop table episode_detail;
