package GETAPIs;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GETAPICallsAPITest {

    @Test
    public void getAllUsersAPITest(){
        //request

        //base url
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification request = RestAssured.given(); //this will trigger the url

        request.header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4");

        //service url
        Response response = request.get("/public/v2/users");

        //response part

        //status code
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode,200);

        //status msg
        String statusMsg = response.statusLine();
        System.out.println(statusMsg);

        Assert.assertEquals(statusMsg,"HTTP/1.1 200 OK");

        //To print line by line
        response.prettyPrint();

        //To print response header content type
        System.out.println("The content type is "+response.header("Content-Type"));

        //To print all headers

        List<Header> allHeaders = response.headers().asList();
        System.out.println("The total count of all headers is:: "+allHeaders.size());

        for (Header h: allHeaders){
            System.out.println(h);
//            System.out.println(h.getName() + ":" + h.getValue());
        }

    }

    @Test
    public void getAllUsersAPITestWithQueryParams(){
        //request

        //url
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification request = RestAssured.given();

        request.header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4");
        request.queryParam("name","rithica");
        request.queryParam("status","active");

        //service url
        //	Response response = request.get("https://gorest.co.in/public/v2/users?name=rithica&status=active");
        Response response = request.get("/public/v2/users");

        //response part

        //status code
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode,200);

        //status msg
        String statusMsg = response.statusLine();
        System.out.println(statusMsg);

        Assert.assertEquals(statusMsg,"HTTP/1.1 200 OK");

        //To print line by line
        response.prettyPrint();

        //To print response header content type
        System.out.println("The content type is "+response.header("Content-Type"));

        //To print all headers

        List<Header> allHeaders = response.headers().asList();
        System.out.println("The total count of all headers is:: "+allHeaders.size());

        for (Header h: allHeaders){
            System.out.println(h);
//            System.out.println(h.getName() + ":" + h.getValue());
        }

    }

    @Test
    public void getAllUsersAPITestWithQueryParams_WithHashMap(){
        //base url
        RestAssured.baseURI = "https://gorest.co.in";
        RequestSpecification request = RestAssured.given();

        request.header("Authorization","Bearer 1f99558079902d51dd2c7e9ea67f4859509b01c2892b82d5ea6a9cf4fe07d0d4");

        Map<String,String> queryParam = new HashMap<>();
        queryParam.put("name","rithica");
        queryParam.put("status","active");

        request.queryParams(queryParam);

        //service url
        Response response = request.get("/public/v2/users");


        //response part

        //status code
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode,200);

        //status msg
        String statusMsg = response.statusLine();
        System.out.println(statusMsg);

        Assert.assertEquals(statusMsg,"HTTP/1.1 200 OK");

        //To print line by line
        response.prettyPrint();

        //To print response header content type
        System.out.println("The content type is "+response.header("Content-Type"));

        //To print all headers

        List<Header> allHeaders = response.headers().asList();
        System.out.println("The total count of all headers is:: "+allHeaders.size());

        for (Header h: allHeaders){
            System.out.println(h);
//            System.out.println(h.getName() + ":" + h.getValue());
        }
    }
}
