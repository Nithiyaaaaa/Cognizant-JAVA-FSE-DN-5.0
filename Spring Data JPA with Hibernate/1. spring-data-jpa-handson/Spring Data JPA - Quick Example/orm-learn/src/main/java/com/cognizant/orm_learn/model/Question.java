package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qu_id")
    private int id;

    @Column(name = "qu_text")
    private String text;

    @Column(name = "qu_score")
    private Double score;

    @OneToMany(mappedBy = "question")
    private Set<Options> options;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Set<Options> getOptions() { return options; }
    public void setOptions(Set<Options> options) { this.options = options; }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text + "', score=" + score + "}";
    }
}