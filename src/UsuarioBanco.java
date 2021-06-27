import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioBanco {
    private final Connection connection;
    
    public UsuarioBanco(Connection connection){
        this.connection = connection;    
    }
    
    public void insert(Usuario usuario) throws SQLException{    
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES ('"+usuario.getNome()+"','"+usuario.getLogin()+"','"+usuario.getSenha()+"'); ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
            
    }
    
    public boolean autenticarUsuario(Usuario usuario) throws SQLException{
        String sql = "SELECT * FROM usuario where login = '"+usuario.getLogin()+"' and senha = '"+usuario.getSenha()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
}
