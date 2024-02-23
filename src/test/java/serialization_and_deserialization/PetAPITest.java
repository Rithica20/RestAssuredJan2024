package serialization_and_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetAPITest {
    @Test
    public void createPETAPITest() {

        RestAssured.baseURI = "https://petstore.swagger.io";
        PetLombookPojo.Category category =new PetLombookPojo.Category(20,"black");
        List<String> url = new ArrayList<>();
        url.add("https://johnny.com");
        url.add("https://scooby.com");

        PetLombookPojo.Tag tag1 = new PetLombookPojo.Tag(12, "white");
        PetLombookPojo.Tag tag2 = new PetLombookPojo.Tag(13, "brown");

        List<PetLombookPojo.Tag> tags = Arrays.asList(tag1, tag2);

//        Category category = new Category(1,"Dog");
//        List<String> photoURLs = Arrays.asList("https://www.dog1.com", "https://www.dog2.com");
//        Tag tag1 = new Tag(12, "white");
//        Tag tag2 = new Tag(13, "brown");
//        List<Tag> tags = Arrays.asList(tag1, tag2);

        PetLombookPojo pet = new PetLombookPojo(10,category,"johnny",url,tags,"active");

        //serliazation
        Response response =  RestAssured.given()
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/v2/pet");

        response.prettyPrint();

        //de-serliazation

        ObjectMapper mapper = new ObjectMapper();

        try {
            PetLombookPojo petResponse =	mapper.readValue(response.getBody().asString(), PetLombookPojo.class);

            System.out.println(petResponse.getName() + " " + petResponse.getCategory().getName() + " "+petResponse.getTags() + " "+ petResponse.getPhotorurl());


            Assert.assertEquals(pet.getId(), petResponse.getId());
            Assert.assertEquals(pet.getName(), petResponse.getName());
            Assert.assertEquals(pet.getCategory().getName(), petResponse.getCategory().getName());

        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

