package dev.gurbuz.power.workout;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutRepository {

        private List<Workout> workouts = new ArrayList<>();

        List<Workout> findAll()
        {
                return workouts;
        }
        Optional<Workout> findById(Integer id)
        {
                return workouts.stream()
                        .filter(workout -> workout.id() == id)
                        .findFirst();
        }

        void create(Workout workout)
        {
                workouts.add(workout);
        }

        void update(Workout workout, Integer id)
        {
                Optional<Workout> existingWorkout = findById(id);
                if(existingWorkout.isPresent()){
                        workouts.set(workouts.indexOf(existingWorkout.get()), workout);
                }
        }

        void delete(Integer id)
        {
                workouts.removeIf(workout -> workout.id().equals(id));
        }
        @PostConstruct
        private void init()
        {
                workouts.add(new Workout(
                        1,
                        "Workout at SportCity Houtrust",
                        LocalDateTime.of(2024, 10, 30, 16, 30),
                        LocalDateTime.of(2024, 10, 30, 18, 30),
                        10,
                        new ArrayList<String>(){},
                        "SportCity Houtrust",
                        Exercise.BARBELL_SQUAT
                ));
                workouts.add(new Workout(
                        2,
                        "Workout at SportCity Houtrust",
                        LocalDateTime.of(2024, 10, 31, 16, 30),
                        LocalDateTime.of(2024, 10, 31, 18, 30),
                        10,
                        new ArrayList<String>(){},
                        "SportCity Houtrust",
                        Exercise.DEADLIFT
                ));

        }

}
