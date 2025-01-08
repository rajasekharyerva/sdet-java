package database;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.Collections;

public class MongoDBConnectionExample {
    public static void main(String[] args) {
        // Example credentials
        String username = "testUser"; // Replace with your MongoDB username
        char[] password = "testPassword".toCharArray(); // Replace with your MongoDB password
        String databaseName = "testDB"; // Replace with your MongoDB database name
        String host = "localhost";
        int port = 27017;

        // Option 1: Connection string with credentials
        String connectionString = String.format("mongodb://%s:%s@%s:%d", username, password, host, port);
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            System.out.println("Connected using connection string!");
            // Perform your database operations here
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Option 2: Using MongoCredential for secure authentication
        ServerAddress serverAddress = new ServerAddress(host, port);
        MongoCredential credential = MongoCredential.createCredential(username, databaseName, password);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder -> builder.hosts(Collections.singletonList(serverAddress)))
                .credential(credential)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            System.out.println("Connected using MongoCredential!");
            // Perform your database operations here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

