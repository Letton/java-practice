package ru.letton.practice_16.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import ru.letton.practice_16.models.Game;
import ru.letton.practice_16.models.GameAuthor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilterService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> filterGames(String name, LocalDate creationDate, Integer authorId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> game = cq.from(Game.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            predicates.add(cb.equal(game.get("name"), name));
        }
        if (creationDate != null) {
            predicates.add(cb.equal(game.get("creationDate"), creationDate));
        }
        if (authorId != null) {
            predicates.add(cb.equal(game.get("author").get("id"), authorId));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<GameAuthor> filterGameAuthors(String nickname, LocalDate birthDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<GameAuthor> cq = cb.createQuery(GameAuthor.class);
        Root<GameAuthor> author = cq.from(GameAuthor.class);

        List<Predicate> predicates = new ArrayList<>();

        if (nickname != null) {
            predicates.add(cb.equal(author.get("nickname"), nickname));
        }
        if (birthDate != null) {
            predicates.add(cb.equal(author.get("birthDate"), birthDate));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
