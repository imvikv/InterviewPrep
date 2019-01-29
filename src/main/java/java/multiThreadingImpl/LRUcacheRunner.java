package java.multiThreadingImpl;

public class LRUcacheRunner {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(10);
		for (int i = 0, j = i + 1; i < 13; i++, j++) {
			cache.set(i, j);
			System.out.println("insert i,j " + i + "," + j);
			/*
			 * if (i % 2 == 0) { cache.get(i); }
			 */
		}
		// all elements in LRU right now
		cache.printCacheList();
		cache.printCacheList();
	}

}
