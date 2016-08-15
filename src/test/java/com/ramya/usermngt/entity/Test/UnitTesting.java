package com.ramya.usermngt.entity.Test;

import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ramya.usermngt.entity.User;

import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import spark.Spark;
import spark.utils.IOUtils;

import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitTesting {

	String message = "Hello World";

	@Test
	public void getAlluserUnitTest() {
		TestResponse res = request("GET",
				"/getAllUsers");
				
	}
	
	private TestResponse request(String method, String path) {
		try {
			URL url = new URL("http://localhost:4567" + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}
	
	private static class TestResponse {

		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}

		public Map<String,String> json() {
			Gson gson = new Gson();
			User user = gson.fromJson(body, User.class);
			return new Gson().fromJson(body, HashMap.class);
		}
	}
}