package br.pucpr.prog4.lojaoldschool.models.dao;

import br.pucpr.prog4.lojaoldschool.models.dao.ClienteDAO;
import br.pucpr.prog4.lojaoldschool.models.dao.JdbcClienteDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcDaoManager implements IDaoManager 
{
    Connection conexão;
    private JdbcClienteDAO clienteDAO;
    //JdbcClienteDao clienteDao;
    
    public JdbcDaoManager()
    {

    }
    
    
    @Override
    public void iniciar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/loja"; ///nome do schema do DB
            conexão = DriverManager.getConnection(url, "root", "root");
           // clienteDao.setConexão(conexão);
            
            conexão.setAutoCommit(false);
                    clienteDAO = new JdbcClienteDAO(conexão);
            
        }
        catch( Exception ex )
        {
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados:" + 
                    ex.getMessage());
        }
    }

    @Override
    public void encerrar() 
    {
        try {
            if(!conexão.isClosed())
                conexão.close();
        } catch (SQLException ex) {
            
        }
    }

    @Override
    public void confirmarTransação() {
        try{
            conexão.commit();
        }catch(SQLException ex){
            throw new DaoException("Ocorreu um erroao confirmar a transação");
        }
    }

    @Override
    public void abortarTransação() {
        try{
            conexão.rollback();
        }catch(SQLException ex){
            throw new DaoException("Ocorreu um erro ao confirmar a transação");
        }
    }

    @Override
    public ClienteDAO getCLienteDao() {
        return clienteDAO;
    }

    
}
