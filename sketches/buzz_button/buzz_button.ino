int buttonPin = 7;
int buzzerPin = 2; 

void setup() { 
  pinMode(buttonPin,INPUT);//set button as digital input 
  pinMode(buzzerPin,OUTPUT);//as buzzer as digital output 
} 

void loop() { 
  if(digitalRead(buttonPin)){//check button is pressed or not 
    digitalWrite(buzzerPin,HIGH);//pressed，then buzzer buzzes 
  } 
  else { 
    digitalWrite(buzzerPin, LOW);//not pressed，then buzzer remains silent 
  } 
} 


