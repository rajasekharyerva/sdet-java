package sdet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StockAnomalyDetector {

    // Dummy URLs for the stock APIs (replace with actual API endpoints)
    private static final String REAL_TIME_API_URL = "https://api.example.com/realtime";
    private static final String HISTORICAL_API_URL = "https://api.example.com/historical";

    // Function to fetch real-time stock price
    public static double fetchRealTimePrice(String stockSymbol) throws Exception {
        String url = REAL_TIME_API_URL + "?symbol=" + stockSymbol;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getDouble("price");
    }

    // Function to fetch historical stock prices
    public static List<Double> fetchHistoricalPrices(String stockSymbol, int days) throws Exception {
        String url = HISTORICAL_API_URL + "?symbol=" + stockSymbol + "&days=" + days;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray data = jsonResponse.getJSONArray("data");
        List<Double> prices = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            prices.add(data.getJSONObject(i).getDouble("price"));
        }
        return prices;
    }

    // Function to calculate Z-score
    public static boolean detectAnomaly(double realTimePrice, List<Double> historicalPrices) {
        if (historicalPrices == null || historicalPrices.size() == 0) {
            System.out.println("No historical data available.");
            return false;
        }

        double mean = historicalPrices.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double variance = historicalPrices.stream().mapToDouble(price -> Math.pow(price - mean, 2)).average().orElse(0.0);
        double standardDeviation = Math.sqrt(variance);

        // If standard deviation is 0, avoid division by zero
        if (standardDeviation == 0) {
            System.out.println("Standard deviation is zero, cannot calculate Z-score.");
            return false;
        }

        // Z-score calculation: (X - mean) / standardDeviation
        double zScore = (realTimePrice - mean) / standardDeviation;
        if (Math.abs(zScore) > 2) {  // Threshold for significant deviation (Z-score > 2)
            System.out.println("Anomaly detected! Real-time price: " + realTimePrice + ", Historical mean: " + mean + ", Z-score: " + zScore);
            return true;
        }
        return false;
    }

    // Function to process stock data
    public static void processStockData(String stockSymbol) {
        try {
            // Fetch both real-time and historical data
            double realTimePrice = fetchRealTimePrice(stockSymbol);
            List<Double> historicalPrices = fetchHistoricalPrices(stockSymbol, 30);

            // Detect anomalies in real-time price
            if (detectAnomaly(realTimePrice, historicalPrices)) {
                System.out.println("Anomaly detected for " + stockSymbol + " at price " + realTimePrice);
            }
        } catch (Exception e) {
            System.err.println("Error processing stock data for " + stockSymbol + ": " + e.getMessage());
        }
    }

    // Main method to monitor multiple stocks concurrently
    public static void monitorStocks(List<String> stockSymbols) {
        ExecutorService executorService = Executors.newFixedThreadPool(stockSymbols.size());

        for (String symbol : stockSymbols) {
            executorService.submit(() -> processStockData(symbol));
        }

        // Shutdown the executor service after tasks are completed
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) {
        List<String> stockSymbols = List.of("AAPL", "GOOG", "AMZN");  // List of stock symbols to monitor

        // Monitor the stocks concurrently
        monitorStocks(stockSymbols);
    }
}

