/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.lojaoldschool.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan.polli
 */
public class ProdutoManager implements IProdutoManager{
    
    private static List<Produto> produtos;
    
    static
    {
        produtos = new ArrayList<Produto>();
        
        Produto bola = new Produto();
        bola.setId(1);
        bola.setNome("Bola Nike");
        bola.setPreco(39.90);
        
        Produto camisa = new Produto();
        camisa.setId(2);
        camisa.setNome("Camisa Seleção");
        camisa.setPreco(79.90);
        
        Produto tenis = new Produto();
        tenis.setId(3);
        tenis.setNome("Tenis DC");
        tenis.setPreco(350.00);
        
        produtos.add(bola);
        produtos.add(camisa);
        produtos.add(tenis);
    }

    @Override
    public List<Produto> obterTodos() {
        return produtos;
    }
    
    @Override
    public Produto obterPorId(int id){
        for(Produto produto : produtos){
            if(produto.getId() == id)
                return produto;
        }
        return null;
    } 

}
