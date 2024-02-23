package serialization_and_deserialization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserPojo {
    //	{
//	    "name" : "sahil kumar",
//	    "email" : "{{$randomEmail}}",
//	    "gender" : "male",
//	    "status" : "active"
//	}
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;


    public CreateUserPojo(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
}
