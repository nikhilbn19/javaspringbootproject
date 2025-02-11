package com.webknot.finance_trackerwebknot.service;

import com.webknot.finance_trackerwebknot.entity.FinanceEntry;
import com.webknot.finance_trackerwebknot.entity.EntryType; // ✅ Import this
import com.webknot.finance_trackerwebknot.repository.FinanceEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceEntryService {
    @Autowired
    private FinanceEntryRepository repository;

    public FinanceEntry addEntry(FinanceEntry entry) {
        return repository.save(entry);
    }

    public List<FinanceEntry> getAllEntries() {
        return repository.findAll();
    }

    public FinanceEntry getEntryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FinanceEntry updateEntry(Long id, FinanceEntry updatedEntry) {
        FinanceEntry entry = repository.findById(id).orElse(null);
        if (entry != null) {
            entry.setAmount(updatedEntry.getAmount());
            entry.setCategory(updatedEntry.getCategory());
            entry.setDescription(updatedEntry.getDescription());
            entry.setDate(updatedEntry.getDate());
            entry.setType(updatedEntry.getType());
            return repository.save(entry);
        }
        return null;
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

    public Double getTotalIncome() {
        return repository.findByType(EntryType.INCOME)
                .stream()
                .mapToDouble(FinanceEntry::getAmount)
                .sum();
    }

    public Double getTotalExpense() {
        return repository.findByType(EntryType.EXPENSE)
                .stream()
                .mapToDouble(FinanceEntry::getAmount)
                .sum();
    }
}
