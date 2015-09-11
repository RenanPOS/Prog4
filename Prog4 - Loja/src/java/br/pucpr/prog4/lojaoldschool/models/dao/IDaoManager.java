package br.pucpr.prog4.lojaoldschool.models.dao;

import br.pucpr.prog4.lojaoldschool.models.dao.ClienteDAO;

public interface IDaoManager 
{
    void iniciar();
    void encerrar();
    void confirmarTransação();
    void abortarTransação();
  //  IClienteDao getClienteDao();
    ClienteDAO getCLienteDao();
}
