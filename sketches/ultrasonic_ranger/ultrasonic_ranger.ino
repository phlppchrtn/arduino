#include <Ultrasonic.h>
#include <SoftwareSerial.h>

/*
 * 1. Connect Ultrasonic Ranger sensor on D7. 
 * 2. Open Serial Monitor
 *
 * Distance will be displayed in centimeters.
 */
Ultrasonic ultrasonic(7);
void setup()
{
  Serial.begin(9600);
}
void loop()
{
  ultrasonic.MeasureInCentimeters();
  Serial.println("The distance to obstacles in front is: ");
  Serial.print(ultrasonic.RangeInCentimeters);
  Serial.println(" cm");
  delay(100);
}

