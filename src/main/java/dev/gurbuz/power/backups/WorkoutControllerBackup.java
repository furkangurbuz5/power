//package dev.gurbuz.power.workout;
//
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
///***
// * Keeping this class as a backup
// */
//
//@RestController
//@RequestMapping("/api/workouts")
//public class WorkoutControllerBackup {
//
//        private final WorkoutRepositoryBackup wrb;
//
//        public WorkoutControllerBackup(WorkoutRepositoryBackup workoutRepositoryBackup){
//                this.wrb = workoutRepositoryBackup;
//        }
//        /* GET ---*/
//        @GetMapping("")
//        List<Workout> findAll()
//        {
//                return wrb.findAll();
//        }
//
//        @GetMapping("/{id}")
//        Workout findById(@PathVariable Integer id)
//        {
//                Optional<Workout> workout = wrb.findById(id);
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
//                wrb.create(workout);
//        }
//
//        /* PUT ---*/
//        @ResponseStatus(HttpStatus.NO_CONTENT)
//        @PutMapping("/{id}")
//        void update(@Valid @RequestBody Workout workout, @PathVariable Integer id)
//        {
//                wrb.update(workout, id);
//        }
//
//        /* DELETE ---*/
//        @ResponseStatus(HttpStatus.ACCEPTED)
//        @DeleteMapping("/{id}")
//        void delete(@PathVariable Integer id)
//        {
//                wrb.delete(id);
//        }
//}
