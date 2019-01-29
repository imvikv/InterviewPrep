package algo.java.impl.leetcode;

import java.util.LinkedList;

public class NumberOfIslands {

    static class Node
   {
       int x,y ;
       public Node(int x,int y){this.x=x;this.y=y;}
   }
   public static int findisland(int[][]grid,int o,int p)
   {   
        //question is actually to find connected components
       int lenX=o;
       if(lenX==0) return 0;
       int lenY=p;
       
       //System.out.println(lenX+" "+lenY);
       LinkedList<Node> q= new LinkedList<>();
      // q.add(new Node(0,0));
           int count =0;
       boolean[][] visited= new boolean[lenX][lenY];
       //start from 0,0
       for(int i=0;i<lenX;i++){
           for(int j=0;j<lenY;j++){
               if(grid[i][j]==1&& !visited[i][j]){
                   //System.out.println(i+" "+j);
                   q.offer(new Node(i,j));
                   count++;
                   while(!q.isEmpty()){                        
                       Node n= q.poll();
                       if(!visited[n.x][n.y]){
                           visited[n.x][n.y]=true;
                           //add it's childs
                           int[] X={1,-1,0,0};
                           int[] Y={0,0,1,-1};
                           
                           for(int k=0;k<X.length;k++)
                           {
                               int xTemp=n.x+X[k];
                               int yTemp=n.y+Y[k];
                               if(isValid(xTemp,yTemp,grid)&&grid[xTemp][yTemp]==1&&!visited[xTemp][yTemp]){
                                q.offer(new Node(xTemp,yTemp));   
                               }
                                   
                           }
                       }
                   }
               }
               
           }
           
       }
       
       return count;
       
   }
   public static boolean isValid(int x,int y,int[][] grid)
   {
       if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length)
           return true;
       return false;
   }


}
