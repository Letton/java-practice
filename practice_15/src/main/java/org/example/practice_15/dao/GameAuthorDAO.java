package org.example.practice_15.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.practice_15.models.GameAuthor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameAuthorDAO {

    private final SessionFactory sessionFactory;

    @PostConstruct
    void init()
    {
        Session session = sessionFactory.openSession();
    }

    @Transactional
    public List<GameAuthor> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from GameAuthor p", GameAuthor.class)
                .getResultList();
    }

    @Transactional
    public void save(GameAuthor person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public GameAuthor show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GameAuthor.class, id);
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(GameAuthor.class, id));
    }

}
