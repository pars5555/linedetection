/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linedetection;

import ij.IJ;
import ij.ImagePlus;
import ij.measure.ResultsTable;
import ij.plugin.filter.ParticleAnalyzer;
import ij.process.ByteProcessor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Pars
 */
public class Linedetection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String filePath = Linedetection.class.getResource("resources/1.jpg").getPath();
        File f = new File(filePath);
        ImagePlus image = new ImagePlus(f.getAbsolutePath());
        ResultsTable rt = new ResultsTable();
        // Make the Image 8 bit
        IJ.run(image, "8-bit", "");

        // Apply a Threshold (0 - 50)
        ByteProcessor tempBP = (ByteProcessor) image.getProcessor();
        tempBP.setThreshold(0, 50, 0);
        IJ.run(image, "Convert to Mask", "");

        File outputfile = new File("image.jpg");
        ImageIO.write(image.getBufferedImage(), "jpg", outputfile);
        // Analyze the Particles
        ParticleAnalyzer pa = new ParticleAnalyzer(
                ParticleAnalyzer.SHOW_MASKS
                + ParticleAnalyzer.IN_SITU_SHOW,
                1023
                + ParticleAnalyzer.ELLIPSE,rt, 0.0, 999999999, 0, 0.5);

        IJ.run(image, "Set Measurements...", "bounding fit redirect=None decimal=3");

        pa.analyze(image);

        int k = 0;
        double maxSize = -1;
        for (int i = 0; i < rt.getCounter(); i++) {
         // Determine creteria for best oval.
            // The major axis should be much longer than the minor axis.
            // let k = best oval
        }
        double bx = rt.getValue("BX", k);
        double by = rt.getValue("BY", k);
        double width = rt.getValue("Width", k);
        double height = rt.getValue("Height", k);

        // Your angle:
        double angle = rt.getValue("Angle", k);
        double majorAxis = rt.getValue("Major", k);
        double minorAxis = rt.getValue("Minor", k);
        System.err.println(angle);
        System.err.println(width);
        System.err.println(height);
        System.err.println(majorAxis);
        System.err.println(minorAxis);
      
    }

}
