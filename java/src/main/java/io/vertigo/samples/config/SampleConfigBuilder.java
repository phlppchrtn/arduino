package io.vertigo.samples.config;

import io.vertigo.app.config.AppConfig;
import io.vertigo.app.config.AppConfigBuilder;
import io.vertigo.app.config.ModuleConfigBuilder;
import io.vertigo.commons.impl.CommonsFeatures;
import io.vertigo.samples.components.IOTManager;
import io.vertigo.samples.webservices.IOTWebServices;
import io.vertigo.vega.VegaFeatures;

public class SampleConfigBuilder {
	public AppConfig build() {
		return new AppConfigBuilder()
				.addModule(new ModuleConfigBuilder("IOT")
						.withNoAPI()
						.addComponent(IOTManager.class)
						.addComponent(IOTWebServices.class)
						.build())
				.addModule(new CommonsFeatures().build())
				.addModule(new VegaFeatures()
						.withEmbeddedServer(8080)
						.build())
				.build();
	}
}
