package specificationbuilder;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ResponseSpecificationBuilderTest {



    public ResponseSpecification get_res_spec_200_OK(){

        RestAssured.baseURI="https://gorest.co.in/";

//        given()
//                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
//                    .when()
//                        .get("/public/v2/users/6148498")
//                            .then()
//                                .assertThat()
//                                    .statusCode(200)
//                                        .and()
//                                            .contentType(ContentType.JSON)
//                                                .and()
//                                                    .header("Server", "cloudflare");


        ResponseSpecification response = new ResponseSpecBuilder()
                .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                        .expectHeader("Server", "cloudflare")
                            .build();

        return response;

    }

    public ResponseSpecification get_res_spec_401_Fail(){
        ResponseSpecification response = new ResponseSpecBuilder()
                .expectStatusCode(401)
                    .expectContentType(ContentType.JSON)
                        .expectHeader("Server", "cloudflare")
                            .build();

        return response;
    }

    public ResponseSpecification get_res_spec_200_OK_With_Body(){
        ResponseSpecification response = new ResponseSpecBuilder()
                .expectStatusCode(200)
                    .expectContentType(ContentType.JSON)
                        .expectHeader("Server", "cloudflare")
                            .expectBody("$.size()",equalTo(10))
                                .expectBody("id",hasSize(10))
                                    .build();

        return response;
    }

    @Test
    public void get_user_res_spec_Test(){
        RestAssured.baseURI="https://gorest.co.in/";

        given()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                    .when()
                        .get("/public/v2/users/6148498")
                            .then()
                                .assertThat()
                                    .spec(get_res_spec_200_OK());

    }
    @Test
    public void get_user_res_spec_Test_With_401_StatusCode(){

        RestAssured.baseURI="https://gorest.co.in/";

        given().log().all()
//                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .when()
                .get("/public/v2/users")
                .then()
                .assertThat()
                .spec(get_res_spec_401_Fail());

    }

    @Test
    public void get_user_res_spec_WithBodyTest(){
        RestAssured.baseURI="https://gorest.co.in/";

        given()
                .header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .when()
                .get("/public/v2/users")
                .then()
                .assertThat()
                .spec(get_res_spec_200_OK_With_Body());
    }

}
