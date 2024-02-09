package specificationbuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RequestSpecificationTest {

    public RequestSpecification user_req_get_spec(){

        RequestSpecification requestSpec =new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                    .addHeader("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                        .build();
        return requestSpec;
    }

    public RequestSpecification user_req_get_spec_WithQueryParam(){
       RequestSpecification requestspec = new RequestSpecBuilder()
               .setBaseUri("https://gorest.co.in/")
                    .addQueryParam("name","rithica")
                        .addQueryParam("status","active")
                            .addHeader("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                                .build();
       return requestspec;
    }

    @Test
    public void user_req_get(){

//        RestAssured.baseURI="https://gorest.co.in/";
//
//        given()
//                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
//                    .when()
//                         .get("/public/v2/users/6148498")
//                            .then()
//                                .assertThat()
//                                    .statusCode(200)
//                                        .and()
//                                            .contentType(ContentType.JSON);

        given()
                .spec(user_req_get_spec())
                    .when()
                        .get("/public/v2/users/6148498")
                            .then()
                                .assertThat()
                                    .statusCode(200)
                                        .and()
                                            .contentType(ContentType.JSON);
    }
    @Test
    public void user_req_get_withqueryparam(){
        given()
                .spec(user_req_get_spec_WithQueryParam())
                    .when()
                        .get("/public/v2/users/6148498")
                            .then()
                                .assertThat()
                                    .statusCode(200)
                                        .and()
                                            .contentType(ContentType.JSON);
    }
}
