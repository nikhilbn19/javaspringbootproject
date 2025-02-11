package com.webknot.finance_trackerwebknot.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "finance_entries")
public class FinanceEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private EntryType type;  // INCOME or EXPENSE

    private String category;
    private String description;
    private LocalDate date;

    // Default constructor
    public FinanceEntry() {
    }

    // Parameterized constructor
    public FinanceEntry(Long id, Double amount, EntryType type, String category, String description, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
