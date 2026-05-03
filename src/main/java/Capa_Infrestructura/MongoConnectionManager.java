/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Infrestructura;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author user
 */
public class MongoConnectionManager {   
    private static MongoConnectionManager instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private final String URI = "mongodb://localhost:27017"; 
    private final String DATABASE_NAME = "TickUpDB";

    private MongoConnectionManager() {
        try {
            this.mongoClient = MongoClients.create(URI);
            this.database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("Conexión exitosa a MongoDB: " + DATABASE_NAME);
        } catch (Exception e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
        }
    }
    public static MongoConnectionManager getInstance() {
        if (instance == null) {
            instance = new MongoConnectionManager();
        }
        return instance;
    }
    public MongoDatabase getDatabase() {
        return database;
    }

    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            instance = null;
        }
    }
}