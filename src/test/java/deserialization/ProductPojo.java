package deserialization;

public class ProductPojo {


    //private variables
    //constructor - parameterized and default
    //public getters and setters


//   {
//    "id": 1,
//    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//    "price": 109.95,
//    "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//    "category": "men's clothing",
//    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//    "rating": {
//        "rate": 3.9,
//        "count": 120
//    }
//},

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;


    public ProductPojo(int id, String title, double price, String description, String category, String image, Rating rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }


    public ProductPojo() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public Rating getRating() {
        return rating;
    }


    public void setRating(Rating rating) {
        this.rating = rating;
    }


    //yes we can have a static class inside a java class

    public static class Rating{
        private double rate;
        private int count;

        public Rating() {


        }


        public Rating(double rate, int count) {
            this.rate = rate;
            this.count = count;
        }


        public double getRate() {
            return rate;
        }


        public void setRate(double rate) {
            this.rate = rate;
        }


        public int getCount() {
            return count;
        }


        public void setCount(int count) {
            this.count = count;
        }
    }
}