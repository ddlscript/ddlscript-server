CREATE TABLE `UserGroup` (
    TIMESTAMP_CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
    , ID INT PRIMARY KEY AUTO_INCREMENT
    , NAME VARCHAR(100) NOT NULL
    , DESCRIPTION TEXT NOT NULL
    , USER_ID_CREATED INT NOT NULL

    , FOREIGN KEY (USER_ID_CREATED)
            REFERENCES `User` (ID)
            ON DELETE RESTRICT
);