package booking;

public class E844BackspaceString {

    public boolean backspaceCompare(String s, String t) {
        int pointerS = s.length() - 1, pointerT = t.length() - 1;

        while (pointerS >= 0 || pointerT >= 0) {
            int skipS = 0, skipT = 0;

            while (pointerS >= 0 && (s.charAt(pointerS) == '#' || skipS > 0)) {
                skipS += s.charAt(pointerS) == '#' ? 1 : -1;
                pointerS--;
            }

            while (pointerT >= 0 && (t.charAt(pointerT) == '#' || skipT > 0)) {
                skipT += t.charAt(pointerT) == '#' ? 1 : -1;
                pointerT--;
            }

            if (pointerS >= 0 && pointerT >= 0 && s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS--;
                pointerT--;
            } else {
                break;
            }
        }
        return pointerS < 0 && pointerT < 0;
    }
}
