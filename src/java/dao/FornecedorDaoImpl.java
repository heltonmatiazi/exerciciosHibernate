/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aluno
 */
public class FornecedorDaoImpl
        extends BaseDaoImpl<Fornecedor, Long>
        implements FornecedorDao {

    @Override
    public Fornecedor pesquisaPorId(Long id, Session session) throws HibernateException {
        Fornecedor fornecedor = (Fornecedor) 
                session.get(Fornecedor.class, id);
        return fornecedor;
    }

    @Override
    public List<Fornecedor> listarTodos(Session session) throws HibernateException {
        Query consulta = session.createQuery("from Fornecedor");
        return consulta.list();
    }

}
