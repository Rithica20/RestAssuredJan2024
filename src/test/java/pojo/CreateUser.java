package pojo;

public class CreateUser {
    // POJO - Plain Old Java Object
    // can not be inhertited
    //Encapsulation
    //private variables
    // through public methods
    // setter getters

    //Step 1: We will create a POJO class
    // Step 2: We wil intialize variabbles of POJO class
    //Step 3: We will use the reference of pojo class in POST api body


    //serliazation - to convert java object(POJO) to other format :: json, media, json/xml, text, pdf etc
    //pojo to json - serliazation
    //json to pojo class - De-serliazation
    // add jackson dependency for serliazation


    //1. to paste the json object
    //2. to have json resource file
    //3 to have a pojo class object

//    {
//        "id": 6222248,
//            "name": "Rithica",
//            "email": "Devante.Hilpert94@hotmail.com",
//            "gender": "female",
//            "status": "active"

    private String name;
    private String email;
    private String gender;
    private String status;

    public CreateUser(String name, String email, String gender, String status){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
