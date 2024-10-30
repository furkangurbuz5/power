package dev.gurbuz.power.workout;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Workout {

        private Integer id;
        private String title;
        private LocalDateTime startedOn;
        private LocalDateTime completedOn;
        private Integer workoutsDone;
        private ArrayList<String> workouts;
        private String location;

        public Workout(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer workoutsDone, ArrayList<String> workouts, String location){
                this.id = id;
                this.title = title;
                this.startedOn = startedOn;
                this.completedOn = completedOn;
                this.workoutsDone = workoutsDone;
                this.workouts = workouts;
                this.location = location;

                //Checking if start date and end date are correct.
                if(!completedOn.isAfter(startedOn)){
                        throw new IllegalArgumentException("Completed on must be after Started On");
                }
        }

        public Duration getDuration()
        {
                return Duration.between(startedOn, completedOn);
        }

        public Integer getAvgWorkoutTime()
        {
                return Math.toIntExact(getDuration().toMinutes() / workoutsDone); // TODO total time divided by amount of workouts, can change logic later
        }

        public Integer getId()
        {
                return this.id;
        }

        public String getTitle()
        {
                return this.title;
        }

        public LocalDateTime getStartedOn()
        {
                return this.startedOn;
        }

        public LocalDateTime getCompletedOn()
        {
                return this.completedOn;
        }

        public ArrayList<String> getWorkouts()
        {
                return this.workouts;
        }

        public String getLocation()
        {
                return this.location;
        }

}
