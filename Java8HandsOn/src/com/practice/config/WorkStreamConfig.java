package com.practice.config;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.practice.PrimeNumbersCollector;
import com.practice.Trader;
import com.practice.Transaction;

public class WorkStreamConfig {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transaction = Arrays.asList(new Transaction(brian, 2011, 300,false),
				new Transaction(raoul, 2012, 1000,true), new Transaction(raoul, 2011, 400,false),
				new Transaction(mario, 2012, 710,true), new Transaction(mario, 2012, 700,true), new Transaction(alan, 2012, 950,true));

		System.out.println(transaction.stream().filter((m) -> m.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()));
		System.out.println(
				transaction.stream().map((m) -> m.getTrader().getCity()).distinct().collect(Collectors.toList()));

		System.out.println(
				transaction.stream().map((m) -> m.getTrader()).filter((m) -> m.getCity().equalsIgnoreCase("Cambridge"))
						.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList()));
		System.out.println(transaction.stream().map((m) -> m.getTrader().getName()).distinct().sorted().reduce("",
				(n1, n2) -> n1 + "," + n2));

		System.out.println(transaction.stream().anyMatch((m) -> m.getTrader().getCity().equalsIgnoreCase("Milan")));
		transaction.stream().filter((m) -> m.getTrader().getCity().equalsIgnoreCase("Cambridge"))
				.map((m) -> m.getValue()).forEach(System.out::println);

		System.out.println(transaction.stream().map((m) -> m.getValue()).reduce(Integer::max));
		System.out.println(transaction.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2));

		Stream<double[]> pythagoras = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100)
				.mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) }).filter(t -> t[2] % 1 == 0));
		pythagoras.limit(5).forEach(t-> System.out.println(t[0] + "," + t[1] + "," + t[2]));
		
		Stream.iterate(new int[] {0, 1},t-> new int[]{t[1],t[0]+t[1]}).limit(10).forEach(t-> System.out.println(t[0]+","+t[1]));
		
		System.out.println(transaction.stream().collect(Collectors.groupingBy(Transaction::getYear)));
		System.out.println(transaction.stream().collect(Collectors.summingInt(Transaction::getYear))+"");
		System.out.println(transaction.stream().map((m) -> m.getTrader().getCity()).collect(Collectors.joining(",")));
		
		System.out.println(transaction.stream().collect(Collectors.reducing((d1, d2) -> d1.getYear() > d2.getYear() ? d1:d2)));
		
		System.out.println(transaction.stream().collect(Collectors.reducing(0,Transaction::getYear,(i,j)->i+j)));
		System.out.println(transaction.stream().collect(Collectors.reducing(0,Transaction::getValue,Integer::sum)));
		System.out.println(transaction.stream().map(Transaction::getYear).reduce(Integer::sum).get());
		System.out.println(transaction.stream().mapToInt(Transaction::getYear).sum());
		
		System.out.println(transaction.stream()
				.collect(Collectors.groupingBy(Transaction::getYear, Collectors.groupingBy(Transaction::getValue))));
		
		
		Map<Integer, Optional<Transaction>> mostValue = transaction.stream().collect(Collectors
				.groupingBy(Transaction::getYear, Collectors.maxBy(Comparator.comparing(Transaction::getValue))));

		System.out.println(mostValue);

		Map<Integer, Transaction> mostValueNew = transaction.stream()
				.collect(Collectors.groupingBy(Transaction::getYear, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Transaction::getValue)), Optional::get)));
		System.out.println(mostValueNew);
		
		Map<Boolean,List<Transaction>> transactionSuccess = transaction.stream().collect(Collectors.partitioningBy(Transaction::isSuccess));
		transactionSuccess.get(false).stream().forEach((m) -> System.out.println(m.getValue()));
		transactionSuccess.get(true).stream().forEach((m) -> System.out.println(m.getValue()));
		
		long fastest = Long.MAX_VALUE;
		for(int i=0;i<10;i++){
			long start = System.nanoTime();
			partitionPrimesWithCustomCollector(1_000_000);
			long duration = (System.nanoTime()-start) / 1_00_00;
			if(duration <fastest) fastest = duration;
		}
		System.out.println(fastest);
	}
	
	public static Map<Boolean,List<Integer>> partitionPrimesWithCustomCollector(int n){
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
	}
}
