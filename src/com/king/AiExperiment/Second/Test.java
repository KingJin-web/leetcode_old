package com.king.AiExperiment.Second;

public class Test
{

	public static void main(String[] args)
	{
		int[][] maps = {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }
				};
		com.king.AiExperiment.Second.a.MapInfo info=new com.king.AiExperiment.Second.a.MapInfo(maps,maps[0].length, maps.length,new com.king.AiExperiment.Second.a.Node(1, 1), new com.king.AiExperiment.Second.a.Node(4, 5));
		new com.king.AiExperiment.Second.a.AStar().start(info);
		printMap(maps);
	}
	
	/**
	 * 打印地图
	 */
	public static void printMap(int[][] maps)
	{
		for (int i = 0; i < maps.length; i++)
		{
			for (int j = 0; j < maps[i].length; j++)
			{
				System.out.print(maps[i][j] + " ");
			}
			System.out.println();
		}
	}

}
