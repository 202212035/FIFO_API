package com.http;

import java.io.IOException;
//import java.util.Iterator;

import com.fasterxml.jackson.databind.*;


import okhttp3.*;

//import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;


public class gtrqst 
{
	OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder()
		      .url("https://dummyjson.com/posts/1/comments")
		      .build();
	
	public String getrqst() throws IOException 
	{
	  Response response = client.newCall(request).execute();
	  return response.body().string();
	}
	
	public String getbody() throws IOException
	{
		Response response = client.newCall(request).execute();
		String jsonResponse = response.body().string();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonResponse);
		

		String body = jsonNode.get("comments").get(0).get("body").asText();
		System.out.println("\t body : "+body);
		String body1 = jsonNode.get("comments").get(0).get("postId").asText();
		System.out.println("\t postId : "+body1);

		return "\n\n\n";
	}
	
	public void postbody() throws IOException
	{
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\n  \"vehicle_num\": \"ts9ua\",\n  \"ip_address\": \"192.168.1.25\",\n  \"terminal_id\": 56,\n  \"barcode_num\": \"OPIN000000000124\",\n  \"user_id\": 25,\n  \"shift_id\": 4,\n  \"advance_amt\": 60,\n  \"is_member\": \"\",\n  \"fastag_id\": \"34161FA820328EE80F2272A0\",\n  \"smart_card_num\": \"\",\n  \"squre_tag_num\": \"\",\n  \"round_tag_id\": \"\",\n  \"anpr_id_in\": \"\",\n  \"in_time\": \"2023-06-12 12:54:00\",\n  \"vehicle_category_id\": 5,\n  \"boom_barrier_mode\": \"Open\",\n  \"payment_mode\": \"Cash\",\n  \"personhead_count\": \"\",\n  \"Gate_in_id\": 1,\n  \"in_remarks\": \"Testing\",\n  \"fastag_TID\": \"34161FA820328EE80F2272A0\",\n  \"mapper_class\": \"\",\n  \"issuer_BankId\": \"\",\n  \"exc_code\": \"\"\n}");
		Request request = new Request.Builder()
				  .url("https://admin.prepaidautotaxi.com/public/api/merchant/driver-in")
				  .method("POST", body)
				  .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIyOTMiLCJqdGkiOiIwZDE3ODc5MjBlNWVlMjNkNDM2MTg3NDRhMWU3YWVmMWVlNjJjMDVlYzc4NzNhMTg2ZDhmZGJhYTNjYmE5NWVhMmY3YjkzMzFjMDQ4YjE3YyIsImlhdCI6MTY4NzE5MjUzNCwibmJmIjoxNjg3MTkyNTM0LCJleHAiOjE3MTg4MTQ5MzQsInN1YiI6IjQ5NCIsInNjb3BlcyI6W119.hArwItJC9jRsBlCCo-fiqDhiHReKJt02iMMT3L8Zf0Ih67rUhP0J2kh1aCk6QzRvT6_Jpoc9l3x4SqsE0Z6Kgg")
				  .addHeader("Content-Type", "application/json")
				  .addHeader("Cookie", "multiservice_session=4hJO8VnND7HQlnyjgn4LaN3gk2z0MDtjUWXjy5M1")
				  .build();
		Response response = client.newCall(request).execute();


		String jsonResponse = response.body().string();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonResponse);
		

		String body2 = jsonNode.get("message").asText();
		System.out.println("\t MESSAGE : "+body2+"\n\n\n");
	}
}