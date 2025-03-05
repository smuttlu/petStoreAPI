import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C04_getLogin {

    @Test(description = "Kullanıcı adı ve şifre ile giriş yapma işlemi yapar.")
    public void testUserLoginTypeControl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        Response response = given()
                .when()
                .get("user/login?username=serdar34&password=password123");

        String type = response.jsonPath().getString("type");
        Assert.assertNotEquals(type, "unknow");

    }

    @Test
    public void testUserLoginControl() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/";
        Response response = given()
                .when()
                .get("user/login?username=serdar34&password=password123");

        String message = response.jsonPath().getString("message");
        Assert.assertNotEquals(message, " ");

    }

}
