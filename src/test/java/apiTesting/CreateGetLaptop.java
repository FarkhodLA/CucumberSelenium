package apiTesting;

import io.cucumber.java.en.*;

import java.util.Map;
import java.util.Random;

import org.json.simple.JSONObject;
//import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import serialization_deserialization.Laptops;
import utilities.ConfigReader;

import static io.restassured.RestAssured.*;
public class CreateGetLaptop {
  
	
	
	 RequestSpecification request;// data type  of request is RequestSpecification
     Response response;// data type of response is Response
	  //  Faker fk;
     String url=ConfigReader.getProperty("urlapi");
     Random ran= new Random();
     int laptopId;
     
		@Given("Content type and Accept type is JSON")
		public void content_type_and_accept_type_is_json() {
		  request= given().header("Content-Type","application/json").
		   accept(ContentType.JSON).and().contentType(ContentType.JSON);
		}

	@When("user posts new Laptop with {string} id")
		public void user_posts_new_laptop_with_id(String id) {
		    if(id.equals("random")) {
		    	laptopId=ran.nextInt(9999);
		    	System.out.println(laptopId);
		    }
		    else {
		    	laptopId=Integer.parseInt(id);
		    }
			JSONObject data=new JSONObject();
		//	fk=new Faker();
			data.put("name","Lenovo");
			data.put("ram", "12GB");
			data.put("price",1233.99);
			data.put("year", 2021);
			data.put("id",laptopId);
			data.put("weight",2.5);
			data.put("os","Windows");
			
			response=request.body(data.toJSONString()).post(url+"/laptops");
	
		}

@Then("user gets the Status Code {int}")
		public void user_gets_the_status_code(int sCode) {
		     int statusCode=response.getStatusCode();
		     Assert.assertEquals(statusCode,sCode);
		}
		@When("user send GET request with {string} id")
		public void user_send_get_request_with_id(String id) {
			if(!id.equals("random")) {
				laptopId=Integer.parseInt(id);
			}
		   response=given().accept(ContentType.JSON).when().get(url+"/laptops/"+laptopId);
		}
		@Then("user gets {int} status code")
		public void user_gets_status_code(int sCode) {
			   int statusCode=response.getStatusCode();
			     Assert.assertEquals(statusCode,sCode);
		}
		@And("laptop data should match while created")
		public void laptop_data_should_match_while_created() {
			
			Laptops lp= response.body().as(Laptops.class);
			String resName=lp.getName();
			String resOs=lp.getOS();
			String resRam=lp.getRAM();
			int resYear=lp.getYear();
			double resWeight=lp.getWeight();
			int resId=lp.getID();

double resPrice=lp.getPrice();
			
			Assert.assertEquals(resName,"Lenovo");
			Assert.assertEquals(resOs,"Windows");
			Assert.assertEquals(resRam,"12GB");
			Assert.assertEquals(resYear,2021);
			Assert.assertEquals(resWeight,2.5);
			Assert.assertEquals(resId,laptopId);
			Assert.assertEquals(resPrice,1233.99);



		}
	
	
}
