package org.bytearraystreams;

import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String inputImagePath = "src/main/java/org/bytearraystreams/IMG_20241025_145505685_HDR.jpg"; // Path to the original image
        String outputImagePath = "src/main/java/org/bytearraystreams/Output.jpg"; // Path to save the new image

        try {
            // Step 1: Convert the image to a byte array
            byte[] imageBytes = convertImageToByteArray(inputImagePath);

            // Step 2: Write the byte array back to a new image file
            writeByteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image successfully converted and saved to " + outputImagePath);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to convert an image file to a byte array
    private static byte[] convertImageToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray(); // Return the byte array
        }
    }

    // Method to write a byte array to an image file
    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
