import model.Post;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PatchPostTest extends BaseTest {
@Test
public void updateTitle(){
    Post post=new Post("aktualizacja");
    Post createdPost=
            given()
                    .spec(reqSpec)
                    .pathParam("postId",5)
                    .body(post)
            .when()
                    .patch("{postId}")
            .then()
                    .spec(resSpec)
                    .extract().body().as(Post.class);
    assertEquals(createdPost.getTitle(),"aktualizacja");
    assertEquals(createdPost.getAuthor(),"postman");


}
}

