package dev.gurbuz.power;

import dev.gurbuz.power.workout.Exercise;
import dev.gurbuz.power.workout.Workout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class PowerApplication {

	private static final Logger logger = LoggerFactory.getLogger(PowerApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(PowerApplication.class, args);

	}

	//creating a mock Workout
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Workout workout = new Workout(
				1,
				"Workout at SportCity Houtrust",
				LocalDateTime.of(2024, 10, 30, 16, 30),
				LocalDateTime.of(2024, 10, 30, 18, 30),
				10,
				"SportCity Houtrust",
				Exercise.BARBELL_SQUAT
			);
			logger.info(workout.toString());
		};
	}
}
