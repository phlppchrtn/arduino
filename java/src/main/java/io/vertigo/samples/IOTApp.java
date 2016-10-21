package io.vertigo.samples;

import io.vertigo.app.App;
import io.vertigo.samples.components.IOTManager;
import io.vertigo.samples.config.SampleConfigBuilder;

/***
 * Start the main method.
 *
 * Call "http://localhost:8080/hello" with your web browser.
 * You may receive an "hello world" back.
 *
 *
 *
 * @author pchretien
 */
public class IOTApp {
	public static void main(final String[] args) {

		try (App app = new App(new SampleConfigBuilder().build())) {
			final IOTManager iotManager = app.getComponentSpace().resolve(IOTManager.class);
			iotManager.digitalWrite(2, true);
			System.in.read();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
