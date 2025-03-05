import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class C02_postCreateUser {

    @Test(description = "Yeni kullanıcı oluşturur.")
    public void testCreateUser() {

        String url = "https://petstore.swagger.io/v2/user";
        JSONObject user = new JSONObject();

        user.put("id", "23");
        user.put("username", "serdar34");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("email", "testuser@example.com");
        user.put("password", "password123");
        user.put("phone", "123456789");
        user.put("userStatus", 0);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(user.toString())
                .when()
                .post(url);

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(description = "Hatalı tanımlama kontrolü yapar.")
    public void testUnsupoortedMediaTypeErrorCodeControl() {

        String url = "https://petstore.swagger.io/v2/user";

        JSONObject user = new JSONObject();

        user.put("id", "23");
        user.put("username", "serdar34");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("email", "testuser@example.com");
        user.put("password", "password123");
        user.put("phone", "123456789");
        user.put("userStatus", 0);

        Response response = given()
                .body(user.toString())
                .when()
                .post(url);
        Assert.assertEquals(response.getStatusCode(), 415);
    }

    @Test(description = "Oluşturulan kullanıcıyı ID bilgisi ile kontrol eder.")
    public void testIdControlCreateUser() {

        String url = "https://petstore.swagger.io/v2/user";

        JSONObject user = new JSONObject();

        user.put("id", "23");
        user.put("username", "serdar34");
        user.put("firstName", "Test");
        user.put("lastName", "User");
        user.put("email", "testuser@example.com");
        user.put("password", "password123");
        user.put("phone", "123456789");
        user.put("userStatus", 0);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(user.toString())
                .when()
                .post(url);
        int messageValue = response.jsonPath().getInt("message");
        Assert.assertEquals(messageValue, 23);
    }
}
