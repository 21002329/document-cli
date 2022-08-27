package de.europace.documentcli;

import de.europace.documentcli.client.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ClientConfig.class)
public class DocumentCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocumentCliApplication.class, args);
	}

}
