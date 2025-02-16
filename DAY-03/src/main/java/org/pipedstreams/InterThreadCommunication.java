package org.pipedstreams;

import java.io.*;
public class InterThreadCommunication {
        public static void main(String[] args) {
            try {
                // Create the PipedOutputStream and PipedInputStream
                PipedOutputStream pipedOutputStream = new PipedOutputStream();
                PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

                // Create and start the writer thread
                Thread writerThread = new Thread(new WriterTask(pipedOutputStream));
                writerThread.start();

                // Create and start the reader thread
                Thread readerThread = new Thread(new ReaderTask(pipedInputStream));
                readerThread.start();
            } catch (IOException e) {
                System.err.println("Error setting up piped streams: " + e.getMessage());
            }
        }
    }

    // Task for writing data to the PipedOutputStream
    class WriterTask implements Runnable {
        private PipedOutputStream pipedOutputStream;

        public WriterTask(PipedOutputStream pipedOutputStream) {
            this.pipedOutputStream = pipedOutputStream;
        }

        @Override
        public void run() {
            try (DataOutputStream dataOutputStream = new DataOutputStream(pipedOutputStream)) {
                // Write some data to the stream
                String[] messages = {"Hello", "World", "Piped", "Streams", "Example"};
                for (String message : messages) {
                    dataOutputStream.writeUTF(message); // Write a string
                    System.out.println("Writer Thread: Sent - " + message);
                    Thread.sleep(500); // Simulate some delay
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("Writer Thread Error: " + e.getMessage());
            }
        }
    }

    // Task for reading data from the PipedInputStream
    class ReaderTask implements Runnable {
        private PipedInputStream pipedInputStream;

        public ReaderTask(PipedInputStream pipedInputStream) {
            this.pipedInputStream = pipedInputStream;
        }

        @Override
        public void run() {
            try (DataInputStream dataInputStream = new DataInputStream(pipedInputStream)) {
                // Read data from the stream
                while (true) {
                    String message = dataInputStream.readUTF(); // Read a string
                    System.out.println("Reader Thread: Received - " + message);
                }
            } catch (IOException e) {
                System.err.println("Reader Thread Error: " + e.getMessage());
            }
        }
    }
