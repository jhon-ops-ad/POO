// Não pertence a nenhum pacote, é a classe de inicialização
import ui.MenuInterativo;

public class main {
    public static void main(String[] args) {
        // Inicializa o Menu, que gerencia as camadas (model, service, repository)
        MenuInterativo app = new MenuInterativo();
        app.iniciar();
    }
}