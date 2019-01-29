package interviewbit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightChessBoard {

    class Point
    {
        int x,y;
        int currLen;
        public Point(int x,int y){ this.x=x;this.y=y;}
        public Point(int x,int y,int len){ this.x=x;this.y=y;this.currLen=len;}
        /* (non-Javadoc)
         * @see java.lang.Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
           
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }
        /* (non-Javadoc)
         * @see java.lang.Object#equals(java.lang.Object)
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
          
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
        
        }
        
        
    
    public int knight(int x, int y, int x1, int y1, int x2, int y2) {
      //need to find that path exist for not follow BFS
        Queue<Point> q = new LinkedList<>();
        Set<Point> visited= new HashSet<>();
        Point start=new Point(x1, y1);
        Point end=new Point(x2, y2);
        start.currLen=0;
        q.offer(start);
        while(!q.isEmpty())
        {
         Point p=q.poll();
         if(!visited.contains(p))
         {
             visited.add(p);
             if(p.equals(end))
                 return p.currLen;
             else
             {
                 queueChilds(p, q, x, y);
             }
             
         }
        }
        return -1;
      
    }
    public void queueChilds(Point p,Queue<Point> q,int endx, int endy)
    {
        int x=p.x;
        int y=p.y;
        
        int[] X= {1,-1,-1,1,2,2,-2,-2};
        int[] Y= {2,2,-2,-2,1,-1,-1,1};
        
        for(int i=0;i<X.length;i++)
        {
            int x1=x+X[i];
            int y1=y+Y[i];
            Point newPoint=new Point(x1, y1,p.currLen+1);
            if(x1<=endx&&x1>=1&& y1<=endy&&y1>=1 &&!q.contains(newPoint))
            {
                q.offer(newPoint);
            }
        }
        
    }


 public static void main(String[] args) {
	System.out.println(new KnightChessBoard().knight(2, 20, 1, 18, 1, 5));
}

}
