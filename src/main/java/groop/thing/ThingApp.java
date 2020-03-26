package groop.thing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThingApp {

	public static void main(String[] args) {
		SpringApplication.run(ThingApp.class, args);
		System.out.println();
		System.out.println("sup, dawri!");
	}

}
