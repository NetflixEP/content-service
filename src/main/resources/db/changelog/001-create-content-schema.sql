--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create extension if not exists "uuid-ossp";

create table if not exists content (
    id uuid primary key default gen_random_uuid(),
    title varchar not null,
    quality varchar not null,
    genre varchar not null,
    category varchar not null,
    age_restriction varchar not null,
    description varchar,
    thumbnail varchar,
    publisher varchar,
    created_date date not null,
    remaining_time timestamp,
    text tsvector,

    constraint valid_genre check (genre in ('ACTION_FILM', 'BLOCKBUSTER', 'CARTOON', 'COMEDY', 'DOCUMENTARY', 'HISTORICAL_FILM', 'HORROR_FILM', 'MUSICAL', 'DRAMA', 'THRILLER')),
    constraint valid_category check (category in ('MOVIE', 'SERIES', 'ANIMATED_FILM', 'ANIMATED_SERIES')),
    constraint valid_quality check (quality in ('144P', '240P', '360P', '480P', '720P', '1080P', '1440P', '2160P')),
    constraint valid_age_restriction check (age_restriction in ('6+', '12+', '16+', '18+'))
);

create index idx_gin_content_text on content using gin (text);

-----

-- rollback drop extension "uuid-ossp";
-- rollback drop index idx_gin_content_text;
-- rollback drop table content;
