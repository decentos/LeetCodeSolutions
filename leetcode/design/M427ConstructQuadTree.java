package design;

public class M427ConstructQuadTree {

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int startRow, int startCol, int length) {
        boolean val = grid[startRow][startCol] == 1;
        if (length == 1) {
            return new Node(val, true);
        } else {
            int nextLength = length / 2;
            Node topLeft = construct(grid, startRow, startCol, nextLength);
            Node topRight = construct(grid, startRow, startCol + nextLength, nextLength);
            Node bottomLeft = construct(grid, startRow + nextLength, startCol, nextLength);
            Node bottomRight = construct(grid, startRow + nextLength, startCol + nextLength, nextLength);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topRight.val == val && bottomLeft.val == val && bottomRight.val == val) {
                return new Node(val, true);
            }

            return new Node(val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

// ===============================================================================

    private Node construct2(int[][] grid, int startRow, int startCol, int length) {
        boolean val = grid[startRow][startCol] == 1;
        if (isSameValue(grid, startRow, startCol, length)) {
            return new Node(val, true);
        } else {
            Node node = new Node(val, false);
            int nextLength = length / 2;
            node.topLeft = construct(grid, startRow, startCol, nextLength);
            node.topRight = construct(grid, startRow, startCol + nextLength, nextLength);
            node.bottomLeft = construct(grid, startRow + nextLength, startCol, nextLength);
            node.bottomRight = construct(grid, startRow + nextLength, startCol + nextLength, nextLength);
            return node;
        }
    }

    private boolean isSameValue(int[][] grid, int startRow, int startCol, int length) {
        for (int row = startRow; row < startRow + length; row++) {
            for (int col = startCol; col < startCol + length; col++) {
                if (grid[row][col] != grid[startRow][startCol]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
