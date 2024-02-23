package serialization_and_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.CreateUser;

public class CreateUserTest {

    public static String generateEmail(){
        return "rithica"+ System.currentTimeMillis()+"@gmail.com";
    }

    @Test
    public void createUser(){
        //serialization
        RestAssured.baseURI = "https://gorest.co.in";

        CreateUserPojo user = new CreateUserPojo("rithica",generateEmail(),"female","active");

      int   id = RestAssured.given()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/public/v2/users")
                .then()
                .extract()
                .path("id");

        System.out.println("user id is ::"+id);

        Response response = RestAssured.given()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .when()
                .post("/public/v2/users/"+id);

        response.prettyPrint();

        //deserilazation

        ObjectMapper mapper = new ObjectMapper();

        try {
            CreateUserPojo responseUser = mapper.readValue(response.getBody().asString(), CreateUserPojo.class);

            System.out.println("id:: "+responseUser.getId() + " name:: "+responseUser.getName()+" email"+responseUser.getEmail());

            Assert.assertEquals(id, responseUser.getId());
            Assert.assertEquals(user.getName(), responseUser.getName());
            Assert.assertEquals(user.getGender(), responseUser.getGender());
        }  catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
