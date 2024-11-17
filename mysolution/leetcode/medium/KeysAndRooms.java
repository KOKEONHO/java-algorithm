package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

  boolean[] visited;
  Set<Integer> availableRooms = new HashSet<>();

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    visited = new boolean[rooms.size()];

    dfs(rooms, 0);

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;

  }

  private void dfs(List<List<Integer>> rooms, int room) {
    visited[room] = true;
    List<Integer> keys = rooms.get(room);
    for (int key : keys) {
      if (!availableRooms.contains(key) && !visited[key]) {
        availableRooms.add(key);
        dfs(rooms, key);
      }
    }
  }

}
