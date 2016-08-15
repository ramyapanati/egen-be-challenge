package com.ramya.usermngt.entity;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnect {
	MongoClient mongoClient = null;

	public MongoDatabase getConnectionObject() {
		mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("user");
		return db;
	}

}