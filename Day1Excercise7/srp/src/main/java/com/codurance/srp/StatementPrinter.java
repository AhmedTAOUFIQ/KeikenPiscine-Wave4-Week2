package com.codurance.srp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class StatementPrinter {
    private static Console console;
    private DateFormatter dateFormatter;
    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private static final String AMOUNT_FORMAT = "#.00";

    public StatementPrinter() {
        this.console = new Console();
        this.dateFormatter = new DateFormatter();
    }

    public static void printHeader() {
        printLine(STATEMENT_HEADER);
    }


    public static void printTransactions(TransactionRepository transactionRepository) {
        List<Transaction> transactions = transactionRepository.all();
        final AtomicInteger balance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction, balance.addAndGet(transaction.amount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining((s)->printLine(s));
    }
    private static void printLine(String line) {
        console.printLine(line);
    }

    private static String formatNumber(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat(AMOUNT_FORMAT, DecimalFormatSymbols.getInstance(Locale.UK));
        return decimalFormat.format(amount);
    }
    private static String statementLine(Transaction transaction, int balance) {
        return MessageFormat.format("{0} | {1} | {2}", DateFormatter.formatDate(transaction.date()), formatNumber(transaction.amount()), formatNumber(balance));
    }
}
