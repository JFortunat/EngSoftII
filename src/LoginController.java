
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {
    private TelaLogin view;

    public LoginController(TelaLogin view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        String login = view.getCxLogin().getText();
        String senha = view.getCxSenha().getText();

        Usuario usuarioAutenticar = new Usuario(login, senha);
        
        Connection conexao = new Conexao().getConnection();
        UsuarioBanco usuariobanco = new UsuarioBanco(conexao);
        
        boolean existe = usuariobanco.autenticarUsuario(usuarioAutenticar);
        
        if(existe){
            Validador frame = new Validador();
            frame.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");
        }
        
        
    }
    
    
    
}