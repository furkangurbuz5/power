CREATE TABLE IF NOT EXISTS Workout(
    id INT NOT NULL,
    title varchar(255) NOT NULL,
    started_on timestamp NOT NULL,
    completed_on timestamp NOT NULL,
    workouts_done INT NOT NULL,
    location varchar(255) NOT NULL,
    mainExercise varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
