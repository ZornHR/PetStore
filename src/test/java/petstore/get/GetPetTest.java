package petstore.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import petstore.models.pet.Category;
import petstore.models.pet.Pet;

public class GetPetTest {

    @Test
    public void testGetPet() {
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

        Pet response = RestAssured.given()
                .get("https://petstore.swagger.io/v2/pet/" + testID)
                .then()
                .statusCode(200)
                .extract()
                .as(Pet.class);
        Assertions.assertEquals(request, response);
    }
}
