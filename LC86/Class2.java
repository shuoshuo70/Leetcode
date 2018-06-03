package LC86;

import java.util.*;

public class Class2 {
    public static void main(String[] args) {
        Class2 solution = new Class2();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
        rooms.add(new ArrayList<>(Arrays.asList(3,0,1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(0));
        System.out.println(solution.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        Set<Integer> keys = new HashSet<>();
        Queue<Integer> needVisited = new LinkedList<>();
        needVisited.add(0);
        keys.add(0);

        while (!needVisited.isEmpty()) {
            int nextRoom = needVisited.poll();
            List<Integer> newKeys = rooms.get(nextRoom);
            for (int newKey : newKeys) {
                if (keys.add(newKey)) {
                    needVisited.add(newKey);
                }
            }
        }

        return keys.size() == N;
    }
}
