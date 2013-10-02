package ctci.Chapter9;

/**
 * @author JasonYang
 * Subject: Implement the "paint fill" function that one might see on many image editing 
 * 			programs. That is, given a screen (represented by a two-dimensional array of colors),
 * 			a point, and a new color, fill in the surrounding area until teh color changes from the 
 * 			original color.
 */
public class CtCI_9_7 {
	public static void main(String[] args){
		Color[][] screen = {
							{Color.BLUE, Color.GREEN, Color.WHITE, Color.WHITE},
							{Color.WHITE, Color.BLUE, Color.BLUE, Color.GREEN},
							{Color.BLUE, Color.BLUE, Color.BLUE, Color.GREEN},
							{Color.BLACK, Color.BLACK, Color.WHITE, Color.BLUE}
		};
		
		paintFill(screen, 1, 2, Color.RED);
		
		for(Color[] colorArray : screen){
			for(Color color : colorArray){
				System.out.print(color + "  ");
			}
			System.out.println();
		}
	}
	
	private static void paintFill(Color[][] screen, int x, int y, Color nColor){
		_paintFill(screen, y, x, Color.RED, screen[y][x]);
	}
	
	private static void _paintFill(Color[][] screen, int x, int y, Color nColor, Color oColor){
		if(screen == null || screen.length == 0){
			return;
		}
		
		if(x < 0 || x >= screen.length || y < 0 || y >= screen[0].length){
			return;
		}
		
		if(screen[x][y] == oColor){
			screen[x][y] = nColor;
			_paintFill(screen, x - 1, y, nColor, oColor);
			_paintFill(screen, x + 1, y, nColor, oColor);
			_paintFill(screen, x, y - 1, nColor, oColor);
			_paintFill(screen, x, y + 1, nColor, oColor);
		}
	}
}
