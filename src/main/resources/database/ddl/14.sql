CREATE TABLE `ProjectUserProjectPermission` (
    TIMESTAMP_CREATED TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP()
    , PROJECT_ID INT NOT NULL
    , USER_ID INT NOT NULL
    , PROJECTPERMISSION_ID TINYINT NOT NULL
    , USER_ID_CREATED INT NOT NULL

    , PRIMARY KEY (PROJECT_ID, USER_ID, PROJECTPERMISSION_ID)
    , FOREIGN KEY (PROJECT_ID, USER_ID)
            REFERENCES `ProjectUser` (PROJECT_ID, USER_ID)
            ON DELETE CASCADE
    , FOREIGN KEY (PROJECTPERMISSION_ID)
            REFERENCES `ProjectPermission` (ID)
            ON DELETE CASCADE
    , FOREIGN KEY (USER_ID_CREATED)
            REFERENCES `User` (ID)
            ON DELETE RESTRICT
);