package nov_20_challange.nov04;

import java.util.*;
import java.util.stream.Collectors;

class Solution2 {
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

        TreeLayer[] layers = sortEdges(edges);

        for (int startingPoint = 0; startingPoint < layers.length; startingPoint++) {
            TreeLayer layer = layers[startingPoint];
            if (layer != null) {
                int currentDepth = 0;
                for (Edge edge : layer.getOutboundEdges()) {
                    int depth = calculateDepth(edge,layers);
                    if(depth > currentDepth){
                        currentDepth = depth;
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

        }

        return result;
    }

    private int calculateDepth(Edge ingress, TreeLayer[] layers) {
        if(ingress.getWeight() > 0){
            return ingress.getWeight();
        }
        TreeLayer layer = layers[ingress.pointB];
        int currentDepth = 0;
        for (Edge edge : layer.getOutboundEdges()) {
            if(ingress.getPointA() != edge.getPointB()){
                int depth = calculateDepth(edge,layers);
                if(depth > currentDepth){
                    currentDepth = depth;
                }
            }
        }
        ingress.setWeight(currentDepth+1);
        return currentDepth+1;
    }

    private TreeLayer[] sortEdges(int[][] edges) {
        TreeLayer[] result = new TreeLayer[getBiggest(edges)];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];

            TreeLayer inbound = result[edge[1]];
            if (inbound == null) {
                inbound = new TreeLayer(edges.length - i);
                result[edge[1]] = inbound;
            }
            inbound.addForInboundEdge(edge);

            TreeLayer outbound = result[edge[0]];
            if (outbound == null) {
                outbound = new TreeLayer(edges.length - i);
                result[edge[0]] = outbound;
            }
            outbound.addForOutboundEdge(edge);
        }
        return result;
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


    private static class TreeLayer {
        private final List<Edge> outboundEdges;

        TreeLayer(int arraySize) {
            outboundEdges = new ArrayList<>(arraySize);
        }


        public List<Edge> getOutboundEdges() {
            return outboundEdges;
        }

        public void addForInboundEdge(int[] edgeCoords) {
            outboundEdges.add(new Edge(edgeCoords[1], edgeCoords[0]));
        }

        public void addForOutboundEdge(int[] edgeCoords) {
            outboundEdges.add(new Edge(edgeCoords[0], edgeCoords[1]));
        }

    }

    private static class Edge {
        private final int pointA;
        private final int pointB;
        private int weight = 0;
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

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
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
