import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C06_getLogout {

    @Test(description = "Logout işlemi yapar.")
    public void testUserLogoutControl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/user/logout";
        Response response = given()
                .when()
                .get();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
