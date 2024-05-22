package org.example.practice_15.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.practice_15.models.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameDAO {
    private final SessionFactory sessionFactory;

    @PostConstruct
    void init()
    {
        Session session = sessionFactory.openSession();
    }

    @Transactional
    public List<Game> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Game p", Game.class)
                .getResultList();
    }

    @Transactional
    public void save(Game person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
    }

    @Transactional
    public Game show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Game.class, id);
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Game.class, id));
    }
}
