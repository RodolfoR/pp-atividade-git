package DAO;

import Conexao.Conexao;
import Conexao.ConnectionFactory;
import entidade.Usuario;
import Interfaces.UsuarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDao implements UsuarioDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    Conexao co = new Conexao();
    Connection con;
    PreparedStatement pstm;
    
    public UsuarioDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }
    
    public void cadastrar(Usuario entidade) throws SQLException {
        
        co.abrir();
        String SQL = "insert into usuario(id, nome, idade) values (?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setInt(1,entidade.getId());
        pstm.setString(2, entidade.getNome());
        pstm.setInt(3, entidade.getIdade());
      
        pstm.executeUpdate();
    }

//    public void remover(Usuario entidade) throws SQLException{
//        try {
//            co.abrir();
//            
//            String SQL = "delete from usuario where email=?";
//
//            pstm = con.prepareStatement(SQL);
//            pstm.setString(1, entidade.getEmail());
//
//            pstm.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
//        } finally {
//            co.liberar();
//        }
//    }

//    public void atualizar(Usuario entidade) throws SQLException{
//        Date dataNascimento = entidade.getDataNasc();
//        java.sql.Date dataConvertida = new java.sql.Date(dataNascimento.getTime());
//        
//        try {
//            co.abrir();
//            
//            String SQL = "update Usuario set email=?, nome=?, apelido=?, senha=?, cidade=?, estado=?,"
//                    + "dataNasc=?, foto=? where id=?";
//            
//            pstm = con.prepareStatement(SQL);
//            pstm.setString(1, entidade.getEmail());
//            pstm.setString(2, entidade.getNome());
//            pstm.setString(3, entidade.getApelido());
//            pstm.setString(4, entidade.getSenha());
//            pstm.setString(5, entidade.getCidade());
//            pstm.setString(6, entidade.getEstado());
//            pstm.setDate(7, dataConvertida);
//            pstm.setString(8, entidade.getFoto());
//            pstm.setInt(9, entidade.getId());
//
//            pstm.executeUpdate();
//        } catch(Exception E) { 
//            E.printStackTrace();
//        } finally {
//            co.liberar();
//        }
//    }

//    public Usuario pesquisar(String nome) throws SQLException {
//        try {
//            co.abrir();
//            
//            String SQL = "select * from Usuario where nome ilike '%"+ nome +"%'";
//            
//            pstm = con.prepareStatement(SQL);
//            
//            ResultSet result = pstm.executeQuery();
//            
//            Usuario usuario = new Usuario();
//            
//            while(result.next()){
//                usuario.setId(result.getInt("id"));
//                usuario.setEmail(result.getString("email"));
//                usuario.setNome(result.getString("nome"));
//                usuario.setApelido(result.getString("apelido"));
//                usuario.setSenha(result.getString("senha"));
//                usuario.setCidade(result.getString("cidade"));
//                usuario.setEstado(result.getString("estado"));
//                usuario.setDataNasc(result.getDate("datanasc"));
//                usuario.setFoto(result.getString("foto"));
//                usuario.setTipo(result.getBoolean("tipo"));
//            }
//            return usuario;
//            
//        } catch(Exception E) { 
//            E.printStackTrace();
//        } finally {
//            co.liberar();
//        }
//        return null;
//    }
//    
//    public boolean logar(String nome, String senha) throws SQLException {
//        try {
//            co.abrir();
//       
//            String SQL = "select * from Usuario where nome ilike '%"+ nome +"%'";
//            pstm = con.prepareStatement(SQL);
//            
//            ResultSet result = pstm.executeQuery();
//            
//            Usuario usuario = new Usuario();
//            
//            while(result.next()){
//                usuario.setId(result.getInt("id"));
//                usuario.setEmail(result.getString("email"));
//                usuario.setNome(result.getString("nome"));
//                usuario.setApelido(result.getString("apelido"));
//                usuario.setSenha(result.getString("senha"));
//                usuario.setCidade(result.getString("cidade"));
//                usuario.setEstado(result.getString("estado"));
//                usuario.setDataNasc(result.getDate("datanasc"));
//                usuario.setTipo(result.getBoolean("tipo"));
//            }
//            
//            if (usuario.getNome() != null && usuario.getSenha() != null){
//                if (usuario.getNome().equalsIgnoreCase(nome) 
//                        && usuario.getSenha().equalsIgnoreCase(senha)){
//                    return true;
//                }
//                else 
//                    return false;
//            }
//            else
//                return false;
//        } catch(Exception E) { 
//            E.printStackTrace();
//        } finally {
//            co.liberar();
//        }
//        return false;
//    }
    
    public List<Usuario> pesquisarUsuarios(String nome) throws SQLException {
        try {
            co.abrir();
            
            String SQL = "select id, nome, idade from Usuario where nome ilike '%"+ nome +"%'";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            List<Usuario> usuarios = new ArrayList<Usuario>();
            
            while(result.next()){
                Usuario usuario = new Usuario();
                usuario.setId(result.getInt("id"));
                usuario.setNome(result.getString("nome"));
                usuario.setIdade(result.getInt("idade"));
                usuarios.add(usuario);
            }
            return usuarios.isEmpty() ? null : usuarios;
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            co.liberar();
        }
        return null;
    }
}
