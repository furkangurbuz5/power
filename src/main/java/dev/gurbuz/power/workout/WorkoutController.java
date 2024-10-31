package dev.gurbuz.power.workout;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

        private final WorkoutRepository wr;

        public WorkoutController(WorkoutRepository workoutRepository){
                this.wr = workoutRepository;
        }

        /* GET ---*/
        @GetMapping("")
        List<Workout> findAll()
        {
                return wr.findAll();
        }

//        @GetMapping("/{id}")
//        Workout findById(@PathVariable Integer id)
//        {
//                Optional<Workout> workout = wr.findById(id);
//                if(workout.isEmpty()){
//                        throw new WorkoutNotFoundException();
//                }
//                return workout.get();
//        }
//
//        /* POST ---*/
//        @ResponseStatus(HttpStatus.CREATED)
//        @PostMapping("")
//        void create(@Valid @RequestBody Workout workout)
//        {
//                wr.create(workout);
//        }
//
//        /* PUT ---*/
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        @PutMapping("/{id}")
//        void update(@Valid @RequestBody Workout workout, @PathVariable Integer id)
//        {
//                wr.update(workout, id);
//        }
//
//        /* DELETE ---*/
//        @ResponseStatus(HttpStatus.ACCEPTED)
//        @DeleteMapping("/{id}")
//        void delete(@PathVariable Integer id)
//        {
//                wr.delete(id);
//        }

}
