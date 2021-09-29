package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_최단경로_Solution_개선된다익스트라 {
	static int V, E, K;
	static int INF; // 도달할 수 없음을 표시
	static int[] minDist;
	static boolean[] visited;
	static LinkedList<Node>[] adjList; // 인접 리스트 ([from][to])

	static class Node implements Comparable<Node>{
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adjList = new LinkedList[V + 1]; // 1 ~ V
		minDist = new int[V + 1];
		visited = new boolean[V + 1];
		INF = 10 * E + 1;
		// 링크드 리스트 객체 생성
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<>();
		}

		K = Integer.parseInt(br.readLine());
		int from, to, weight;
		/////////////////// 간선 입력///////////////////
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			// 이미 같은 출발, 목적지의 간선 존재하나 확인
//			int j;
//			for (j = 0; j < adjList[from].size(); j++) {
//				Node curNode = adjList[from].get(j);
//				if (curNode.vertex == to) {
//					if (curNode.weight > weight) {
//						// 이때만 더 작은 가중치로 업뎃
//						curNode.weight = weight;
//					}
//					break;
//				}
//			}
//			// 같은 vertex를 만났다면 빠져나왔을 테고, 내가 처음이라면 안빠져나왔음
//			if (j == adjList[from].size())
				adjList[from].addFirst(new Node(to, weight));
		}
		///////// 출발지로부터의 최소 거리 초기화////////////
		for (int i = 1; i <= V; i++) {
			minDist[i] = INF;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(K, 0));
		minDist[K] = 0;
		// K부터 출발 -> 모든 정점을 방문할 때까지
		while (!pq.isEmpty()) {
			// 1. 현재 방문 지점 (갸장 가까운 곳)
			Node currentNode = pq.poll();
			int current = currentNode.vertex;
			int min = currentNode.weight;

			if (visited[current]) {
				continue;
			}
			// 2. 현재 방문 지점 기준으로 업데이트 하기.
			visited[current] = true;
			for (Node curNode : adjList[current]) {
				if (!visited[curNode.vertex] && minDist[curNode.vertex] > curNode.weight + min) {
					minDist[curNode.vertex] = curNode.weight + min;
					pq.add(new Node(curNode.vertex, minDist[curNode.vertex]));
				}
			}
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 1; i <= V; i++) {
			if (minDist[i] == INF)
				sb.append("INF");
			else
				sb.append(minDist[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}