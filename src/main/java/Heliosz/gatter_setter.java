package Heliosz;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import POJO_class.Responce;
@JsonIgnoreProperties(ignoreUnknown = true)
public class gatter_setter {

	public static void main(String[] args) {
	
		//expect().defaultParser(Parser.JSON)// if response payload apart from json we need use this method
		//And api header does not conatins application/json header then we go for this method
		
		RestAssured.baseURI="http://192.168.2.38/api/master/getcategory";
		
		Responce gd = given().contentType("application/json").when().log().all().get(baseURI).as(Responce.class);
       /* System.out.println(gd);
		System.out.println(gd.get_isSucceed());
		System.out.println(gd.get_msg());*/
	}

}
