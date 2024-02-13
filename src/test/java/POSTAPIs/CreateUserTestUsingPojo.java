package POSTAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojo.CreateUser;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTestUsingPojo {
    int id;

    public static String generateEmaiId(){
        return "apiautomation"+System.currentTimeMillis()+"@gmail.com";
    }
    @BeforeMethod
    public void createUserId(){
        RestAssured.baseURI="https://gorest.co.in/";

        CreateUser user = new CreateUser("rithica", generateEmaiId(),"female", "active");

        id = given().log().all()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .contentType(ContentType.JSON)
                .body(user)
                .when().log().all()
                .post("/public/v2/users")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .and()
                .extract()
                .path("id");

        System.out.println("the user id is::" +id);
    }

    @Test
    public void create_user(){
        //get call

        String name = given().log().all()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .when()
                .get("/public/v2/users/"+id)
                .then()
                .assertThat()
                .statusCode(200)
                .body("id",equalTo(id))
                .extract()
                .path("name");

        System.out.println("name is"+name);
        Assert.assertEquals(name,"rithica");
    }
}
