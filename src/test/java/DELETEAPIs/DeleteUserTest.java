package DELETEAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest {
    int id;
//    @BeforeMethod
//    public void createUserId(){
//        //post call before doing delete
//        RestAssured.baseURI="https://gorest.co.in/";
//
//        id = given().log().all()
//                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
//                .contentType(ContentType.JSON)
//                .body(new File("./src/test/resources/data/createuser.json"))
//                .when().log().all()
//                .post("/public/v2/users")
//                .then().log().all()
//                .assertThat()
//                .statusCode(201)
//                .and().log().all()
//                .extract()
//                .path("id");
//
//        System.out.println("the user id is::" +id);
//    }

    @Test

    public void delete_user(){

        RestAssured.baseURI="https://gorest.co.in/";

        id = given().log().all()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .contentType(ContentType.JSON)
                .body(new File("./src/test/resources/data/createuser.json"))
                .when().log().all()
                .post("/public/v2/users")
                .then().log().all()
                .assertThat()
                .statusCode(201)
                .and().log().all()
                .extract()
                .path("id");

        System.out.println("the user id is::" +id);


        //writing get call as delete is not working without get

//        given().log().all()
//                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
//                .when()
//                .get("/public/v2/users/"+id)
//                .then()
//                .assertThat()
//                .statusCode(200);
//                .body("id",equalTo(id))
//                .extract()
//                .path("name");

                given().log().all()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .when()
                .delete("/public/v2/users/"+id)
                .then()
                .assertThat()
                .statusCode(204);
    }


}
