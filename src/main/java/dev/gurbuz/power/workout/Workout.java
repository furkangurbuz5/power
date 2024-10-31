package dev.gurbuz.power.workout;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record Workout(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer workoutsDone,
        String location,
        Exercise mainExercise,
        @Version
        Integer version
) {
        public Workout{
                if(!completedOn.isAfter(startedOn)){
                        throw new IllegalArgumentException("completedOn must be after startedOn!");
                }
        }
}
