package testCollection.practice_questions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionProcessor {

    private record Transaction(String userId, double amount, LocalDateTime timestamp) {
    }

    private static final List<Transaction> transactions = List.of(
            new Transaction("user_01", 250.00, LocalDateTime.of(2026, 1, 5, 10, 30)),
            new Transaction("user_02", 1200.50, LocalDateTime.of(2026, 1, 7, 14, 15)),
            new Transaction("user_07", -80.00, LocalDateTime.of(2026, 1, 9, 9, 0)),
            new Transaction("user_03", 500.00, LocalDateTime.of(2026, 2, 1, 11, 45)),
            new Transaction("user_06", -300.00, LocalDateTime.of(2026, 2, 3, 16, 20)),
            new Transaction("user_04", 750.75, LocalDateTime.of(2026, 2, 14, 8, 10)),
            new Transaction("user_10", -150.00, LocalDateTime.of(2026, 3, 2, 13, 55)),
            new Transaction("user_05", 3000.00, LocalDateTime.of(2026, 3, 18, 17, 30)),
            new Transaction("user_08", -50.25, LocalDateTime.of(2026, 4, 6, 12, 0)),
            new Transaction("user_09", 620.00, LocalDateTime.of(2026, 4, 22, 15, 40))
    );

    public static void main(String[] args) {

        // 4. Given List<Transaction> with (userId, amount, timestamp), find the top 3 users by total spend. Return List<String> of userIds in order.
        List<String> userIds = transactions.stream()
                .sorted(Comparator.comparing(Transaction::amount).reversed())
                .limit(3)
                .map(Transaction::userId)
                .toList();

        System.out.println(userIds);

    }
}