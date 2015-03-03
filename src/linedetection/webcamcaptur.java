/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linedetection;

import com.github.sarxos.webcam.WebcamDevice;
import java.util.List;


/**
 *
 * @author Pars
 */
public class webcamcaptur {

   

    public static void main(String[] args) throws InterruptedException {
        VlcjDriver vlcjDriver = new VlcjDriver();
         List<WebcamDevice> devices = vlcjDriver.getDevices();
        //Webcam webcam = Webcam.getWebcams().get(0);
        //webcam.setViewSize(WebcamResolution.VGA.getSize());

    }

}
