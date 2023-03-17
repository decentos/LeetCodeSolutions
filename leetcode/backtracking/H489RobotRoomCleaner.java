package backtracking;

import java.util.HashSet;
import java.util.Set;

public class H489RobotRoomCleaner {

    public void cleanRoom(Robot robot) {
        clean(robot, new HashSet<>(), 0, 0);
    }

    private void clean(Robot robot, Set<String> visited, int row, int col) {
        String cell = String.format("%d-%d", row, col);
        if (visited.contains(cell)) return;

        robot.clean();
        visited.add(cell);

        if (moveUp(robot)) {
            clean(robot, visited, row - 1, col);
            moveDown(robot);
        }

        if (moveDown(robot)) {
            clean(robot, visited, row + 1, col);
            moveUp(robot);
        }

        if (moveRight(robot)) {
            clean(robot, visited, row, col + 1);
            moveLeft(robot);
        }

        if (moveLeft(robot)) {
            clean(robot, visited, row, col - 1);
            moveRight(robot);
        }
    }

    private boolean moveUp(Robot robot) {
        return robot.move();
    }

    private boolean moveDown(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        boolean moved = robot.move();
        robot.turnRight();
        robot.turnRight();
        return moved;
    }

    private boolean moveRight(Robot robot) {
        robot.turnRight();
        boolean moved = robot.move();
        robot.turnLeft();
        return moved;
    }

    private boolean moveLeft(Robot robot) {
        robot.turnLeft();
        boolean moved = robot.move();
        robot.turnRight();
        return moved;
    }


// ===============================================================================
    private final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom2(Robot robot) {
        clean2(robot, new HashSet<>(), 0, 0, 0);
    }

    private void clean2(Robot robot, Set<String> visited, int currDir, int row, int col) {
        String cell = String.format("%d-%d", row, col);
        if (visited.contains(cell)) return;

        robot.clean();
        visited.add(cell);

        for (int i = 0; i < dirs.length; i++) {
            int nextDir = (currDir + i) % 4;
            int nextRow = row + dirs[nextDir][0];
            int nextCol = col + dirs[nextDir][1];
            if (robot.move()) {
                clean2(robot, visited, nextDir, nextRow, nextCol);
                moveBack(robot);
            }
            robot.turnRight();
        }
    }

    private void moveBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft();

    void turnRight();

    // Clean the current cell.
    void clean();
}
