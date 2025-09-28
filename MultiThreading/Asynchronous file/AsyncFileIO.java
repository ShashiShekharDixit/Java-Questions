import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AsyncFileIO {
    public static CompletableFuture<String> readFileAsync(String filePath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Async thread: Starting file read...");
                Thread.sleep(100); 
                String content = Files.lines(Paths.get(filePath)).collect(Collectors.joining("\n"));
                return content;
            } catch (IOException e) {
                throw new RuntimeException("Error reading file: " + filePath, e);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Read interrupted", e);
            }
        });
    }
    public static void main(String[] args) {
        String fileName = "sample.txt";    
        try {
            Files.write(Paths.get(fileName), "Hello Async World!\nThis is line two.".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Main thread: Initiating asynchronous file read for '" + fileName + "'...");
        CompletableFuture<String> futureContent = readFileAsync(fileName);
        CompletableFuture<Integer> futureWordCount = futureContent.thenApply(content -> {
            System.out.println("Callback (thenApply): Calculating word count...");
            return content.split("\\s+").length;
        });
        futureWordCount.thenAccept(wordCount -> {
            System.out.println("Callback (thenAccept): The file contains " + wordCount + " words.");
        });
        futureWordCount.exceptionally(ex -> {
            System.err.println("Callback (exceptionally): Failed to process file! Cause: " + ex.getMessage());
            return -1; 
        });
        System.out.println("Main thread: File read initiated. Continuing with other work...");
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
