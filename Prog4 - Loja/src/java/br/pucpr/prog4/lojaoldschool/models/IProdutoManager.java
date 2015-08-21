
package br.pucpr.prog4.lojaoldschool.models;

import java.util.List;

public interface IProdutoManager {
   
    List<Produto> obterTodos();
   
    Produto obterPorId(int id);
}
