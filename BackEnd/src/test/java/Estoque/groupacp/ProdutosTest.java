package Estoque.groupacp;

import Estoque.groupacp.controller.ProdutoController;
import Estoque.groupacp.repository.ProdutoRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ProdutoController.class
})
public class ProdutosTest {

    private final String BASE_URL = "/produtos";

    //Instância do ObjectMapper para trabalhar com JSON
    private ProdutoController produtoController;

    //Controlador REST tratado por meio de injeção de dependências
    @Autowired
    private ProdutoController restController;

    //Instância do MockMVC
    private MockMvc mockMvc;

    //Instância do mock repository
    @MockBean
    private ProdutoRepository mockRepository;

    @Before
    public void setUp() {
        produtoController = new ProdutoController();
        mockMvc = MockMvcBuilders
                .standaloneSetup(restController)
                .build();
    }
}
