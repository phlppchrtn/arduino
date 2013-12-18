/*
 * Switch 2 leds.
 * 1. Connect LEDs on D3, D4.
 */
 
int led_1 = 3;
int led_2 = 4;

void setup() {                
  pinMode(led_1, OUTPUT);     
  pinMode(led_2, OUTPUT);     
}

void loop() {
  delay(300);               
  digitalWrite(led_1, HIGH);  
  digitalWrite(led_2, LOW);   
  delay(300);               
  digitalWrite(led_1, LOW);  
  digitalWrite(led_2, HIGH);   
}
