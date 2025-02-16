package org.bufferedstreams;

import java.io.*;

class BufferedStreams{
    private String source;
    private String destination;

    public BufferedStreams(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    void calculatetime_Using_UnbufferedStreams(String source, String destination){

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("An error occurred with Buffered Streams: " + e.getMessage());
        }
    }

    void calculatetime_Using_bufferedStreams(String source, String destination){

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("An error occurred with Unbuffered Streams: " + e.getMessage());
        }
    }
}

public class EfficientFileCopy {
    public static void main(String[] args) {

        String sourceFile = "1mb.txt";
        String destinationFile = "destination.txt";

        BufferedStreams obj = new BufferedStreams(sourceFile,destinationFile);
        // Ensure the source file exists
        File file = new File(sourceFile);
        if (!file.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        // Copy using Buffered Streams
        long startTimeBuffered = System.nanoTime();
        obj.calculatetime_Using_bufferedStreams(sourceFile, destinationFile);
        long endTimeBuffered = System.nanoTime();
        System.out.println("Time taken with Buffered Streams: " + (endTimeBuffered - startTimeBuffered) / 1_000_000 + " ms");

        // Copy using Unbuffered Streams
        long startTimeUnbuffered = System.nanoTime();
        obj.calculatetime_Using_UnbufferedStreams(sourceFile, destinationFile);
        long endTimeUnbuffered = System.nanoTime();
        System.out.println("Time taken with Unbuffered Streams: " + (endTimeUnbuffered - startTimeUnbuffered) / 1_000_000 + " ms");
    }
    }
