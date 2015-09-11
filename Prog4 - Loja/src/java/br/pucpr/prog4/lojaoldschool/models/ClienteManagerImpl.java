
package br.pucpr.prog4.lojaoldschool.models;

import br.pucpr.prog4.lojaoldschool.models.dao.ClienteDAO;
import br.pucpr.prog4.lojaoldschool.models.dao.JdbcDaoManager;
import br.pucpr.prog4.lojaoldschool.models.dao.IDaoManager;

/**
 *
 * @author renan.polli
 */
public class ClienteManagerImpl implements ClienteManager {

    @Override
    public Cliente cadastrar(Cliente cliente) {
        // validar campos
        
        IDaoManager manager;
        manager = new JdbcDaoManager();
        
        try{
            manager.iniciar();
            ClienteDAO dao = manager.getCLienteDao();
            Cliente c;
            c = dao.Inserir(cliente);
            manager.confirmarTransação();
            manager.encerrar();

            return c;
        }catch(Exception e){
            manager.abortarTransação();
            throw e;
        }
    }
    
    
}
