package petstore.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import petstore.models.pet.Category;
import petstore.models.pet.Pet;

public class GetPetTest404 {
    @Test
    public void testDelPet404() {
        long testID = 1245674346;

        Pet request = new Pet();
        request.setId(testID);
        Category category = new Category();
        category.setId(2);
        category.setName("Panda");
        request.setCategory(category);
        request.setName("Tuzik");
        request.setStatus("pending");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(request)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);

        RestAssured.given()
                .delete("https://petstore.swagger.io/v2/pet/" + testID)
                .then()
                .statusCode(200);

        RestAssured.given()
                .get("https://petstore.swagger.io/v2/pet/" + testID)
                .then()
                .statusCode(404);

    }
}
