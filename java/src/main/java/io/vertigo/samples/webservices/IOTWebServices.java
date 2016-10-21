package io.vertigo.samples.webservices;

import io.vertigo.samples.components.IOTManager;
import io.vertigo.vega.webservice.WebServices;
import io.vertigo.vega.webservice.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.webservice.stereotype.GET;
import io.vertigo.vega.webservice.stereotype.PathParam;

import javax.inject.Inject;

public final class IOTWebServices implements WebServices {
	@Inject
	private IOTManager iotManager;

	@AnonymousAccessAllowed
	@GET("/{pin}/on")
	public String switchOn(final @PathParam("pin") int pin) throws Exception {
		//code 200
		iotManager.digitalWrite(pin, true);
		return "OK";
	}

	@AnonymousAccessAllowed
	@GET("/{pin}/off")
	public String switchOff(final @PathParam("pin") int pin) throws Exception {
		//code 200
		iotManager.digitalWrite(pin, false);
		return "OK";
	}

	@AnonymousAccessAllowed
	@GET("/{pin}/blink")
	public String blink(final @PathParam("pin") int pin) throws Exception {
		//code 200
		for (int i = 0; i < 10; i++) {
			iotManager.digitalWrite(pin, true);
			Thread.sleep(300);
			iotManager.digitalWrite(pin, false);
			Thread.sleep(300);
		}
		return "OK";
	}
}
