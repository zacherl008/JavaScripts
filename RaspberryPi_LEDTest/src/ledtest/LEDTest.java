/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ledtest;

import java.io.IOException;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;

/**
 *
 * @author kzacherl
 */
public class LEDTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput led = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        
        for(int i = 0; i < 10; i++){
            led.setState(true);
            Gpio.delay(500);
            led.setState(false);
            Gpio.delay(500);
        }
        gpio.shutdown();
    }  
}
