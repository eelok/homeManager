create table counters
(
    id SERIAL primary key,
    cold_water  int not null,
    hot_water   int not null,
    electricity int not null
);