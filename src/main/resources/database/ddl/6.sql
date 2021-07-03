CREATE TABLE `UserSystemPermission` (
    TIMESTAMP_CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
    , USER_ID INT NOT NULL
    , SYSTEMPERMISSION_ID TINYINT NOT NULL
    , USER_ID_CREATED INT NOT NULL

    , PRIMARY KEY (USER_ID, SYSTEMPERMISSION_ID)
    , FOREIGN KEY (USER_ID)
            REFERENCES `User` (ID)
            ON DELETE CASCADE
    , FOREIGN KEY (SYSTEMPERMISSION_ID)
            REFERENCES `SystemPermission` (ID)
            ON DELETE CASCADE
    , FOREIGN KEY (USER_ID_CREATED)
            REFERENCES `User` (ID)
            ON DELETE RESTRICT
);