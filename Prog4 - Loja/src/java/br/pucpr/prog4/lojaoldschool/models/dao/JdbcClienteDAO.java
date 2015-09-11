/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.lojaoldschool.models.dao;

import br.pucpr.prog4.lojaoldschool.models.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author renan.polli
 */
public class JdbcClienteDAO implements ClienteDAO {
    private Connection conexão;
    
    public JdbcClienteDAO(Connection conexão){
        this.conexão = conexão;
    }
    
    @Override
    public Cliente Inserir(Cliente cliente){
        String sql = "INSERT INTO Pessoa("
               + "nome,"
               +"sexo,"
               +"cpf,"
               +"comentario,"
               +"tipo,"
               +"dataNasc)"
               +"VALUES "
               +"(?,?,?,?,?,?)";
        
        PreparedStatement ps;
        
        
        try{
            ps = conexão.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getSexo());
            ps.setLong(3, cliente.getCPF());
            ps.setString(4, cliente.getComentario());
            ps.setString(5, cliente.getTipoPessoa());
            ps.setDate(6, new java.sql.Date(cliente.getDataNasc().getTime()));
            
            return cliente;
            
        }catch(Exception ex){
            throw new DaoException("Ocorreu um erro ao inserir cliente");
        }
  
    }
}
