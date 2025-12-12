public class gridWays {
    public static int gridCount(int i , int j, int n, int m ){
        //base casse
      if (i == n-1 && j == m-1) {
        return 1;

        
      }else if (i == n || j == n) { //boundary
        return 0;
        
      }

      int w1 = gridCount(i+1, j, n, m);
      int w2 = gridCount(i, j+1, n, m);
      return w1 +w2;
    }
  

    public static void main(String[] args) {
        int n = 3, m= 3;
        System.out.println(gridCount(0,0,n , m));
    }
    
}
