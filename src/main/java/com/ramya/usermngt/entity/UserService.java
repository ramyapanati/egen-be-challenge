package com.ramya.usermngt.entity;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserService {

	private MongoCollection<Document> collection;

	public UserService(MongoDatabase db) {
		this.collection = db.getCollection("todos");
	}

	public String getAllUsers() {
		String s = "";
		for (Document doc : this.collection.find())
			s = s.concat(new Gson().toJson(doc).toString());
		return s;
	}

	public User createUser(User user) {
		this.collection.insertOne(new Document(toDBObject(user)));
		return user;
	}

	public Document toDBObject(User user) {

		Document bdbobj = new Document("id", user.getid())
				.append("firstname", user.getfirstName())
				.append("lastname", user.getlastName())
				.append("email", user.getemail())
				.append("dateCreated", user.getDate())
				.append("profilePic", user.getprofilepic())
				.append("address",
						new BasicDBObject("street", user.getAddress()
								.getstreet())
								.append("city", user.getAddress().getcity())
								.append("state", user.getAddress().getstate())
								.append("zip", user.getAddress().getzip())
								.append("country",
										user.getAddress().getcountry())
								)

								.append("company",
										new BasicDBObject("name", user
												.getCompany().getname())
												.append("website",
														user.getCompany()
																.getwebsite())
												);

		return bdbobj;
	}

	public String updateUser(User user) {
		Document filter = new Document("id", user.getid().toString());
		Document newValue = new Document("city", user.getAddress().getcity())
				.append("state", user.getAddress().getstate());

		Document updateOperationDocument = new Document("$set", newValue);
		this.collection.updateOne(filter, updateOperationDocument);
		return "update";
	}

	public static boolean isUserPresent(String id) {
		MongoDatabase db = new MongoDBConnect().getConnectionObject();
		Document doc = db.getCollection("todos").find(new Document("id", id))
				.first();
		if (doc == null)
			return false;
		else
			return true;
	}

}
