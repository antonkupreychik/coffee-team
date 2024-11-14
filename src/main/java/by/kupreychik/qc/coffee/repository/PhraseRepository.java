package by.kupreychik.qc.coffee.repository;

import by.kupreychik.qc.coffee.model.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
