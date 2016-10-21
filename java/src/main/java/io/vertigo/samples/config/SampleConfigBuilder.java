package io.vertigo.samples.config;

import io.vertigo.app.config.AppConfig;
import io.vertigo.app.config.AppConfigBuilder;
import io.vertigo.commons.impl.CommonsFeatures;
import io.vertigo.samples.components.IOTManager;
import io.vertigo.samples.webservices.IOTWebServices;
import io.vertigo.vega.VegaFeatures;

public class SampleConfigBuilder {
	public AppConfig build() {
		return new AppConfigBuilder()
				.beginModule("IOT")
				.withNoAPI()
				.addComponent(IOTManager.class)
				.addComponent(IOTWebServices.class)
				.endModule()
				.beginModule(CommonsFeatures.class).endModule()
				.beginModule(VegaFeatures.class)
				.withEmbeddedServer(8080)
				.endModule()
				.build();
	}
}
