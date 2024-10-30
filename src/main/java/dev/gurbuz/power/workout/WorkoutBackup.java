package dev.gurbuz.power.workout;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class WorkoutBackup {

        private Integer id;
        private String title;
        private LocalDateTime startedOn;
        private LocalDateTime completedOn;
        private Integer workoutsDone;
        private ArrayList<String> workouts;
        private String location;

        public WorkoutBackup(Integer id, String title, LocalDateTime startedOn, LocalDateTime completedOn, Integer workoutsDone, ArrayList<String> workouts, String location){
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

        public void setId(Integer id) {
                this.id = id;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setStartedOn(LocalDateTime startedOn) {
                this.startedOn = startedOn;
        }

        public void setCompletedOn(LocalDateTime completedOn) {
                this.completedOn = completedOn;
        }

        public void setWorkoutsDone(Integer workoutsDone) {
                this.workoutsDone = workoutsDone;
        }

        public void setWorkouts(ArrayList<String> workouts) {
                this.workouts = workouts;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                WorkoutBackup workout = (WorkoutBackup) o;
                return Objects.equals(id, workout.id) && Objects.equals(title, workout.title) && Objects.equals(startedOn, workout.startedOn) && Objects.equals(completedOn, workout.completedOn) && Objects.equals(workoutsDone, workout.workoutsDone) && Objects.equals(workouts, workout.workouts) && Objects.equals(location, workout.location);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, title, startedOn, completedOn, workoutsDone, workouts, location);
        }

        @Override
        public String toString() {
                return "Workout{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", startedOn=" + startedOn +
                        ", completedOn=" + completedOn +
                        ", workoutsDone=" + workoutsDone +
                        ", workouts=" + workouts +
                        ", location='" + location + '\'' +
                        '}';
        }
}
