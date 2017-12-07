/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyingjoy.test.joyconapi;

import java.util.Map;
import org.joyconLib.Joycon;
import org.joyconLib.JoyconConstant;
import org.joyconLib.JoyconEvent;
import org.joyconLib.JoyconListener;

/**
 *
 * @author renardn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Joycon joycon = new Joycon(); 
        joycon.setListener(new JoyconListener() {
            @Override
            public void handleNewInput(JoyconEvent je) {
                for (Map.Entry<String, Boolean> entry : je.getNewInputs().entrySet()) {
                    System.out.print("Button: "+entry.getKey()+" is "+(entry.getValue()?"ON \t":"OFF\t"));
                    if (entry.getKey().equals(JoyconConstant.CAPTURE) || entry.getKey().equals(JoyconConstant.HOME)) {
                        System.exit(0);
                    }
                }
                System.out.println("Joystick: "+je.getJoystick());
            }
        });
    }
    
}
