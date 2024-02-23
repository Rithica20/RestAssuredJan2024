package serialization_and_deserialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetLombookPojo {
    //	{
//	    "id": 200,
//	    "category": {
//	        "id": 1,
//	        "name": "Dog"
//	    },
//	    "name": "Ronney",
//	    "photoUrls": [
//	        "https://www.dog.com"
//	    ],
//	    "tags": [
//	        {
//	            "id": 10,
//	            "name": "red"
//	        }
//	    ],
//	    "status": "available"
//	}
    private Integer id;
    private Category category;
    private String name;
    private List<String> photorurl;
    private List<Tag> tags;
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Category{
        private Integer id;
        private String name;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tag{
        private Integer id;
        private String name;
    }
}
