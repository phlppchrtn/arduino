
/*
 * 1. Connect button or touch on D2. 
 * 2. Connect buzzer on D6.
 */

int buttonPin = 2;
int buzzerPin = 6; 

void setup() { 
  pinMode(buttonPin,INPUT);
  pinMode(buzzerPin,OUTPUT);
} 

void loop() { 
  if(digitalRead(buttonPin)){
    digitalWrite(buzzerPin,HIGH);
  } 
  else { 
    digitalWrite(buzzerPin, LOW);
  } 
} 



