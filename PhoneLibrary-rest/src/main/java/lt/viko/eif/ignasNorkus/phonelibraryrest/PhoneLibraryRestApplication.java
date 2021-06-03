package lt.viko.eif.ignasNorkus.phonelibraryrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Application that launches phoneLibrary rest services
 * using SpringBootApplication
 * and Swagger2 to enable testing
 */
@SpringBootApplication
@EnableSwagger2
public class PhoneLibraryRestApplication {

	/**
	 * Starts the app
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PhoneLibraryRestApplication.class, args);
	}

	/**
	 * Does something about swagger2
	 * @return The Discovered Of The Links
	 */
	@Primary
	@Bean
	public LinkDiscoverers discoverers() {
		List<LinkDiscoverer> plugins = new ArrayList<>();
		plugins.add(new CollectionJsonLinkDiscoverer());
		return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
	}

	/**
	 * Does something about swagger2
	 * @return Something That Is In Docker
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("lt.viko.eif.ignasNorkus.phonelibraryrest")).build();
	}
}
