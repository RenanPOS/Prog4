/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.lojaoldschool.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.pucpr.prog4.lojaoldschool.models.*;
import br.pucpr.prog4.lojaoldschool.models.dao.DaoException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;

/**
 *
 * @author renan.polli
 */
public class ClienteServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/cadastroCliente.jsp");
        rd.forward(request, response);
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente cliente = new Cliente();
        
        cliente.setTipoPessoa(request.getParameter("Tipo"));
        cliente.setNome(request.getParameter("Nome"));
        String CPFaux;
        CPFaux = request.getParameter("CPF");
        int CPF = Integer.parseInt(CPFaux);
        cliente.setCPF(CPF);
        cliente.setSexo(request.getParameter("Sexo"));
        cliente.setComentario("Comentario");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            String dataNascAux = request.getParameter("Data");
            Date dataNasc;
            dataNasc = sdf.parse(request.getParameter("Data"));
            cliente.setDataNasc(dataNasc);
        } catch(ParseException e){
            throw new DaoException(e.getMessage());
        }
        ClienteManagerImpl aux = new ClienteManagerImpl();
        aux.cadastrar(cliente);
        
    }
   
}
