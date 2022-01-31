import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostsTest extends BaseTest{
    @Test
    public void getPosts(){
        given()
                .spec(reqSpec)
        .when()
                .get()
        .then()
                .spec(resSpec)
                .assertThat().body("title[0]",equalTo("json-server"))
                .assertThat().body("author[0]",equalTo("typicode"))
        .and()
                .assertThat().body("title[1]",equalTo("Drugi"))
                .assertThat().body("author[1]",equalTo("typicode1"))
        .and()
                .assertThat().body("title[2]",equalTo("Trzeci"))
                .assertThat().body("author[2]",equalTo("typicode2"));
    }
}
