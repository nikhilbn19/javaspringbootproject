package com.webknot.finance_trackerwebknot.controller;

import com.webknot.finance_trackerwebknot.entity.FinanceEntry;
import com.webknot.finance_trackerwebknot.service.FinanceEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/entries")
public class FinanceEntryController {
    @Autowired
    private FinanceEntryService service;

    @PostMapping
    public FinanceEntry addEntry(@RequestBody FinanceEntry entry) {
        return service.addEntry(entry);
    }

    @GetMapping
    public List<FinanceEntry> getAllEntries() {
        return service.getAllEntries();
    }

    @GetMapping("/{id}")
    public FinanceEntry getEntryById(@PathVariable Long id) {
        return service.getEntryById(id);
    }

    @PutMapping("/{id}")
    public FinanceEntry updateEntry(@PathVariable Long id, @RequestBody FinanceEntry updatedEntry) {
        return service.updateEntry(id, updatedEntry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.deleteEntry(id);
    }

    @GetMapping("/summary")
    public Map<String, Double> getFinancialSummary() {
        Map<String, Double> summary = new HashMap<>();
        summary.put("Total Income", service.getTotalIncome());
        summary.put("Total Expense", service.getTotalExpense());
        return summary;
    }
}
