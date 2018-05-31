package com.practice.async;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Class Shop.
 */
public class Shop {

	/** The name. */
	private final String name;
	
	/** The Constant random. */
	private static final Random random = new Random();
	
	/**
	 * Instantiates a new shop.
	 *
	 * @param name the name
	 */
	public Shop(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the price.
	 *
	 * @param product the product
	 * @return the price
	 */
	public double getPrice(String product){
		return calculatePrice(product);
	}
	
	/**
	 * Gets the discount price.
	 *
	 * @param product the product
	 * @return the discount price
	 */
	public String getDiscountPrice(String product){
		double price =  calculatePrice(product);
		Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
		return String.format("%s:%.2f:%s", name,price,code);
	}
	
	/**
	 * Gets the price async.
	 *
	 * @param product the product
	 * @return the price async
	 */
	public Future<Double> getPriceAsync(String product){
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread( () -> {
			try {
				double price = calculatePrice(product);
				futurePrice.complete(price);
			}catch(Exception ex){
				futurePrice.completeExceptionally(ex);
			}
		}).start();
		
		return futurePrice;
	}
	
	/**
	 * Calculate price.
	 *
	 * @param product the product
	 * @return the double
	 */
	private double calculatePrice(String product) {
		delay();
		return random.nextDouble() * product.charAt(0) + product.charAt(1);
	}
	
	/**
	 * Delay.
	 */
	public static void delay(){
		int delay = 500+random.nextInt(2000);
		try{
			Thread.sleep(delay);
		}catch(InterruptedException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Find prices.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<String> findPrices(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))).collect(Collectors.toList());
	}
	
	/**
	 * Find discounted prices.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<String> findDiscountedPrices(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		return shops.stream().map(shop -> shop.getDiscountPrice(product)).map(Quote::parse).map(Discount::applyDiscount).collect(Collectors.toList());
	}
	
	/**
	 * Find prices stream.
	 *
	 * @param product the product
	 * @return the stream
	 */
	public Stream<CompletableFuture<String>> findPricesStream(String product){
		
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
				new ThreadFactory() {
					
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}
				});
		return shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountPrice(product),executor)).
				map(future -> future.thenApply(Quote::parse)).map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)));
	}
	
	/**
	 * Find discounted prices async new.
	 *
	 * @param product the product
	 */
	public void findDiscountedPricesAsyncNew(String product){
		long start = System.nanoTime();
		
		CompletableFuture[] futures = findPricesStream(product).map(f -> f.thenAccept(
				s -> System.out.println(s + " (done in "+((System.nanoTime() - start)/1_000_000) + " msecs"))).toArray(size -> new CompletableFuture[size]);
		CompletableFuture.allOf(futures).join();
		long invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");

	}
	
	/**
	 * Find discounted prices async old.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<String> findDiscountedPricesAsyncOld(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
				new ThreadFactory() {
					
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}
				});
		List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getDiscountPrice(product),executor)).
				map(future -> future.thenApply(Quote::parse)).map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote),executor)))
						.collect(Collectors.toList());
		
		return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
	/**
	 * Find parallel prices.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<String> findParallelPrices(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))).collect(Collectors.toList());
	}
	
	/**
	 * Find parallel prices extra.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<String> findParallelPricesExtra(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"),new Shop("BuyItAllExtra"));
		return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))).collect(Collectors.toList());
	}
	
	/**
	 * Find future price.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<CompletableFuture<String>> findFuturePrice(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"));
		return shops.stream().map(shop -> CompletableFuture.supplyAsync(
				() -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))
				)).collect(Collectors.toList());
	}
	
	/**
	 * Find future price extra.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<CompletableFuture<String>> findFuturePriceExtra(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"),new Shop("BuyItAllExtra"));
		return shops.stream().map(shop -> CompletableFuture.supplyAsync(
				() -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))
				)).collect(Collectors.toList());
	}
	
	/**
	 * Find future price extra executor.
	 *
	 * @param product the product
	 * @return the list
	 */
	public List<CompletableFuture<String>> findFuturePriceExtraExecutor(String product){
		List<Shop> shops = Arrays.asList(new Shop("BestPrice"),new Shop("LetsSaveBig"),new Shop("MyFavoriteShop"),new Shop("BuyItAll"),new Shop("BuyItAllExtra"));
		Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
				new ThreadFactory() {
					
					@Override
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}
				});
		return shops.stream().map(shop -> CompletableFuture.supplyAsync(
				() -> String.format("%s price is %.2f", shop.getName(),shop.getPrice(product))
				,executor)).collect(Collectors.toList());
	}
	
	/**
	 * Find future join price.
	 *
	 * @param futureList the future list
	 * @return the list
	 */
	public List<String> findFutureJoinPrice(List<CompletableFuture<String>> futureList){
		return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		Shop shop = new Shop("BestShop");
		
// Discounted Prices
		System.out.println(shop.getDiscountPrice("MyIphone7"));
		
// Get Price Async
		long start = System.nanoTime();
		Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
		long invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Invocation returned after " + invocationTime + " msec");
		
		try{
			double price = futurePrice.get();
			System.out.printf("Price is %.2f%n",price);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		long retrievalTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Price returned after " + retrievalTime + " msec");
// Get discounted prices
		start = System.nanoTime();
		System.out.println(shop.findDiscountedPrices("MyIphone7"));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// Get discounted prices Async
		start = System.nanoTime();
		System.out.println(shop.findDiscountedPricesAsyncOld("MyIphone7"));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// Get discounted prices Async with thenAccept
		shop.findDiscountedPricesAsyncNew("MyIphone7");
		
// Using Streams
		start = System.nanoTime();
		System.out.println(shop.findPrices("MyIphone7"));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// Using parallel Streams
		start = System.nanoTime();
		System.out.println(shop.findParallelPrices("MyIphone7"));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// Using CompletableFuture interface
		start = System.nanoTime();
		System.out.println(shop.findFutureJoinPrice(shop.findFuturePrice("MyIphone7")));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// parallel stream with 5 shops 1 more then total cores of CPU
		start = System.nanoTime();
		System.out.println(shop.findParallelPricesExtra("MyIphone7"));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");

// CompletableFuture interface with 5 shops 1 more then total cores of CPU
		start = System.nanoTime();
		System.out.println(shop.findFutureJoinPrice(shop.findFuturePriceExtra("MyIphone7")));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
		
// CompletableFuture interface Executor with 5 shops 1 more then total cores of CPU
		start = System.nanoTime();
		System.out.println(shop.findFutureJoinPrice(shop.findFuturePriceExtraExecutor("MyIphone7")));
		invocationTime = ((System.nanoTime() - start)/1_000_000);
		System.out.println("Done in " + invocationTime + " msec");
	}
}
