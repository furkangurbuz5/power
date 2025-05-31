package dev.gurbuz.power.workout;

import org.springframework.data.annotation.Id;

public record Set(@Id Integer id,
                  Workout workout,
                  int reps,
                  boolean isRecord
) {
}
