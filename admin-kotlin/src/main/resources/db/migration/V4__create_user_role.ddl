CREATE TABLE IF NOT EXISTS user_role(
    user_id int not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FKg7fr1r7o0fkk41nfhnjdyqn7b
    foreign key (user_id) references app_user (id),
    constraint FKp6m37g6n6c288s096400uw8fw
    foreign key (role_id) references app_role (id)
)  ENGINE=INNODB;