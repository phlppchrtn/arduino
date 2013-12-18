/*
 * Blink led
 * 1. Connect LED on D3.
 */
 
int led = 3;

void setup() {                
  pinMode(led, OUTPUT);     
}

void loop() {
  delay(300);               
  digitalWrite(led, HIGH);  
  delay(300);               
  digitalWrite(led, LOW);  
}
