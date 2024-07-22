package com.kncakal.MaliyetKontrolAPI.model;


import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name", unique=true)
    @NotNull
    private String userName;

    @Column(name = "user_password")
    @NotNull
    private String userPassword;

    @Column(name = "user_daily_transaction_amount")
    private BigDecimal userDailyTransactionAmount;

    @Column(name = "user_weekly_transaction_amount")
    private BigDecimal userWeeklyTransactionAmount;

    @Column(name = "user_monthly_transaction_amount")
    private BigDecimal userMonthlyTransactionAmount;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transactions> transactions;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public BigDecimal getUserDailyTransactionAmount() {
        return userDailyTransactionAmount;
    }

    public void setUserDailyTransactionAmount(BigDecimal userDailyTransactionAmount) {
        this.userDailyTransactionAmount = userDailyTransactionAmount;
    }

    public BigDecimal getUserWeeklyTransactionAmount() {
        return userWeeklyTransactionAmount;
    }

    public void setUserWeeklyTransactionAmount(BigDecimal userWeeklyTransactionAmount) {
        this.userWeeklyTransactionAmount = userWeeklyTransactionAmount;
    }

    public BigDecimal getUserMonthlyTransactionAmount() {
        return userMonthlyTransactionAmount;
    }

    public void setUserMonthlyTransactionAmount(BigDecimal userMonthlyTransactionAmount) {
        this.userMonthlyTransactionAmount = userMonthlyTransactionAmount;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }
}
