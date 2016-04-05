package com.test.client;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.test.model.User;

public class TestHelloClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Client client = Client.create();
			WebResource webResource = client
			   .resource("http://localhost:8080/RestfulWsJerssy/rest/hello/");
			ClientResponse response = webResource.accept("text/plain")
	                   .post(ClientResponse.class);
			System.out.println("Response: "+response);
			ClientResponse response3 = webResource.accept("text/plain")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			WebResource webResource2 = client
					   .resource("http://localhost:8080/RestfulWsJerssy/rest/UserService/users");
			GenericType<List<User>> list = new GenericType<List<User>>() {};
			List<User> users =webResource2.accept("application/xml")
	                   .get(list);
			for(User u:users){
			System.out.println(u.getId());
			System.out.println(u.getName());	
			}
		  } catch (Exception e) {

			e.printStackTrace();

		  }
	}

}
