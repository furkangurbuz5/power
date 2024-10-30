package dev.gurbuz.power.workout;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record Workout(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer workoutsDone,
        ArrayList<String> workouts,
        String location,
        Exercise mainExercise
) {}
