package io.vertigo.samples.components;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.zu.ardulink.Link;
import org.zu.ardulink.protocol.IProtocol;
import org.zu.ardulink.protocol.MessageInfo;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import io.vertigo.lang.Activeable;
import io.vertigo.lang.Manager;

public class IOTManager implements Manager, Activeable {
	private final Link link = Link.getDefaultInstance(); // 1

	@Override
	public void start() {
		// Comment this row if you use just the default connection
		//link = getDigisparkConnection();

		final List<String> portList = link.getPortList(); // 2
		if (portList == null || portList.isEmpty()) {
			System.out.println("No port found!");
		}
		final String port = portList.get(5);
		final boolean connected = link.connect(port); // 3
		System.out.println("Connecting on port: " + port);
		System.out.println("Connected:" + connected);
		try {
			Thread.sleep(2000);
		} catch (final InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 4
	}

	@Override
	public void stop() {
		//
	}

	public void digitalWrite(final int pin, final boolean active) throws Exception {
		final MessageInfo messageInfo = link.sendPowerPinSwitch(pin, active ? IProtocol.HIGH : IProtocol.LOW); // 5
		System.out.println("send>>" + messageInfo.getMessageSent());
	}

	//	public int analogRead(final int pin) throws Exception {
	//		final MessageInfo messageInfo = link.startListenAnalogPin(pin);
	//		messageInfo.
	//	}

	//	public boolean digitalRead(final int pin) throws Exception {
	//		final MessageInfo messageInfo = link.startListenAnalogPin(pin)sendPowerPinSwitch(pin, active ? IProtocol.HIGH : IProtocol.LOW); // 5
	//		System.out.println("send>>" + messageInfo.getMessageSent());
	//	}

	//	private static Link getDigisparkConnection() {
	//		final Set<String> protocolNames = ProtocolHandler.getInstalledProtocolImplementationNames();
	//		final SimpleBinaryProtocol protocol = new SimpleBinaryProtocol();
	//		if (!protocolNames.contains(SimpleBinaryProtocol.NAME)) {
	//			ProtocolHandler.installProtocolImplementation(protocol);
	//		}
	//		return Link.createInstance("digisparkConnection", SimpleBinaryProtocol.NAME, new DigisparkUSBConnection("digisparkConnection", protocol.getIncomingMessageDivider()));
	//	}

	public void blink() throws Exception {
		final CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM8");
		System.err.println(portIdentifier.getName());
		if (portIdentifier.isCurrentlyOwned()) {
			throw new RuntimeException("Error: Port is currently in use");

		}
		final CommPort commPort = portIdentifier.open("arduino", 2000);

		if (!(commPort instanceof SerialPort)) {
			throw new RuntimeException("Error: Only serial ports are handled by this example.");
		}

		final SerialPort serialPort = (SerialPort) commPort;
		serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		final InputStream in = serialPort.getInputStream();
		final OutputStream out = serialPort.getOutputStream();
		//
		//				new Thread(new SerialReader(in)).start();
		//				new Thread(new SerialWriter(out)).start();
		Thread.sleep(5000);
		out.write("alp://ppsw/2/1".getBytes());

		//				new Thread(new SerialReader(in)).start();
		//				new Thread(new SerialWriter(out)).start();

		final byte[] buffer = new byte[1024];
		for (final int len = in.read(buffer); len > -1;) {
			System.out.print(new String(buffer, 0, len));
		}

		System.out.println("send >>OK");
	}

	public static class SerialReader implements Runnable {
		InputStream in;

		public SerialReader(final InputStream in) {
			this.in = in;
		}

		@Override
		public void run() {
			final byte[] buffer = new byte[1024];
			int len = -1;
			try {
				while ((len = in.read(buffer)) > -1) {
					System.out.print(new String(buffer, 0, len));
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class SerialWriter implements Runnable {
		OutputStream out;

		public SerialWriter(final OutputStream out) {
			this.out = out;
		}

		@Override
		public void run() {
			try {
				int c = 0;
				while ((c = System.in.read()) > -1) {
					out.write(c);
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}
}
