
package interfaces;

import entidades.Pessoa;
import java.util.List;

/**
 *
 * @author RODOLFO ROCHA
 */
public interface GerenciarCadastros {
    void cadastrar(Pessoa p);
    
    List<Pessoa> listar();
}
