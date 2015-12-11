package Interfaces;

import entidade.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {
    
    public void cadastrar(Usuario u)throws SQLException;
    
    //public void remover(Usuario u)throws SQLException;
    
    //public void atualizar(Usuario u)throws SQLException;
    
    //public Usuario pesquisar(String nome)throws SQLException;
    
    //public boolean logar(String nome, String senha)throws SQLException;
    
    public List<Usuario> pesquisarUsuarios(String nome) throws SQLException;
    
}
