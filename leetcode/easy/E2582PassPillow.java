package easy;

public class E2582PassPillow {

    public int passThePillow(int n, int time) {
        boolean isStart = true;
        while (time > n - 1) {
            time = time - n + 1;
            isStart = !isStart;
        }
        return isStart ? 1 + time : n - time;
    }
}
