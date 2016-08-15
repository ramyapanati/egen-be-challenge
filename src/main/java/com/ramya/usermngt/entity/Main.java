package com.ramya.usermngt.entity;
import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;


public class Main {
	public static void main(String[] args) {

		get("/getAllUsers",
				(req, res) -> {
					return (new UserService(new MongoDBConnect()
							.getConnectionObject()).getAllUsers());
				});

		post("/createUser", (request, response) -> {
			User user = null;
			try {

				Gson gson = new Gson();
				user = gson.fromJson(request.body(), User.class);

				if (UserService.isUserPresent(user.getid()) == true) {

					response.status(400);
					return "Document already present with the given id.";
				} else {
					new UserService(new MongoDBConnect().getConnectionObject())
							.createUser(user);
					return JsonUtil.toJson(user);
				}
			} catch (JsonSyntaxException e) {
				response.status(400);
				return "INVALID JSON";
			}

		});

		post("/updateUser",
				(request, response) -> {
					User user = null;
					try {

						Gson gson = new Gson();
						user = gson.fromJson(request.body(), User.class);

						if (UserService.isUserPresent(user.getid()) == true) {
							new UserService(new MongoDBConnect()
									.getConnectionObject()).updateUser(user);
							return "updated";

						} else {
							response.status(404);
							return "User not found";
						}
					} catch (JsonSyntaxException e) {
						response.status(400);
						return "INVALID JSON";
					}

				});

	}

}
