package dao;

import interfaces.NotaDao;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Nota;

/**
 * @author lyndemberg
 */
public class NotaDaoImpl implements NotaDao{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-notas");
    private EntityManager em = emf.createEntityManager();
    
    @Override
    public boolean salvar(Nota n) {
        try{
            em.getTransaction().begin();
            em.persist(n);
            em.getTransaction().commit();
            return true;
        }catch(EntityExistsException ex){
            return false;
        }
    }

    @Override
    public Nota buscar(int id) {
        Nota find = em.find(Nota.class, id);
        return find;
    }
    
    @Override
    public void atualizar(Nota n) {
        em.getTransaction().begin();
        em.merge(n);
        em.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(em.find(Nota.class, id));
        em.getTransaction().commit();
    }

    @Override
    public List<Nota> list() {
        em.getTransaction().begin();
        TypedQuery<Nota> query = em.createQuery("SELECT n FROM Nota n",Nota.class);
        List<Nota> lista = query.getResultList();
        em.getTransaction().commit();
        return lista;
    }

    
    
}
