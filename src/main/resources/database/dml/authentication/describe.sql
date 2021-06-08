SELECT ID
        , PASSWORD_HASH

FROM `User`

WHERE USERNAME = ?
  AND TIMESTAMP_ARCHIVED IS NULL
  AND PASSWORD_HASH IS NOT NULL