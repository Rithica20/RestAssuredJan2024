package deserialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPojoWithLombok {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Rating{
        private double rate;
        private int count;
    }

}
