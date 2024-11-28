package com.user.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//MODEl
@Document(collection = "expenses")
class Expense {
    @Id
    private String id;
    private String userId;
    private String category;
    private double amount;
    private String description;
    private LocalDateTime date;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}


interface ExpenseRepository extends MongoRepository<Expense, String> {}

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Fetch all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Add a new expense
    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setDate(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    // Fetch an expense by ID
    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable String id) {
        return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
    }
}
