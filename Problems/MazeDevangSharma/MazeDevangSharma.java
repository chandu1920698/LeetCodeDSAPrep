package Problems.MazeDevangSharma;
import java.util.LinkedList;
import java.util.Queue;
public class MazeDevangSharma {
    static int[][] directions = {{0, 1},    // Move right
                                {0, -1},    // Move Left 
                                {1, 0},     // Move Down
                                {-1, 0}     // Move Up
                            };
    static boolean[][] visited;
    public static void main(String[] args) {
        // int[][] maze = {{1, 1, 1, 1}, 
        //                 {1, 1, 1, 1}, 
        //                 {1, 1, 1, 1}, 
        //                 {1, 1, 1, 1}, 
        //              };
        int[][] maze = {{1, 1, 1}, 
                        {1, 1, 1}, 
                        {1, 1, 1}, 
                        };
        // This is the source where the the rat starts its journey
        Pair source = new Pair(0, 0);
        // This is the deestination where the the rat journey ends
        Pair destination = new Pair(2, 2);
        System.out.println("Can the rat reach the destination ? : " + isPathExist(maze, source, destination));
        System.out.println("Total Paths : " + allPathsCount(maze, source, destination));
        return;
    }

    public static int allPathsCount(int[][] maze, Pair source, Pair destination) {
        int noOfWays = 0;
        // All the values are filled with false by default
        visited = new boolean[maze.length][maze[0].length];
        // Create a queue of Pair class (Pair - Wrapper class)
        // Use this queue to store the paths
        Queue<Pair> queue = new LinkedList<Pair>();
        // Add the source to the queue
        queue.add(source);
        // When the queue is not empty -> Exhaust all the paths
        while(queue.size() > 0) {
            // Queue contains current pair, current pair -> i, j
            // Current pair[0] = i
            // Cuurent pair[1] = j
            // peek() method is used to get the first/head element of the linked list
            Pair currentPair = queue.peek();
            // System.out.println("current row : " + currentPair.row + " current Column : " + currentPair.column + " <-> destination row : " + destination.row + " destination Column : " + destination.column);
            // Removes the head of the linked list
            queue.poll();
            visited[currentPair.row][currentPair.column] = true;
            // Check if the rat has reached its destination
            if(currentPair.row == destination.row && currentPair.column == destination.column) {
                System.out.println("Reached the destination");
                noOfWays++;
            }
            // Check for all possible paths - Backtrack
            for (int[] direction : directions) {
                int row = currentPair.row + direction[0];
                int column = currentPair.column + direction[1];
                // Check for boundary conditions
                if(row >= 0 && row <= destination.row && column >= 0 && column <= destination.column && maze[row][column] != -1 && visited[row][column] == false) {
                    queue.add(new Pair(row, column));
                }
            }
        }
        return noOfWays;
    }
    public static boolean isPathExist(int[][] maze, Pair source, Pair destination) {
        // All the values are filled with false by default
        visited = new boolean[maze.length][maze[0].length];
        // Create a queue of Pair class (Pair - Wrapper class)
        // Use this queue to store the paths
        Queue<Pair> queue = new LinkedList<Pair>();
        // Add the source to the queue
        queue.add(source);
        // When the queue is not empty -> Exhaust all the paths
        while(queue.size() > 0) {
            // Queue contains current pair, current pair -> i, j
            // Current pair[0] = i
            // Cuurent pair[1] = j
            // peek() method is used to get the first/head element of the linked list
            Pair currentPair = queue.peek();
            // System.out.println("current row : " + currentPair.row + " current Column : " + currentPair.column + " <-> destination row : " + destination.row + " destination Column : " + destination.column);
            // Removes the head of the linked list
            queue.poll();
            visited[currentPair.row][currentPair.column] = true;
            // Check if the rat has reached its destination
            if(currentPair.row == destination.row && currentPair.column == destination.column) {
                System.out.println("Reached the destination");
                return true;
            }
            // Check for all possible paths - Backtrack
            for (int[] direction : directions) {
                int row = currentPair.row + direction[0];
                int column = currentPair.column + direction[1];
                // Check for boundary conditions
                if(row >= 0 && row <= destination.row && column >= 0 && column <= destination.column && maze[row][column] != -1 && visited[row][column] == false) {
                    queue.add(new Pair(row, column));
                }
            }
        }
        return false;
    }
}

class Pair {
    /* 
     * This is a wrapper class
     * row : Stores the row value
     * column : Stores the column value
    */
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
