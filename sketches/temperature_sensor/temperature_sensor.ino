#include <math.h>

/* 
 * 1. Connect sensor temperature on A0.
 * 2. Open Serial Monitor.
 *
 * Temperature will be displayed. 
*/
int a;
float temperature;
int B=3975;                  //B value of the thermistor
float resistance;

void setup()
{
  Serial.begin(9600);  
}

void loop()
{
  a=analogRead(0);
  resistance=(float)(1023-a)*10000/a; //get the resistance of the sensor;
  temperature=1/(log(resistance/10000)/B+1/298.15)-273.15;//convert to temperature via datasheet ;
  delay(1000);
  Serial.print("Current temperature is ");
  Serial.println(temperature);
 }
