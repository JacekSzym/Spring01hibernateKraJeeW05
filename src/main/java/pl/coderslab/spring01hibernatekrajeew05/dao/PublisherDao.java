package pl.coderslab.spring01hibernatekrajeew05.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Publisher pub){
        em.persist(pub);
    }

    public Publisher findById(long id) {
        return em.find(Publisher.class, id);
    }

    public void readBooks(Publisher p) {
        Hibernate.initialize(p.getBooks());
    }

    public List<Publisher> findAll() {
        Query query = em.createQuery("SELECT p FROM Publisher p");
        return query.getResultList();
    }
}
