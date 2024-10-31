package dev.gurbuz.power.workout;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WorkoutNotFoundException extends RuntimeException{
        public WorkoutNotFoundException(){
                super("Workout Not Found");
        }
}
