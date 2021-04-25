package petstore.put;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import petstore.models.pet.Category;
import petstore.models.pet.Pet;

public class PutPetTest404 {
    @Test
    public void testAddPet() {
        long testID = 1245674346;

        Pet request = new Pet();
        request.setId(testID);
        Category category = new Category();
        category.setId(2);
        category.setName("Panda");
        request.setCategory(category);
        request.setName("Tuzik");
        request.setStatus("pending");

        Pet requestPut = new Pet();
        requestPut.setId(testID);
        Category categoryPut = new Category();
        categoryPut.setId(2);
        categoryPut.setName("Panda2");
        requestPut.setCategory(categoryPut);
        requestPut.setName("Tuzik2");
        requestPut.setStatus("pending");

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
                .contentType(ContentType.JSON)
                .body(requestPut)
                .put("https://petstore.swagger.io/v2/pet/")
                .then()
                .statusCode(404);

    }

}
