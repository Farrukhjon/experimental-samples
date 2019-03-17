create table account (
    account_id integer,
    client_id integer,
    currency varchar,
    balance double
)

create table client (
     id integer,
    firstName varchar,
    lastName varchar
)

create table transaction (
    id integer,
    date timestamp,
    from_account integer,
    to_account integer,
    amount double,
    description varchar
)

