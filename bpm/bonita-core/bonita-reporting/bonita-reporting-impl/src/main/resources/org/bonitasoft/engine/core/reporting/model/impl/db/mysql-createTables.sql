CREATE TABLE report (
  tenantId BIGINT NOT NULL,
  id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  description TEXT,
  installationDate BIGINT NOT NULL,
  installedBy BIGINT NOT NULL,
  provided BOOLEAN,
  UNIQUE (tenantId, name),
  PRIMARY KEY (tenantId, id)
) ENGINE = INNODB;
