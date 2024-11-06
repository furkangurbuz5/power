package dev.gurbuz.power;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PowerApplication {

	private static final Logger logger = LoggerFactory.getLogger(PowerApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(PowerApplication.class, args);

	}

//	@Bean
//	CommandLineRunner runner(WorkoutRepository workoutRepository){
//		return args -> {
//			Workout workout = new Workout(
//				10,
//				"Workout at SportCity Houtrust",
//				LocalDateTime.of(2024, 10, 30, 16, 30),
//				LocalDateTime.of(2024, 10, 30, 18, 30),
//				10,
//				"SportCity Houtrust",
//				Exercise.BARBELL_SQUAT
//			);
//			workoutRepository.create(workout);
//		};
//	}

}
