class Solution {
    public int amountOfTime(TreeNode root, int start) {

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        Map<TreeNode, TreeNode> parent = new HashMap<>();//node , parent
        parent.put(root, null); // CHANGED: map root -> null instead of root->root

        TreeNode x = null; // CHANGED: don't create a new node; find real start node
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null) {
                parent.put(node.left, node);
                que.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                que.add(node.right);
            }
            if (node.val == start)
                x = node;
        }

        // if start not found (defensive) — though problem guarantees it exists
        if (x == null) return 0;

        Set<TreeNode> visited = new HashSet<>();
        visited.add(x);

        que.add(x);
        int time = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            boolean spread = false; // CHANGED: track whether infection spreads this minute

            while (len > 0) {
                TreeNode temp = que.poll();

                // parent (use parent map)
                TreeNode par = parent.get(temp);
                if (par != null && !visited.contains(par)) { // CHANGED: check visited before adding
                    visited.add(par);
                    que.add(par);
                    spread = true;
                }

                // left
                if (temp.left != null && !visited.contains(temp.left)) { // CHANGED: check visited
                    visited.add(temp.left);
                    que.add(temp.left);
                    spread = true;
                }

                // right
                if (temp.right != null && !visited.contains(temp.right)) { // CHANGED: check visited
                    visited.add(temp.right);
                    que.add(temp.right);
                    spread = true;
                }

                len--;
            }

            if (spread) time++; // CHANGED: increment time only if we actually spread
        }
        return time;
    }
}
