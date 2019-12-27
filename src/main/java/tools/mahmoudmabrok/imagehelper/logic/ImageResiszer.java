/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.mahmoudmabrok.imagehelper.logic;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author mo3tamed
 */
public class ImageResiszer {

    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));

    }

    /**
     * Resizes an image by a percentage of original size (proportional).
     *
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath) throws IOException {

        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int currentWidth = (int) (inputImage.getWidth());
        int currentHeight = (int) (inputImage.getHeight());

        boolean heightCondition = currentHeight >= 320 && currentHeight <= 3840;
        boolean widthCondition = currentWidth >= 320 && currentWidth <= 3840;
        boolean ratioStatus = currentHeight > currentWidth * 2 || currentWidth > currentHeight * 2;

        int scale;
        if (heightCondition && widthCondition && !ratioStatus) {
            return;
        } else {
            scale = Math.min(currentHeight, currentWidth);
        }

        resize(inputImagePath, outputImagePath, scale, scale * 2);
    }

}
