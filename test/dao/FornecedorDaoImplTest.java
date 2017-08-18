/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aluno
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session session;

    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

//    @Test
    public void testeSalvar() {
        session = HibernateUtil.abreSessao();
        fornecedor
                = new Fornecedor(null, "nome fornecedor",
                        "email fornecedor",
                        "320432094", new Date(),
                        "teste observação");
        fornecedorDao.salvarOuAlterar(fornecedor, session);
        session.close();

        assertNotNull(fornecedor.getId());
    }

    @Test
    public void testeAlterar() {
        getFornecedor();
        session = HibernateUtil.abreSessao();
        fornecedor.setNome("fornecedor alterado");
        fornecedorDao.salvarOuAlterar(fornecedor, session);
        
        Fornecedor fornAlt = fornecedorDao.
                pesquisaPorId(fornecedor.getId(), session);
        
        assertEquals(fornecedor.getNome(), fornAlt.getNome());
        
    }

//    @Test
    public void testPesquisaPorId() {
        System.out.println("pesquisaPorId");
        Long id = null;
        Session session = null;
        FornecedorDaoImpl instance = new FornecedorDaoImpl();
        Fornecedor expResult = null;
        Fornecedor result = instance.pesquisaPorId(id, session);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
//  @Test
    public void testeExcluir(){
	getFornecedor();
	session = HibernateUtil.abreSessao();
	fornecedorDao.excluir(fornecedor,session);
	Fornecedor  fornExcluir = fornecedorDao.pesquisaPorId(fornecedor.getId(),session);
	assertNull(fornExcluir);
}
//    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        
    }

    private void getFornecedor() {
        session = HibernateUtil.abreSessao();
        Query consulta
      = session.createQuery("select max(id) from Fornecedor");
        Long id = (Long) consulta.uniqueResult();
        session.close();
        if (id == null) {
            testeSalvar();
        } else {
            session = HibernateUtil.abreSessao();
            fornecedor = 
                    fornecedorDao.pesquisaPorId(id, session);
            session.close();
        }

    }

}
