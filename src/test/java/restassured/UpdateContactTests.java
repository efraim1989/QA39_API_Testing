package restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.ContactDTO;
import helpers.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class UpdateContactTests implements Helper {

    ContactDTO contactDTO;
    String id;
    String endpoint = "/v1/contacts";

    @BeforeMethod
    public void precondition(){
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";

     contactDTO = ContactDTO.builder()
            .name("QA39")
            .lastName("AUTO")
            .email("QA39_" + i + "@gmail.com")
            .phone("12345678" + i)
            .address("Ashdod")
            .description("Student Test")
            .build();

    String message = given()
                .header(authHeader, token)
                .body(contactDTO)
                .contentType(ContentType.JSON)
                .when()
                .post(endpoint)
                .then()
                .extract()
            .path("message");

    id = message.substring(message.lastIndexOf(" ") + 1);

}

    @Test
    public void updateContactPositive(){

        contactDTO.setId(id);
        contactDTO.setName("QA39_updated");

        given()
                .header(authHeader, token)
                .body(contactDTO)
                .contentType(ContentType.JSON)
                .when()
                .put(endpoint)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("message", containsString("Contact was updated"));




    }




}
