package com.example.mongo_in_java.driver;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

public class Main {
    public static void main(String[] args) {
        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("japan");
        MongoCollection<Document> collection = database.getCollection("animes");
        // Save
        collection.insertOne(new Document("title", "Нарута")
                .append("сountEpisodes", 500)
                .append("episodes", "Первая серия")
                .append("rating", 8.5));
        collection.insertOne(new Document("title", "ХантерХантер")
                .append("сountEpisodes", 150)
                .append("episodes", "Вторая серия")
                .append("rating", 8.2));
        // Update
        collection.updateOne(lt("countEpisodes", 500), new Document("$set", new Document("countEpisodes", 550)));
        // Delete
        collection.deleteOne(eq("episodes", "Вторая серия"));
    }
}