CREATE TABLE IF NOT EXISTS app_role(
    id BIGINT(19) AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    role_name VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS app_user(
    id BIGINT(19) AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS user_role(
    user_id BIGINT(19) NOT NULL,
    role_id BIGINT(19) NOT NULL,
    primary key (user_id, role_id),
    foreign key (user_id) references app_user (id),
    foreign key (role_id) references app_role (id)
)  ENGINE=INNODB;