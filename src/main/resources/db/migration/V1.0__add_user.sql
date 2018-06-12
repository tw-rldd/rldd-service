CREATE TABLE member
(
  id       VARCHAR(64) NOT NULL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  point    INT(4) DEFAULT 3
);