class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V = adj.size();
        boolean[]  visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfsUtil(i, adj,visited, result);
            }
        }
        
        return result;
        
    }
    
    
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result){
        visited[node] = true;
        result.add(node);
        
        for(int nei: adj.get(node)){
            if(!visited[nei]){
                dfsUtil(nei, adj, visited, result);
            }
        }
        
        
    }
}