/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Nota;

/**
 *
 * @author lyndemberg
 */
public interface NotaDao {
    boolean salvar(Nota n);
    Nota buscar(int id);
    void atualizar(Nota n);
    void delete(int id);
    List<Nota> list();
}
