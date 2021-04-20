package com.king.AiExperiment.Second;

/**
 * 
 * ClassName: MapInfo 
 * @Description: 包含地图所需的所有输入数据
 * @author kesar
 */
public class MapInfo
{
	public int[][] maps; // 二维数组的地图
	public int width; // 地图的宽
	public int hight; // 地图的高
	public com.king.AiExperiment.Second.a.Node start; // 起始结点
	public com.king.AiExperiment.Second.a.Node end; // 最终结点
	
	public MapInfo(int[][] maps, int width, int hight, com.king.AiExperiment.Second.a.Node start, com.king.AiExperiment.Second.a.Node end)
	{
		this.maps = maps;
		this.width = width;
		this.hight = hight;
		this.start = start;
		this.end = end;
	}
}
