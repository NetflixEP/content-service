--liquibase formatted sql

--changeset author:llav3ji2019 failOnError:true
create table if not exists content_search_data (
    id bigserial primary key,
    text tsvector,
    content_id uuid,

    constraint content_search_fk1 foreign key (content_id) references content (id)
);

CREATE INDEX idx_gin_search_text
    ON content_search_data
        USING gin (text);

-----

-- rollback drop index idx_gin_search_text;
-- rollback drop table content_search_data;
