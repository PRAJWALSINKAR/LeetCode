import java.util.*;

// We need to manage tasks with priority for each user
// Operations: add, edit, remove, execute top-priority task
class TaskManager {

    // PriorityQueue to always get the task with the highest priority
    // Each element = {priority, taskId, userId}
    private PriorityQueue<int[]> pq;

    // taskId -> priority (to check if the task is still valid)
    private Map<Integer, Integer> taskPriority;

    // taskId -> userId (to know which user owns the task)
    private Map<Integer, Integer> taskOwner;

    // ✅ Constructor: preload tasks list (each inner list = [userId, taskId, priority])
    public TaskManager(List<List<Integer>> tasks) {
        // info: comparator -> priority desc, then taskId desc (larger taskId wins), then userId asc
        pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(b[0], a[0]); // priority desc
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]); // taskId desc (important tie-breaker)
            return Integer.compare(a[2], b[2]);                    // userId asc (final tie-breaker)
        });

        taskPriority = new HashMap<>();
        taskOwner = new HashMap<>();

        // info: preload given tasks into pq + maps (guard null)
        if (tasks != null) {
            for (List<Integer> t : tasks) {
                int userId = t.get(0);
                int taskId = t.get(1);
                int priority = t.get(2);
                pq.offer(new int[]{priority, taskId, userId}); // info: store userId for final return
                taskPriority.put(taskId, priority);
                taskOwner.put(taskId, userId);
            }
        }
    }

    // ➕ Add a new task
    public void add(int userId, int taskId, int priority) {
        // info: push (priority, taskId, userId) into pq and update maps
        pq.offer(new int[]{priority, taskId, userId});
        taskPriority.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    // ✏️ Edit task priority
    public void edit(int taskId, int newPriority) {
        // info: include the current owner when pushing updated entry
        int userId = taskOwner.getOrDefault(taskId, -1);
        pq.offer(new int[]{newPriority, taskId, userId}); // info: push new version into heap
        taskPriority.put(taskId, newPriority);             // info: update latest priority
    }

    // ❌ Remove task
    public void rmv(int taskId) {
        // info: mark as invalid by setting priority to -1
        taskPriority.put(taskId, -1);
    }

    // ⚡ Execute top-priority task
    public int execTop() {
        while (!pq.isEmpty()) {
            int[] task = pq.poll();
            int priority = task[0];
            int id = task[1];
            int userId = task[2];

            // info: only execute if this heap entry matches the latest maps
            // This avoids stale entries from previous edits/removes.
            if (taskPriority.getOrDefault(id, -1) == priority
                    && taskOwner.getOrDefault(id, -1) == userId) {
                taskPriority.put(id, -1); // info: mark executed
                return userId;            // info: return user who owns the task
            }
            // otherwise it's stale — continue popping
        }
        return -1; // info: no valid tasks left
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
