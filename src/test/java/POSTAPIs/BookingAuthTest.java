package POSTAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BookingAuthTest {

    @Test
    public void post_req_BookingAuthTokenTest(){

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

       String tokenID=  given().log().all()
                .contentType(ContentType.JSON)
                .body("{"
                        + "    \"username\"  : \"admin\","
                        + "    \"password\" : \"password123\""
                        + "}")

                .when().log().all()
                .post("/auth")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("token");

        System.out.println(tokenID);
    }

    @Test
    public void post_req_BookingAuthTokenTest_WithJSONFile(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";

        String tokenID = given().log().all()
                .body(new File("./src/test/resources/data/basicauth.json"))
                    .when().log().all()
                        .contentType(ContentType.JSON)
                            .post("/auth")
                                .then().log().all()
                                    .assertThat()
                                        .statusCode(200)
                                            .and().log().all()
                                                .statusLine("HTTP/1.1 200 OK")
                                                    .extract()
                                                        .path("token");

        System.out.println(tokenID);
        Assert.assertNotNull(tokenID);
    }
}
