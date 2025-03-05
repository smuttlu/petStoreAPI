import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C05_deleteUserControl {

    String username = "serdar34";
    String url = "https://petstore.swagger.io/v2/user/";

    @Test(description = "Mevcut kullanıcıyı siler.")
    public void testDeleteUser() {

        Response response = given()
                .when()
                .delete(url + username);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
