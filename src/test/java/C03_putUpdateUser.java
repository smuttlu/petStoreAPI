import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;

public class C03_putUpdateUser {

    @Test(description = "Mevcut kullanıcıya ait bilgileri günceller.")
    public void put01() {

        String url="https://petstore.swagger.io/v2/user";

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


}
