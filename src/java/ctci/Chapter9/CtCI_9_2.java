package CTCI_Chapter_9;

/**
 * @author Jason 
 *
 * Subject: Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can 
 * 			only move in two directions: right and down. How many possible paths are there for
 * 			the robot to go from (0, 0) to (X, Y)?
 * 			FOLLOW UP
 * 			Imagine certain spots are "off limits", such that the robot cannot step on them.
 * 			Design an algorithm to find a path for the robot from top left to the bottom right.	
 */

import java.util.LinkedList;

public class CtCI_9_2 {
	private static long[][] pathNum;
	
	public static void main(String[] args){
		//System.out.println(pathNumRecursion(20, 15));
		//System.out.println(pathNumDP(100, 100));
//		int[][] offLimitSpot = {
//								{0, 0, 0},
//								{0, 0, 1},
//								{1, 0, 0},
//								{0, 0, 0}
//								};
//		System.out.println(pathNumOffLimitSpot(3, 2, offLimitSpot));
//		LinkedList<LinkedList<Point>> pathList = new LinkedList<LinkedList<Point>>();
//		LinkedList<Point> path = new LinkedList<Point>();
//		_pathTrack(3, 3, path, pathList);
//		for(LinkedList<Point> _path: pathList){
//			printList(_path);
//		}
//		System.out.println(pathList.size());
		
		int[][] offLimitSpot = {
								{0, 1, 1, 0},
								{0, 0, 0, 0},
								{1, 0, 0, 1},
								{0, 1, 0, 0}
		};
		
		LinkedList<LinkedList<Point>> pathList = new LinkedList<LinkedList<Point>>();
		LinkedList<Point> path = new LinkedList<Point>();
		_pathTrackOffLimitSpot(3, 3, path, pathList, offLimitSpot);
		for(LinkedList<Point> _path: pathList){
			printList(_path);
		}
		System.out.println(pathList.size());

	}
	
	private static long pathNumRecursion(int X, int Y){
		if(X < 0 || Y < 0){
			return 0;
		}else if(X == 0 || Y == 0){
			return 1;
		}else{
			return pathNumRecursion(X - 1, Y) + pathNumRecursion(X, Y - 1);
		}
	}
	
	private static long pathNumDP(int X, int Y){
		pathNum = new long[X + 1][Y + 1];
		for(int i = 0; i <= X; i++){
			for(int j = 0; j <= Y; j++){
				pathNum[i][j] = -1;
			}
		}
		return _pathNumDP(X, Y);
	}
	
	private static long _pathNumDP(int X, int Y){
		if(X < 0 || Y < 0){
			return 0;
		}else if(X == 0 || Y == 0){
			pathNum[X][Y] = 1;
			return pathNum[X][Y];
		}else if(pathNum[X][Y] != -1){
			return pathNum[X][Y];
		}else{
			pathNum[X][Y] = _pathNumDP(X - 1, Y) + 
							_pathNumDP(X, Y - 1);
			return pathNum[X][Y];
		}
	}
	
	private static long pathNumOffLimitSpot(int X, int Y, int[][] offLimitSpot){
		pathNum = new long[X + 1][Y + 1];
		for(int i = 0; i <= X; i++){
			for(int j = 0; j <= Y; j++){
				pathNum[i][j] = -1;
			}
		}
		
		return _pathNumOffLimitSpot(X, Y, offLimitSpot);
	}
	
	private static long _pathNumOffLimitSpot(int X, int Y, int[][] offLimitSpot){
		if(X < 0 || Y < 0){
			return 0;
		}else if(offLimitSpot[X][Y] == 1){
			pathNum[X][Y] = 0;
			return pathNum[X][Y];
		}else if(X == 0 || Y == 0){
			pathNum[X][Y] = 1;
			return pathNum[X][Y];
		}else if(pathNum[X][Y] != -1){
			return pathNum[X][Y];
		}else{
			pathNum[X][Y] = _pathNumOffLimitSpot(X - 1, Y, offLimitSpot) + 
							_pathNumOffLimitSpot(X, Y - 1, offLimitSpot);
			return pathNum[X][Y];
		}
	}
	
	private static void pathTrack(int X, int Y, LinkedList<Point> path, LinkedList<LinkedList<Point>> pathList){
		if(X < 0 || Y < 0){
			return;
		}
		
		path.add(new Point(X, Y));
		if(X == 0 && Y == 0){
			pathList.add(path);
		}else if(X == 0){
			pathTrack(X, Y - 1, path, pathList);
		}else if(Y == 0){
			pathTrack(X - 1, Y, path, pathList);
		}else{
			LinkedList<Point> tmpPoint = (LinkedList<Point>)path.clone();
			pathTrack(X, Y - 1, path, pathList);
			pathTrack(X - 1, Y, tmpPoint, pathList);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void _pathTrack(int X, int Y, LinkedList<Point> path, LinkedList<LinkedList<Point>> pathList){
		if(X < 0 || Y < 0){
			return;
		}
		
		path.add(new Point(X, Y));
		if(X == 0 && Y == 0){
			pathList.add((LinkedList<Point>)path.clone());
		}
		
		if(X >= 1){
			_pathTrack(X - 1, Y, path, pathList);
		}
		
		if(Y >= 1){
			_pathTrack(X, Y - 1, path, pathList);
		}
		/**
		 * The reason why do this is as following:
		 * 1. We only use one LinkedList<Point> typed variable, and clone the linkedList when adding it to pathList.
		 * 2. So after 
		 */
		path.remove(path.size() - 1);
	}
	
	@SuppressWarnings("unchecked")
	private static void _pathTrackOffLimitSpot(int X, int Y, LinkedList<Point> path, LinkedList<LinkedList<Point>> pathList, int[][] offLimitSpot){
		if(X < 0 || Y < 0){
			return;
		}
		if(offLimitSpot[X][Y] == 0){
			path.add(new Point(X, Y));
			if(X == 0 && Y == 0 && offLimitSpot[X][Y] == 0){
				pathList.add((LinkedList<Point>)path.clone());
			}
				
			if(X >= 1 && offLimitSpot[X - 1][Y] == 0){
				_pathTrackOffLimitSpot(X - 1, Y, path, pathList, offLimitSpot);
			}
			
			if(Y >= 1 && offLimitSpot[X][Y - 1] == 0){
				_pathTrackOffLimitSpot(X, Y - 1, path, pathList, offLimitSpot);
			}
			/**
			 * The reason why do this is as following:
			 * 1. We only use one LinkedList<Point> typed variable, and clone the linkedList when adding it to pathList.
			 * 2. So after 
			 */
			path.remove(path.size() - 1);
		}
		
	}
	
	private static void printList(LinkedList<Point> path){
		System.out.print("{");
		for(Point _path : path){
			System.out.print("(" + _path.getX() + ", " + _path.getY() + "), ");
		}
		System.out.println("}");
	}
	
}	
