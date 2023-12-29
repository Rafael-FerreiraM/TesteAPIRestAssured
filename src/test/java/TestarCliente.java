import io.restassured.http.ContentType;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestarCliente  {

   private String urlClienteAPI = "localhost:8080";
   private String endpointVerClientes = "/clientes";

   private String endpointCadastrarCliente = "/cliente";

   private String endpointApagarTodosClientes = "/apagaTodos";

   private final String respostaVazia = "{}";

   @Test
   @DisplayName("Quando eu requisitar ver a lista de clientes sem adicionar nada antes, Então ela deve estar vazia")
   public void quandoRequisitarListaClientesSemAdicionar_EntaoDeveEstarVazia(){

       apagaTodosOsClientes();

               given()
                    .contentType(ContentType.JSON)
               .when()
                    .get(urlClienteAPI + endpointVerClientes)
               .then()
                    .statusCode(200)
                    .body(equalTo(respostaVazia));

   }

   @Test
   @DisplayName(" Quando eu fizer uma requisição para cadastrar um novo cliente, Então a resposta da requisição deve ter status 201")
   public void quandoRequisitaroParaCadastrarNovoCliente_EntaoDeveRetornarStatus201(){

       Cliente clienteParaCadastrar = new Cliente();
       clienteParaCadastrar.setNomeCliente("Rafael");
       clienteParaCadastrar.setIdade(21);
       clienteParaCadastrar.setId(20);

               given()
                    .contentType(ContentType.JSON)
                    .body(clienteParaCadastrar)
               .when()
                    .post(urlClienteAPI + endpointCadastrarCliente)
               .then()
                    .statusCode(201)
                    .body("20.nomeCliente", equalTo("Rafael"))
                       .body("20.idade", equalTo(21))
                       .body("20.id", equalTo(20));


   }

@Test
@DisplayName("Quando eu fizer uma requisição para alterar um cliente, Então os dados devem ser alterados")
public void quandoEuRequisitarAlterarCliente_EntaoDadosDevemSerAlterados(){

       Cliente clienteParaAlterar = new Cliente();
       clienteParaAlterar.setNomeCliente("Rafael Ferreira Melo");
       clienteParaAlterar.setIdade(21);
       clienteParaAlterar.setId(21);
       clienteParaAlterar.setRisco(10);

               given()
                       .contentType(ContentType.JSON)
                       .body(clienteParaAlterar)
               .when()
                       .put(urlClienteAPI + endpointCadastrarCliente + "/20")

                       .then()
                       .statusCode(200)
                       .body("21.nomeCliente", equalTo("Rafael Ferreira Melo"))
                       .body("21.idade", equalTo(21))
                       .body("21.id", equalTo(21))
                       .body("21.risco", equalTo(10));

}


   public void apagaTodosOsClientes(){
        String respostaEsperada = "{}";

                given()
                     .contentType(ContentType.JSON)
                .when()
                     .delete(urlClienteAPI + endpointCadastrarCliente + endpointApagarTodosClientes)
                .then()
                     .statusCode(200)
                      .assertThat().body(new IsEqual(respostaEsperada));
    }
}
