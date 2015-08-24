import java.util.Arrays;

@SuppressWarnings("unused")
public class SpiralNumberMatrix {
	private int m;
	private int n;
	private int current = 0;
	private Direction direction = Direction.RIGHT;
	
	private Integer[][] matrix;
	
	public SpiralNumberMatrix(int m, int n) {
		super();
		this.m = m;
		this.n = n;
		
		matrix = new Integer[n][m];
		
		//populateNumber(-1, 0);
		populateNumbers();
	}
	
	private boolean populateNumber(int x, int y) {
		y += direction.dY;
		x += direction.dX;

		if (y >= 0 && y < n && x >= 0 && x < m && matrix[y][x] == null) {
			matrix[y][x] = ++current;

			if (current < n * m) {
				while (!populateNumber(x, y)) {
					direction = direction.getNext();
				}
			}
			return true;
		}
		return false;
	}
	
	private void populateNumbers() {
		int x = -1;
		int y = 0;
		
		for (int i = 1; i <= n*m; i++) {
			y += direction.dY;
			x += direction.dX;

			while (!(y >= 0 && y < n && x >= 0 && x < m && matrix[y][x] == null)) {
				y -= direction.dY;
				x -= direction.dX;
				direction = direction.getNext();
				y += direction.dY;
				x += direction.dX;
			}
			matrix[y][x] = i;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int maxLen = String.valueOf(m*n).length() + 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j ++) {
				String s = "            " + matrix[i][j];
				sb.append(s.substring(s.length() - maxLen, s.length()));
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SpiralNumberMatrix snm = new SpiralNumberMatrix(150, 150);
		System.out.println(snm.toString());
	}
	
	public enum Direction {
		RIGHT (1, 0),
		DOWN (0, 1),
		LEFT (-1, 0),
		UP (0, -1);
		
		public int dX;
		public int dY;
		
		private Direction (int dX, int dY) {
			this.dX = dX;
			this.dY = dY;
		}
		
		public Direction getNext () {
			return values()[(ordinal() + 1) % values().length]; 
		}
		
	}

}
