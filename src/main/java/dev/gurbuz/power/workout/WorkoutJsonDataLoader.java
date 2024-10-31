package dev.gurbuz.power.workout;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aot.hint.TypeReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class WorkoutJsonDataLoader implements CommandLineRunner {

        private static final Logger logger = LoggerFactory.getLogger(WorkoutJsonDataLoader.class);
        private final WorkoutRepository wr;
        private final ObjectMapper objectMapper;

        public WorkoutJsonDataLoader(WorkoutRepository workoutRepository, ObjectMapper objectMapper){
                this.wr = workoutRepository;
                this.objectMapper = objectMapper;
        }

        @Override
        public void run(String... args) throws Exception {
                if(wr.count()==0){
                        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/workouts.json")){
                                if(inputStream == null){
                                        throw new IllegalArgumentException("File not found at path: /data/workouts.json");
                                }
                                Workouts allWorkouts = objectMapper.readValue(inputStream, Workouts.class);
                                logger.info("Reading {} workouts from JSON data and saving to in-memory collection.", allWorkouts.workouts().size());
                                wr.saveAll(allWorkouts.workouts());
                        }catch (IllegalArgumentException e) {
                                logger.error("The specified file path is incorrect or the file is missing: /data/workouts.json", e);
                                throw new RuntimeException("Failed to locate JSON file in resources.", e);
                        }catch(IOException e){
                                throw new RuntimeException("Failed to read JSON data.");
                        }
                }else{
                        logger.info("Not loading workouts from JSON data becuase the collection already contains data.");
                }
        }
}
