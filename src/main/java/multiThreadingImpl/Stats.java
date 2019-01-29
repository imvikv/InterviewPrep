package multiThreadingImpl;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stats {
	

	public static class StatisticsAggregatorImpl implements StatisticsAggregator {
		Map<String,StockPrice> stocks=new ConcurrentHashMap<>();
		@Override
		public void putNewPrice(String symbol, double price) {
		
			
				if(null == stocks.get(symbol))
				{
					StockPrice stockPrice= new StockPrice(price,1);
					
					stocks.put(symbol,stockPrice );
				}
				else
				{
					StockPrice stockPrice=stocks.get(symbol);
					stockPrice.setAmount(stockPrice.getAmount()+price);
					stockPrice.setCount(stockPrice.getCount()+1);
					stocks.put(symbol, stockPrice);
				}
			
		
		}

		@Override
		public double getAveragePrice(String symbol) {
		
			StockPrice st =stocks.get(symbol);
			return new Double(st.getAmount()/st.getCount());
		}

		@Override
		public int getTickCount(String symbol) {
		return stocks.get(symbol).getCount();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}



}
class StockPrice
{
	double amount;
	int count;
	 double getAmount() {
		return amount;
	}
	void setAmount(double amount) {
		this.amount = amount;
	}
	 int getCount() {
		return count;
	}
	void setCount(int count) {
		this.count = count;
	}
	public StockPrice(double amount, int count) {
		super();
		this.amount = amount;
		this.count = count;
	}
	
	
}
