package leetCode.Medium;
import java.util.HashSet;

public class _2249_CountLatticePointsInsideACircle {
    public int countLatticePoints(int[][] circles) {
        // Can coords be negative? -- No, neither can the lattice points
        // Can the radius be zero? -- The radius is between 1 and 100
        // Are the points "inclusive" (i.e. if a point is on the edge of a circle)
        //   is it considered "inside"? -- yes
        
        // HashSet of lattice points considered inside -- we can't add an item to a set twice
        HashSet<String> set = new HashSet<String>();
        
        // BCR is O(n)?
        
        // For a given circle, add all points inside that circle if they
        // are not in the set
        for (int i = 0; i < circles.length; i++) {
            addPointsInsideCircle(set, circles[i]);
        }
        
        // Return the number of points (size of set)
        return set.size();
    }
    
    public void addPointsInsideCircle(HashSet<String> set, int[] circle) {
        int cx = circle[0];
        int cy = circle[1];
        int radius = circle[2];
        
        // Add points from outer edges of circle
        //   Add top-most point (x, y + radius)
        set.add(pointToString(cx, cy + radius));
        
        //   Add right-most point (x + radius, y)
        set.add(pointToString(cx + radius, cy));

        //   Add bottom-most point (x, y - radius)
        set.add(pointToString(cx, cy - radius));
        
        //   Add left-most point (x - radius, y)
        set.add(pointToString(cx - radius, cy));
        
        // Add points from interior of circle -- remember the center!
        //   Iterate over square -- make sure to include center if side-length = 0
        
        // What are bounds of square?
        //   Top-left: ( + 1, - 1)
        //   Top-right: ( - 1, - 1 )
        //   Bottom-left: ( + 1, + 1)
        //   Bottom-right: ( - 1, + 1)
        for (int x = cx - radius + 1; x <= cx + radius - 1 ; x++) {
            for (int y = cy - radius + 1 ; y <= cy + radius - 1 ; y ++) {
                // You forgot to check if inside bounds of radius, dummy :/
                if (isWithinRadius(x, y, circle)) {
                    set.add(pointToString(x, y));
                }
                
            }
        }
        
    }
    
    public boolean isWithinRadius(int x, int y, int[] circle) {
        int dx = Math.abs(x - circle[0]);
        int dy = Math.abs(y - circle[1]);
        // dx^2 + dy^2 <= r^2
        return Math.pow(dx, 2) + Math.pow(dy, 2) <= Math.pow(circle[2], 2);
    }
    
    public String pointToString(Integer x, Integer y) {
        return x.toString() + "." + y.toString();
    }
    
    public int countLatticePoints2(int[][] circles) {
        HashSet<String> res = new HashSet<String>();
        for(int[] arr : circles){
            int x = arr[0], y = arr[1], r = arr[2];
            for(int i=x-r; i<=x+r; i++)
                for(int j=y-r; j<=y+r; j++)
                    if((x-i)*(x-i) + (y-j)*(y-j) <= r*r)
                        res.add(i+","+j);
        }
        return res.size();
    }
}
