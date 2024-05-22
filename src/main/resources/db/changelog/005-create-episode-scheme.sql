--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create extension if not exists "uuid-ossp";

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
    remaining_time time,
    actual_watch_time time,
    play_speed numeric(2),
    user_id uuid,
    episode_detail_id uuid,

    constraint episode_fk1 foreign key (user_id) references users (id),
    constraint episode_fk2 foreign key (episode_detail_id) references episode_detail (id)
);

-----

-- rollback drop extension "uuid-ossp";
-- rollback drop table episode;
-- rollback drop table episode_detail;
