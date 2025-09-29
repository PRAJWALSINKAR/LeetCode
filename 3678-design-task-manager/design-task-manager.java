class TaskManager {
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> taskOwner;
    Map<Integer, Integer> taskPriority;

    public TaskManager(List<List<Integer>> tasks) {

        pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2])
                return Integer.compare(b[2], a[2]); // priority desc
            if (a[1] != b[1])
                return Integer.compare(b[1], a[1]); // taskId desc
            return Integer.compare(a[0], b[0]); // userId asc
        });

        taskOwner = new HashMap<>();
        taskPriority = new HashMap<>();

        for (List<Integer> tsk : tasks) {
            add(tsk.get(0), tsk.get(1), tsk.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        pq.offer(new int[] { userId, taskId, priority });
        taskOwner.put(taskId, userId);
        taskPriority.put(taskId, priority);
    }

    public void edit(int taskId, int newPriority) {

        int user = taskOwner.get(taskId);
        pq.offer(new int[] { user, taskId, newPriority });
        taskPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskPriority.put(taskId, -1);

    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int user = arr[0], task = arr[1], priority = arr[2];

            Integer curP = taskPriority.get(task);
            Integer curOwner = taskOwner.get(task);

            // skip if task not present (defensive)
            if (curP == null || curOwner == null)
                continue;

            // accept only if both priority and owner match the current state
            if (curP == priority && curOwner == user) {
                // mark executed / removed
                taskPriority.put(task, -1);
                taskOwner.remove(task); // remove mapping so future checks are safe
                return user;
            }
            // otherwise it's an old/stale entry — continue polling
        }
        return -1;
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