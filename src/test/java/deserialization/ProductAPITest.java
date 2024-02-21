package deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.restassured.RestAssured;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ProductAPITest {
    //Deserialzation
    @Test
    public void productTest() {

        RestAssured.baseURI = "https://fakestoreapi.com";

        Response response = given()
                .when()
                .get("/products");

        //json to pojo

        ObjectMapper mapper = new ObjectMapper();

        try {
            ProductPojo[] product = mapper.readValue(response.getBody().asString(), ProductPojo[].class);

            for (ProductPojo p : product) {
                System.out.println("ID:: " + p.getId());
                System.out.println("Title:: " + p.getTitle());
                System.out.println("Price:: " + p.getPrice());
                System.out.println("Description:: " + p.getDescription());
                System.out.println("Category:: " + p.getCategory());
                System.out.println("Image:: " + p.getImage());
                System.out.println("Rating Rate:: " + p.getRating().getRate());
                System.out.println("Count Rate:: " + p.getRating().getCount());

                System.out.println("------------------------------------");
            }
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}