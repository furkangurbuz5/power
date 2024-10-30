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
		logger.info("Automatic build!");


	}

}
