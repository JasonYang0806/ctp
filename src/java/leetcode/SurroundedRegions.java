// DFS version, but can not pass the "Judge Large" because of the "Runtime Error".
public class Solution {
    // Fields
    private int rowNum, colNum;
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // 1. DFS version solution
        if(board == null || board.length == 0){
            return;
        }
        
        rowNum = board.length;
        colNum = board[0].length;
        
        for(int i = 0; i < rowNum; i++){
            dfs(board, i, 0);
            dfs(board, i, colNum - 1);
        }
        for(int j = 0; j < colNum; j++){
            dfs(board, 0, j);
            dfs(board, rowNum - 1, j);
        }
        
        // Final check.
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        if(i < 0 || i >= rowNum || j < 0 || j >= colNum || board[i][j] != 'O'){
            return;
        }else{
            board[i][j] = '#';
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
        }
    }
}

// 2. BFS version
public class Solution{
    // Fields
    int rowNum, colNum;

    public void solve(char[][] board){
        if(board == null || board.length == 0){
            return;
        }
        
        rowNum = board.length;
        colNum = board[0].length;
        
        for(int i = 0; i < rowNum; i++){
            bfs(board, i, 0);
            bfs(board, i, colNum - 1);
        }
        for(int j = 0; j < colNum; j++){
            bfs(board, 0, j);
            bfs(board, rowNum - 1, j);
        }

        // Final check.
        for(int i = 0; i < rowNum; i++){
            for(int j = 0; j < colNum; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j){
        int tmpIndex, x, y;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * colNum + j);
        while(!queue.isEmpty()){
            tmpIndex = queue.poll();
            x = tmpIndex / colNum;
            y = tmpIndex % colNum;
            visit(board, queue, x, y);
        }
    }

    private void visit(char[][] board, Queue<Integer> queue, int x, int y){
        if(x < 0 || x >= rowNum || y < 0 || y >= colNum || board[x][y] != 'O'){
            return;
        }else{
            board[x][y] = '#';
            queue.offer(x * colNum + y - 1);
            queue.offer(x * colNum + y + 1);
            queue.offer((x - 1) * colNum + y);
            queue.offer((x + 1) * colNum + y);
        }
    }
}