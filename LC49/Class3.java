/**
 * You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:

0 represents the obstacle can't be reached.
1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).

You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.

You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.

Example 1:
Input: 
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input: 
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input: 
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Class3 {
	private static int[][] directs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.size() == 0) {
            return 0;
        }
        
        PriorityQueue<Tree> pq = new PriorityQueue<>(new Comparator<Tree>() {
            @Override
            public int compare(Tree t1, Tree t2) {
                return t1.h - t2.h;
            }
        });
        
        //store and sort tree (h > 0)
        for (int i = 0; i < forest.size(); i++) {
            for(int j = 0; j < forest.get(i).size(); j++) {
                int h = forest.get(i).get(j);
                if(h > 0) {
                    pq.offer(new Tree(i, j, h));
                }  
            }
        }
        
        int cnt = 0;
        Tree cur = new Tree(0, 0, 1);
        while(!pq.isEmpty()) {
            Tree next = pq.poll();
            
            boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
            int steps = canReach(cur.x, cur.y, next, forest, visited);
            if(steps == - 1) {
                return -1;
            }
            
            cnt += steps;
            cur = next;
        }
        
        return cnt;
    }
    
    //BFS
    private int canReach(int x, int y, Tree next, List<List<Integer>> forest, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int steps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for (int i=0; i<size; i++) {
                int[] cur = q.poll();
                if(next.x == cur[0] && next.y == cur[1]) {
                    return steps; 
                }
                
                for(int[] direct : directs) {
                    int nx = cur[0] + direct[0];
                    int ny = cur[1] + direct[1];
                    
                    if(nx >=0 && nx < forest.size() && ny >= 0 && ny < forest.get(nx).size() && forest.get(nx).get(ny) > 0 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }  
            
            steps++;
        }
        
        return -1;
    }
}

class Tree {
    int x;
    int y;
    int h;
    
    Tree(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}