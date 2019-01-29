package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/clone-graph/description/
public class CloneGraph {
	/**
	 * Definition for undirected graph. class UndirectedGraphNode { int label;
	 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
	 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
	 */

	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		public UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return node;
		Set<UndirectedGraphNode> visited = new HashSet<>();
		Map<Integer, List<UndirectedGraphNode>> map = new HashMap<>();
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			if (!visited.contains(n)) {
				visited.add(n);
				List<UndirectedGraphNode> childs = n.neighbors == null ? Collections.emptyList() : n.neighbors;
				for (UndirectedGraphNode n1 : childs)
					queue.offer(n1);
				map.put(n.label, childs);

			}

		}

		Map<Integer, UndirectedGraphNode> map2 = new HashMap<>();
		// creating call head
		for (int n2 : map.keySet()) {
			map2.put(n2, new UndirectedGraphNode(n2));

		}

		// now time to create edges

		for (int n2 : map.keySet()) {
			List<UndirectedGraphNode> list = map.get(n2);
			UndirectedGraphNode vertices = map2.get(n2);
			List<UndirectedGraphNode> edges = new ArrayList<>();
			for (UndirectedGraphNode temp : list) {
				edges.add(map2.get(temp.label));
			}
			vertices.neighbors = edges;
		}

		return map2.get(node.label);
	}

	public UndirectedGraphNode cloneGraphUsingDFS(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return callDFS(map, node);
	}

	private UndirectedGraphNode callDFS(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node) {

		//let's create head 
		if(!map.containsKey(node))
		{
			map.put(node, new UndirectedGraphNode(node.label));
			node.neighbors.forEach(ud->callDFS(map, ud));
		}
		// now we need to update the neighbors
		map.forEach((k,v)->{
			List<UndirectedGraphNode> childs=new ArrayList<>();
			k.neighbors.forEach(ud->{
				childs.add(map.get(ud));
				
			});
			v.neighbors=childs;
		});
		
		return map.get(node);
	}

	
	
	
	public void printNodeTree(UndirectedGraphNode node) {
		LinkedList<UndirectedGraphNode> queue = new LinkedList<>();		
		Set<UndirectedGraphNode> visited=new TreeSet<>(( o1, o2)->o1.label-o2.label);
		
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			if (!visited.contains(node)) {
				visited.add(node);
				if (null != node.neighbors) {
					for (UndirectedGraphNode uni : node.neighbors) {
						queue.offer(uni);
					}
				}
			}
		}
		// now time to print
		for (UndirectedGraphNode uni : visited) {
			System.out.print(uni.label + " ");
			if (null != uni.neighbors) {
				for (UndirectedGraphNode un : uni.neighbors) {
					System.out.print(un.label + " ");
				}
				System.out.print("#");
			}
		}
	}

	public static void main(String[] args) {

		UndirectedGraphNode node1 = new UndirectedGraphNode(0);
		UndirectedGraphNode node2 = new UndirectedGraphNode(1);
		UndirectedGraphNode node3 = new UndirectedGraphNode(2);
		node1.neighbors = Arrays.asList(node2);
		node2.neighbors = Arrays.asList(node3);
		node3.neighbors = Arrays.asList(node3);
		
		CloneGraph cg = new CloneGraph();
		cg.printNodeTree(node1);
		System.out.println();
		cg.printNodeTree(cg.cloneGraph(node1));
		System.out.println();
		cg.printNodeTree(cg.cloneGraphUsingDFS(node1));
	}

}
