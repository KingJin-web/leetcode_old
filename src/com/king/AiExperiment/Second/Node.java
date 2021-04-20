package com.king.AiExperiment.Second;

/**
 * 
 * ClassName: Node 
 * 
 * @Description: 路径结点
 * @author kesar
 */
public class Node implements Comparable<com.king.AiExperiment.Second.a.Node>
{

	public com.king.AiExperiment.Second.a.Coord coord; // 坐标
	public com.king.AiExperiment.Second.a.Node parent; // 父结点
	public int G; // G：是个准确的值，是起点到当前结点的代价
	public int H; // H：是个估值，当前结点到目的结点的估计代价

	public Node(int x, int y)
	{
		this.coord = new com.king.AiExperiment.Second.a.Coord(x, y);
	}

	public Node(com.king.AiExperiment.Second.a.Coord coord, com.king.AiExperiment.Second.a.Node parent, int g, int h)
	{
		this.coord = coord;
		this.parent = parent;
		G = g;
		H = h;
	}

	@Override
	public int compareTo(com.king.AiExperiment.Second.a.Node o)
	{
		if (o == null) return -1;
		if (G + H > o.G + o.H)
			return 1;
		else if (G + H < o.G + o.H) return -1;
		return 0;
	}
}
