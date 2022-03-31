package modules;

import testdata.Trader;
import testdata.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TraderTransaction {

    public static void main(String[] args) {

        //Test data.
        List<Transaction> transactions = getTransactions();

        //1.  Find all transactions in the year 2011 and sort them by value (small to high).

        List<Transaction> transactions2011Sorted = transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());

        System.out.println("1. Find all transactions in the year 2011 and sort them by value (small to high). : " +
                                   transactions2011Sorted);

        // 2.  What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions
                .stream()
                .map(t -> t
                        .getTrader()
                        .getName())
                .distinct()
                .collect(toList());

        System.out.println("2.1 What are all the unique cities where the traders work? : " + uniqueCities);

        Set<String> uniqueCities1 = transactions
                .stream()
                .map(t -> t
                        .getTrader()
                        .getName())
                .collect(toSet());

        System.out.println("2.2 What are all the unique cities where the traders work? : " + uniqueCities1);

        // 3.  Find all traders from Cambridge and sort them by name.
        List<String> cambridgeTradersSorted = transactions
                .stream()
                .filter(t -> t
                        .getTrader()
                        .getCity()
                        .equals("Cambridge"))
                .map(t -> t
                        .getTrader()
                        .getName())
                .sorted()
                .collect(toList());

        System.out.println("3. Find all traders from Cambridge and sort them by name. : " + cambridgeTradersSorted);

        // 4.  Return a string of all traders’ names sorted alphabetically.
        String traderSortedNames = transactions
                .stream()
                .map(t -> t
                        .getTrader()
                        .getName())
                .sorted()
                .reduce("", (s1, s2) -> s1 + " " + s2);

        System.out.println("4. Return a string of all traders’ names sorted alphabetically. " + traderSortedNames);

        // 5.  Are any traders based in Milan?

        boolean anyTradersInMilan = transactions
                .stream()
                .anyMatch(t -> t
                        .getTrader()
                        .getCity()
                        .equals("Milan"));

        System.out.println("5. Are any traders based in Milan?: " + anyTradersInMilan);

        // 6.  Print all transactions’ values from the traders living in Cambridge.

        System.out.println("6. Print all transactions’ values from the traders living in Cambridge.");
        transactions
                .stream()
                .filter(t -> t
                        .getTrader()
                        .getCity()
                        .equals("Cambridge"))
                .map(t -> t.getValue())
                .forEach(System.out::println);

        // 7.  What’s the highest value of all the transactions?
        int highestValue = transactions
                .stream()
                .map(t -> t.getValue())
                .reduce(-1, (a, b) -> Math.max(a, b));

        System.out.println("7.1.  What’s the highest value of all the transactions? : " + highestValue);

        Optional<Integer> highestValue1 = transactions
                .stream()
                .map(t -> t.getValue())
                .reduce(Integer::max);

        System.out.println("7.2.  What’s the highest value of all the transactions?: " + highestValue1.get());


        // 8.  Find the transaction with the smallest value.

        int minValue = transactions
                .stream()
                .map(t -> t.getValue())
                .reduce(Integer.MAX_VALUE, (a, b) -> Math.min(a, b));

        System.out.println("8.1.  Find the transaction with the smallest value." + minValue);

        Optional<Integer> minValue1 = transactions
                .stream()
                .map(t -> t.getValue())
                .reduce(Integer::min);

        System.out.println("8.2.  Find the transaction with the smallest value." + minValue1.get());

    }

    private static List<Transaction> getTransactions() {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
                            );
    }

}
