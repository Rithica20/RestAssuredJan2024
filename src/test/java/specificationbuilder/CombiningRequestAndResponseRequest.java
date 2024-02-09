package specificationbuilder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class CombiningRequestAndResponseRequest {

    public RequestSpecification user_req_get_spec() {

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .addHeader("Authorization", "Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .build();
        return requestSpec;
    }

    public RequestSpecification user_req_get_spec_WithQueryParam() {
        RequestSpecification requestspec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/")
                .addQueryParam("name", "rithica")
                .addQueryParam("status", "active")
                .addHeader("Authorization", "Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4")
                .build();
        return requestspec;
    }
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


//given().log().all()
//.header("Authorization","Bearer 53762d62478eb441d3c28098ca0e436747a19f9652dabc4fa32a3b2c7c85752d")
//	.when().log().all()
//		.get("/public/v2/users/6147907")
//			.then().log().all()
//				.assertThat()
//					.statusCode(200)
//						.and()
//							.contentType(ContentType.JSON)
//								.and()
//								 .header("Server", "cloudflare");

    @Test
    public void get_user_request(){
        given()
                .spec(user_req_get_spec())
                .when()
                .get("/public/v2/users")
                .then()
                .spec(get_res_spec_200_OK_With_Body());
    }
}

