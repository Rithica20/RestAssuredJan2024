package GETAPIs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class GETAPIRequestWithBDD {
    //given() , when() , then() and()


    @Test
    public void getAllProductsTest() {

        RestAssured.baseURI = "https://fakestoreapi.com";

        given().log().all()
                    .when().log().all()
                        .get("/products")
                             .then().log().all()
                                 .assertThat()
                                      .statusCode(200)
                                         .and()
                                            .contentType(ContentType.JSON)
                                                .and()
                                                    .header("Connection", "keep-alive")
                                                      .and()
                                                        .body("$.size()", equalTo(20))
                                                            .and()
                                                                 .body("title", hasItem("Mens Casual Premium Slim Fit T-Shirts "));

    }


    @Test
    public void getAllUserTest() {

        RestAssured.baseURI = "https://gorest.co.in";

        given().log().all()
                .header("Authorization", "Bearer 53762d62478eb441d3c28098ca0e436747a19f9652dabc4fa32a3b2c7c85752d")
                    .when().log().all()
                        .get("/public/v2/users")
                             .then().log().all()
                                 .assertThat()
                                    .statusCode(200)
                                        .and()
                                            .contentType(ContentType.JSON)
                                                .and()
                                                  .header("Connection", "keep-alive")
                                                      .and()
                                                        .body("$.size()", equalTo(20))
                                                            .and()
                                                                .body("title", hasItem("Mens Casual Premium Slim Fit T-Shirts "));

    }




    @Test
    public void getProductWithQueryParam() {

        RestAssured.baseURI = "https://fakestoreapi.com";

        //?limit=5
        given()
                .queryParam("limit", 5)
                    .when()
                        .get("/products")
                            .then().log().all()
                                 .assertThat()
                                    .statusCode(200)
                                        .and()
                                            .contentType(ContentType.JSON)
                                                .and()
                                                    .header("Connection", "keep-alive")
                                                        .and()
                                                            .body("$.size()", equalTo(5));
    }



    @Test
    public void getProductData_With_Extract_Body() {


        RestAssured.baseURI = "https://fakestoreapi.com";

        Response response =  given().log().all()
                .when().log().all()
                .get("/products");


        JsonPath js =  response.jsonPath();

        int firstProductId = js.getInt("[0].id");

        System.out.println("id is:: "+firstProductId);

        String firstProductTitle = js.getString("[0].title");

        System.out.println("title is:: "+firstProductTitle);

        float secondProductPrice =  js.getFloat("[1].price");

        System.out.println("price is :: "+secondProductPrice);

        Assert.assertEquals(secondProductPrice, 22.3);

    }

}
