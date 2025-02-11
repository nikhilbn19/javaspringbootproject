package com.webknot.finance_trackerwebknot.repository;

import com.webknot.finance_trackerwebknot.entity.FinanceEntry;
import com.webknot.finance_trackerwebknot.entity.EntryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceEntryRepository extends JpaRepository<FinanceEntry, Long> {
    List<FinanceEntry> findByType(EntryType type);
    List<FinanceEntry> findByCategory(String category);
}
