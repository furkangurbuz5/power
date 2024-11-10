package dev.gurbuz.power.workout;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutRepository {

        private static final Logger logger = LoggerFactory.getLogger(WorkoutRepository.class);
        private final JdbcClient jdbcClient;

        public WorkoutRepository(JdbcClient jdbcClient){
                this.jdbcClient = jdbcClient;
        }

        public List<Workout> findAll()
        {
                return jdbcClient.sql
                        (
                                "SELECT * FROM workout"
                        )
                        .query(Workout.class)
                        .list();
        }

        public Optional<Workout> findById(Integer id)
        {
                return jdbcClient.sql
                                (
                                        "SELECT id,title,started_on,completed_on,workouts_done,location FROM workout WHERE id = :id"
                                )
                        .param("id", id)
                        .query(Workout.class)
                        .optional();
        }

        public void create(Workout workout)
        {
                var created = jdbcClient.sql("INSERT INTO workout(id,title,started_on,completed_on,workouts_done,location) values(?,?,?,?,?,?)")
                        .params(List.of(workout.id(), workout.title(),workout.startedOn(),workout.completedOn(),workout.workoutsDone(),workout.location()))
                        .update();
                Assert.state(created==1,"Failed to create workout "+workout.title());
        }

        public void update(Workout workout, Integer id)
        {
                var updated = jdbcClient.sql("UPDATE workout SET title = ?, started_on = ?, completed_on = ?, workouts_done = ?, location = ? WHERE id = ?")
                        .params(List.of(workout.title(),workout.startedOn(),workout.completedOn(),workout.workoutsDone(),workout.location(), id))
                        .update();
                Assert.state(updated == 1, "Failed to update workout " + workout.title());
        }

        public void delete(Integer id)
        {
                var deleted = jdbcClient.sql("DELETE FROM workout WHERE id = :id")
                        .param("id", id)
                        .update();
                Assert.state(deleted == 1, "Failed to delete workout " + id);
        }

        public int count(){return jdbcClient.sql("SELECT * FROM workout")
                .query()
                .listOfRows()
                .size();
        }

        public void saveAll(List<Workout> workouts)
        {
                workouts.stream().forEach(this::create); //TODO change function?
        }

        public List<Workout> findByLocation(String location)
        {
                return jdbcClient.sql("SELECT * FROM workout WHERE location = :location")
                        .param("location", location)
                        .query(Workout.class)
                        .list();
        }

}
