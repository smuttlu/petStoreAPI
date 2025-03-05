import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C01_getRequestTest {

    @Test(description = "Belirlenen kullanıcıya ait bilgileri getirir.")
    public void testGetUser() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .when()
                .get("/user/serdar34");

        Assert.assertEquals(response.getStatusCode(), 200);
        response.prettyPrint();
    }

    @Test(description = "Username bilgisinin doğrulu kontrol edilir.")
    public void testCorrectUsernameControl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .when()
                .get("/user/serdar34");

        String username  = response.jsonPath().getString("username");
        Assert.assertEquals(username, "serdar34");

    }

    @Test (description = "Hatalı username kontrolü yapılır.")
    public void testFalseUsernameControl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        Response response = given()
                .when()
                .get("/user/serdar34");

        String username = response.jsonPath().getString("username");
        Assert.assertNotEquals(username, "mutlu");

    }
}
