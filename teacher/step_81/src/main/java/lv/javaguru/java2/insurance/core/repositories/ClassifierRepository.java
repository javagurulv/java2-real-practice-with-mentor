package lv.javaguru.java2.insurance.core.repositories;

import lv.javaguru.java2.insurance.core.domain.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassifierRepository extends JpaRepository<Classifier, Long> {

    Optional<Classifier> findByTitle(String title);

}
