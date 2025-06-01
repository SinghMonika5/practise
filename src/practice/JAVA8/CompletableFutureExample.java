package practice.JAVA8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // Fetch data from two different remote APIs asynchronously
        CompletableFuture<String> fetchDataFuture1 = CompletableFuture.supplyAsync(() -> fetchDataFromRemoteAPI("API-1"));
        CompletableFuture<String> fetchDataFuture2 = CompletableFuture.supplyAsync(() -> fetchDataFromRemoteAPI("API-2"));

        // Combine the results from both APIs when they complete
        CompletableFuture<String> combinedDataFuture = fetchDataFuture1.thenCombine(fetchDataFuture2, (data1, data2) -> combineData(data1, data2));

        // Handle the combined result when it's done
        combinedDataFuture.thenAccept(result -> System.out.println("Combined Data: " + result));

        // Wait for the processing to complete (this is a blocking operation)
        try {
            combinedDataFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // Simulate fetching data from a remote API
    private static String fetchDataFromRemoteAPI(String apiName) {
        try {
            // Simulate network delay
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data from " + apiName;
    }

    // Combine the fetched data from both APIs
    private static String combineData(String data1, String data2) {
        return data1 + " and " + data2;
    }
}
