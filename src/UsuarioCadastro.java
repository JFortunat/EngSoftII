
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioCadastro {
      private CadastroUsuario view;

    public UsuarioCadastro(CadastroUsuario view) {
        this.view = view;
    }
      
    public void salvaUsuario(){
        String nome = view.getCxNome().getText();
        String login = view.getCxLoginCadastro().getText();
        String senha = view.getCxSenhaCadastro().getText();
        
        Usuario usuario = new Usuario(nome, login, senha);
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioBanco usuariobanco = new UsuarioBanco(conexao);
            usuariobanco.insert(usuario);
            
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso");
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }  
}
