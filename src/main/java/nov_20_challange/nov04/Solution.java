package nov_20_challange.nov04;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
class Solution {
    private static final int MAX_NODES = (int) (2 * Math.pow(10, 4));

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        if (n == 2) {
            return Arrays.stream(edges[0]).boxed().collect(Collectors.toList());
        }

        List<Integer> result = new ArrayList<>();
        int bestHeight = MAX_NODES;

        TreeLayer[] sortedEdges = sortEdges(n, edges);
        List<LayerInfo> layersOrder = new LinkedList<>();
        for (int i = 0; i < sortedEdges.length; i++) {
            if (sortedEdges[i] != null) {
                layersOrder.add(new LayerInfo(i, sortedEdges[i].getEdgeCount()));
            }
        }
        layersOrder.sort(Comparator.reverseOrder());
        for (LayerInfo layerInfo : layersOrder) {
            int startingPoint = layerInfo.getOrdinal();
            TreeLayer treeLayer = sortedEdges[startingPoint];
            int currentDepth = 0;
            for (Edge edge : treeLayer.getEdgeList()) {
                Set<Edge> processed = new HashSet<>();
                processed.add(edge);
                int newDepth = calculateDepth(edge.getOpposite(startingPoint), processed, sortedEdges);
                if (newDepth > currentDepth) {
                    currentDepth = newDepth;
                }
            }
            if (currentDepth < bestHeight) {
                result.clear();
                result.add(startingPoint);
                bestHeight = currentDepth;
            } else if (currentDepth == bestHeight) {
                result.add(startingPoint);
            }
        }

        return result;
    }

    private int calculateDepth(int startingPoint, Set<Edge> processed, TreeLayer[] sortedEdges) {
        int maxDepth = 0;
        TreeLayer treeLayer = sortedEdges[startingPoint];
        if (processed.containsAll(treeLayer.getEdgeList())) {
            return 1;
        }
        for (Edge edge : treeLayer.getEdgeList()) {
            if (!processed.contains(edge)) {
                Set<Edge> subprocessed = new HashSet<>(processed);
                subprocessed.add(edge);

                int newDepth = calculateDepth(edge.getOpposite(startingPoint), subprocessed, sortedEdges);
                if (newDepth > maxDepth) {
                    maxDepth = newDepth;
                }
            }
        }

        return maxDepth + 1;
    }

    private static int getBiggest(int[][] edges) {
        int max = 0;
        for (int edge = 0; edge < edges.length; edge++) {
            int[] points = edges[edge];
            for (int i = 0; i < points.length; i++) {
                int point = points[i];
                if (point > max) {
                    max = point;
                }
            }
        }
        return max + 1;
    }


    private TreeLayer[] sortEdges(int n, int[][] edges) {
        TreeLayer[] result = new TreeLayer[getBiggest(edges)];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Edge edgeObject = new Edge(edge[0], edge[1]);
            for (int point : edge) {
                TreeLayer treeLayer = result[point];
                if (treeLayer == null) {
                    treeLayer = new TreeLayer(edges.length - i);
                    result[point] = treeLayer;
                }
                treeLayer.addEdge(edgeObject);
            }
        }
        return result;
    }

    private static class LayerInfo implements Comparable<LayerInfo> {
        private final int ordinal;
        private final int size;

        LayerInfo(int ordinal, int size) {
            this.ordinal = ordinal;
            this.size = size;
        }

        public int getOrdinal() {
            return ordinal;
        }

        public int getSize() {
            return size;
        }

        @Override
        public int compareTo(LayerInfo o) {
            return size - o.getSize();
        }
    }

    private static class TreeLayer {
        private final List<Edge> edgeList;

        TreeLayer(int arraySize) {
            edgeList = new ArrayList<>(arraySize);
        }

        public List<Edge> getEdgeList() {
            return edgeList;
        }

        public void addEdge(Edge edge) {
            edgeList.add(edge);
        }

        public int getEdgeCount() {
            return edgeList.size();
        }
    }

    private static class Edge {
        private final int pointA;
        private final int pointB;
        private final int hashCode;

        Edge(int pointA, int pointB) {
            this.pointA = pointA;
            this.pointB = pointB;
            hashCode = pointA + pointB;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            if (edge.hashCode() != hashCode()) return false;
            return (pointA == edge.getPointA() && pointB == edge.getPointB()) ||
                    (pointA == edge.getPointB() && pointB == edge.getPointA());
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        public int getPointA() {
            return pointA;
        }

        public int getPointB() {
            return pointB;
        }

        public int getOpposite(int point) {
            if (point == pointA) {
                return pointB;
            }
            if (point == pointB) {
                return pointA;
            }
            throw new IllegalStateException("The point " + point + " does not belong on the edge [" + pointA + "," + pointB + "]");
        }
    }
}
