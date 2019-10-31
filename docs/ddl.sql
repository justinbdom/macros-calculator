CREATE TABLE IF NOT EXISTS `Trainee`
(
    `trainee_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created`         INTEGER                           NOT NULL,
    `name`            TEXT                              NOT NULL,
    `email`           TEXT,
    `lbs_to_lose`     INTEGER                           NOT NULL,
    `food_preference` TEXT
);

CREATE INDEX IF NOT EXISTS `index_Trainee_created` ON `Trainee` (`created`);

CREATE TABLE IF NOT EXISTS `Food`
(
    `food_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `created`      INTEGER                           NOT NULL,
    `name`         TEXT                              NOT NULL,
    `updated`      INTEGER                           NOT NULL,
    `food_type_id` INTEGER,
    `trainee_id`   INTEGER,
    `servingSize`  INTEGER                           NOT NULL,
    `protein`      TEXT,
    `carbs`        TEXT,
    `veggies`      TEXT,
    FOREIGN KEY (`trainee_id`) REFERENCES `Trainee` (`trainee_id`) ON UPDATE NO ACTION ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS `Activity`
(
    `activity_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `trainee_id`  INTEGER                           NOT NULL,
    `duration`    INTEGER                           NOT NULL,
    `name`        TEXT,
    `type`        TEXT,
    `created`     INTEGER                           NOT NULL,
    FOREIGN KEY (`trainee_id`) REFERENCES `Trainee` (`trainee_id`) ON UPDATE NO ACTION ON DELETE CASCADE;

CREATE INDEX IF NOT EXISTS `index_Activity_trainee_id` ON `Activity` (`trainee_id`);

CREATE INDEX IF NOT EXISTS `index_Activity_created` ON `Activity` (`created`);





