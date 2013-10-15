import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Queue;
import java.util.LinkedList;

public class Poly_Scramble {
	private int rowNum;
	private int columnNum;
	
	private String[] solve(char[][] matrix, String[] dict){
		assert(matrix != null && matrix.length > 0 && matrix[0].length > 0);
		assert(dict != null && dict.length > 0);
		rowNum = matrix.length;
		columnNum = matrix[0].length;
		// 1. put the dictionary into a hash set to accelerate the searching_in_dict process.
		Set<String> dictionary = new HashSet<String>();
		for(String str : dict){
			dictionary.add(str);
		}
		SortedSet<String> result = new TreeSet<String>();
		// Any improvement possibility? without invoke dfs n^2 times.
		for(int i = 0; i < rowNum; i++){
			for(int j = 0; j < columnNum; j++){
				dfs(matrix, "", result, dictionary, new boolean[rowNum][columnNum], i, j);
				// bfs not work for this problem, because the graph has circle inside.
				//bfs(matrix, "", result, dictionary, new boolean[rowNum][columnNum], i, j);
			}
		}
		String[] res = new String[result.size()];
		int index = 0;
		for(String str : result){
			res[index++] = str;
		}
		return res;
	}
	
	private void dfs(char[][] matrix, String word, SortedSet<String> res, 
			Set<String> dict, boolean[][] visited, int x, int y){
		if( x < 0 || x >= rowNum || 
				y < 0 || y >= columnNum || visited[x][y]){
			return;
		}
		String nWord = word + matrix[x][y];
		if(dict.contains(nWord)){
			res.add(nWord);
		}
		visited[x][y] = true;
		
		dfs(matrix, nWord, res, dict, visited, x - 1, y);
		dfs(matrix, nWord, res, dict, visited, x + 1, y);
		dfs(matrix, nWord, res, dict, visited, x, y - 1);
		dfs(matrix, nWord, res, dict, visited, x, y + 1);
		dfs(matrix, nWord, res, dict, visited, x - 1, y - 1);
		dfs(matrix, nWord, res, dict, visited, x - 1, y + 1);
		dfs(matrix, nWord, res, dict, visited, x + 1, y - 1);
		dfs(matrix, nWord, res, dict, visited, x + 1, y + 1);
		visited[x][y] = false;
	}
	
	private void bfs(char[][] matrix, String word, SortedSet<String> res, 
			Set<String> dict, boolean[][] visited, int x, int y){
		if(x < 0 || x >= rowNum || y < 0 || y > columnNum){
			return;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(x * rowNum + y);
		while(!queue.isEmpty()){
			int tmp = queue.poll();
			int xIndex = tmp / rowNum;
			int yIndex = tmp % rowNum;
			if(!visited[xIndex][yIndex]){
				word = word + matrix[xIndex][yIndex];
				System.out.println(word);
				if(dict.contains(word)){
					res.add(word);
				}
				visited[xIndex][yIndex] = true;
				if(x - 1 >= 0){
					queue.offer((x - 1) * rowNum + y);
				}
				if(x + 1 < rowNum){
					queue.offer((x + 1) * rowNum + y);
				}
				if(y - 1 >= 0){
					queue.offer(x * rowNum + y - 1);
				}
				if(y + 1 < columnNum){
					queue.offer(x * rowNum + y + 1);
				}
				if(x - 1 >= 0 && y - 1 >= 0){
					queue.offer((x - 1) * rowNum + y - 1);
				}
				if(x + 1 < rowNum && y - 1 >= 0){
					queue.offer((x + 1) * rowNum + y - 1);
				}
				if(x - 1 >= 0 && y + 1 < columnNum){
					queue.offer((x - 1) * rowNum + y + 1);
				}
				if(x + 1 < rowNum && y + 1 < columnNum){
					queue.offer((x + 1) * rowNum + y + 1);
				}
			}
		}
	}
	
	public static void main(String[] args){
		Poly_Scramble test = new Poly_Scramble();
		char[][] matrix = { {'o', 'c'},
												{'b', 'a'}};
		String[] dict = {"cao", "condom", "cab", "sexy", "scramble"};
		String[] res = test.solve(matrix, dict);
		for(String str : res){
			System.out.println(str);
		}
	}
}
