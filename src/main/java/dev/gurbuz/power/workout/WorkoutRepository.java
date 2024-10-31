package dev.gurbuz.power.workout;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

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

}
