package lv.javaguru.java2.insurance.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "classifier_values")
public class ClassifierValue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classifier_id", nullable = false)
    private Classifier reader;

    @Column(name = "ic", nullable = false)
    private String ic;

    @Column(name = "description", nullable = false)
    private String description;

}
