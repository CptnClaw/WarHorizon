package map;

public class Map 
{
	
	// Create an empty map
	public Map(int height, int width, boolean isDefaultWater, boolean isSurrroundWater)
	{
		// Create base with requested size
		this.isSurroundWater = isSurrroundWater;
		this.height = height;
		this.width = width;
		base = new boolean[height][width];
		
		// Fill base with default value (water or land)
		for (int iRow = 0; iRow < height; ++iRow)
		{
			for (int iCol = 0; iCol < width; ++iCol)
			{
				base[iRow][iCol] = !isDefaultWater;
			}
		}
	}
	
	// Load map from a file
	public Map(String filePath)
	{
		// TODO : Implement map loading from file
	}
	
	boolean isLand(int y, int x)
	{
		return base[y][x];
	}
	
	void setLand(int y, int x, boolean isLand)
	{
		base[y][x] = isLand;
	}
	
	byte getTile(int y, int x)
	{
		// Create mask for corners detection
		int[][] mask = {{8, 16, 1}, {128, 0, 32}, {4, 64, 2}};
		
		// Calculate corners by applying the mask
		int startX = x - 1;
		int endX = x + 1;
		int startY = y - 1;
		int endY = y + 1;
		
		int sum = 0;
		for (int iRow = startY, iMaskRow = 0; iRow <= endY; ++iRow, ++iMaskRow)
		{
			for (int iCol = startX, iMaskCol = 0; iCol <= endX; ++iCol, ++iMaskCol)
			{
				int isLand;
				if (iRow < 0 || iRow >= width || iCol < 0 || iCol >= height)
				{
					// Out of scope
					isLand = isSurroundWater ? 0 : 1; 
				}
				else
				{
					isLand = base[iRow][iCol] ? 1 : 0;
				}
				sum += (isLand * mask[iMaskRow][iMaskCol]);
			}
		}
		
		return cornerToTileConverter[sum];
	}
	
	// Bitmap of the base - true is land and false is water
	private boolean[][] base;
	
	private int height, width;
	
	private boolean isSurroundWater;
	
	// These values are returned in getTile() according to corners found and data/images/references/CornersReference.png
	byte[] cornerToTileConverter = {47, 44, 36, 43, 37, 14, 35,
									32, 45, 34, 15, 40, 42, 41,
									33, 38, 28, 28, 27, 27, 26,
									26, 23, 23, 28, 28, 27, 27,
									26, 26, 23, 23, 21, 21, 21,
									21, 24, 24, 24, 24, 16, 16,
									16, 16, 30, 30, 30, 30, 1,
									1,  1,  1,  3,  3,  3,  3,
									1,  1,  1,  1,  3,  3,  3,
									3,  29, 19, 29, 19, 29, 19,
									29, 19, 18, 22, 18, 22, 18,
									22, 18, 22, 7,  7,  7,  7,
									7,  7,  7,  7,  7,  7,  7,
									7,  7,  7,  7,  7,  9,  9,
									9,  9,  9,  9,  9,  9,  11,
									11, 11, 11, 11, 11, 11, 11,
									13, 13, 13, 13, 13, 13, 13,
									13, 13, 13, 13, 13, 13, 13,
									13, 13, 20, 17, 25, 31, 20,
									17, 25, 31, 20, 17, 25, 31,
									20, 17, 25, 31, 0,  0,  2, 
									2,  0,  0,  2,  2,  0,  0,
									2,  2,  0,  0,  2,  2,  6,
									6,  6,  6,  6,  6,  6,  6,
									6,  6,  6,  6,  6,  6,  6,
									6,  5,  5,  5,  5,  5,  5,
									5,  5,  5,  5,  5,  5,  5,
									5,  5,  5,  10, 8,  10, 8,
									10, 8,  10, 8,  10, 8,  10,
									8,  10, 8,  10, 8,  12, 12,
									12, 12, 12, 12, 12, 12, 12,
									12, 12, 12, 12, 12, 12, 12,
									4,  4,  4,  4,  4,  4,  4,
									4,  4,  4,  4,  4,  4,  4,
									4,  4,  46, 46, 46, 46, 46,
									46, 46, 46, 46, 46, 46, 46,
									46, 46, 46, 46};
	
}
