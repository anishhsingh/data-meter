package com.datameter;  // Declares the package this class belongs to

// Imports required classes from other packages
import com.datameter.processor.FileProcessor;
import com.datameter.utils.ConfigLoader;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Check if directory path is provided as a command-line argument
        if (args.length < 1) {
            System.out.println("Usage: java Main <directory_path>");
            System.exit(1);  // Exit the program if no argument is provided
        }

        String directoryPath = args[0];  // Get the directory path from arguments

        try {
            // Load configurations (possibly from config.properties or similar)
            ConfigLoader.loadConfig();

            // Create a FileProcessor object to handle usage log processing
            FileProcessor processor = new FileProcessor();

            // Process all files in the given directory and get summarized usage data
            Map<String, com.datameter.model.UsageSummary> results = 
                processor.processDirectory(new File(directoryPath));

            // Print the summary results to console or logs
            processor.printResults(results);
        } catch (Exception e) {
            // Print any error that occurs during processing
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();  // Print full stack trace for debugging
        }
    }
}
