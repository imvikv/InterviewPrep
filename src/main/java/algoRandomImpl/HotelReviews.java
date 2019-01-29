package algoRandomImpl;
import java.util.Arrays;
import java.util.Collections;
//https://www.interviewbit.com/problems/hotel-reviews/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HotelReviews {

    public int[] solve(String A, String[] B) {
        String[] input=A.split("_");
        Set<String> source=new HashSet<>();
        for(String s: input)
        {
            source.add(s);
        }
        Map<Integer, LinkedList<Integer>> target=new TreeMap<Integer,LinkedList<Integer>>(Collections.reverseOrder());
        for(int i=0;i<B.length;i++)
        {
            String k=B[i];
            String [] l=k.split("_");
            int count=0;
            for(String m:l)
            {
                if(source.contains(m))
                count++;
            }
            LinkedList<Integer> val=new LinkedList<Integer>();
            if(target.containsKey(count))
            val=target.get(count);
            val.offer(i);
            target.put(count, val);
        }
        int[] result=new int[B.length];
        int counter=0;
        for(Integer i:target.keySet())
        {
            LinkedList<Integer> loop=target.get(i);
            for(int j=counter;loop.size()!=0;j++,counter++)
            result[j]=loop.poll();
        }
        return result;
    }


    public static void main(String[] args) {
	int[] result=	new HotelReviews().solve("cool_ice_wifi",new String[] {"water_is_cool", "cold_ice_drink", "cool_wifi_speed"} );
	System.out.println(Arrays.toString(result));
	}
}
