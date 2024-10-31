package dev.gurbuz.power.workout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

public class WorkoutJsonDataLoader implements CommandLineRunner {

        private static final Logger logger = LoggerFactory.getLogger(WorkoutJsonDataLoader.class);
        private WorkoutRepository workoutRepository;

        public WorkoutJsonDataLoader(WorkoutRepository workoutRepository){
                this.workoutRepository = workoutRepository;
        }

        @Override
        public void run(String... args) throws Exception {

        }
}
