package dev.gurbuz.power.workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record Workout(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer workoutsDone,
        String location,
        Exercise mainExercise
) {
        public Workout{
                if(!completedOn.isAfter(startedOn)){
                        throw new IllegalArgumentException("completedOn must be after startedOn!");
                }
        }
}
