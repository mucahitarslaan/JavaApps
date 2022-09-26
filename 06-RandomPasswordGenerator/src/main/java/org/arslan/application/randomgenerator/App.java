package org.arslan.application.randomgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Application Runner kullanımında sıra kullanım yapılmamalıdır. Initialize sırasında sorun yaşatabilir.
@SpringBootApplication
public class App {

	public static void main(String[] args)
	{
		SpringApplication.run(App.class, args);
	}

}
