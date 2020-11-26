package group14.gestionnaire_livres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("controller")
@EntityScan("model")
@EnableJpaRepositories("dao")
public class GestionnaireLivresApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnaireLivresApplication.class, args);
	}

}
