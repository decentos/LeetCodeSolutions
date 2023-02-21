package tree;

import util.TreeParentNode;

import java.util.HashSet;
import java.util.Set;

public class M1650LowestCommonAncestorTree3 {

    public TreeParentNode lowestCommonAncestor(TreeParentNode p, TreeParentNode q) {
        Set<TreeParentNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = p.parent;
        }
        while (q != null) {
            if (set.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }

    public TreeParentNode lowestCommonAncestor2(TreeParentNode p, TreeParentNode q) {
        TreeParentNode headP = p;
        TreeParentNode headQ = q;
        while (headP != headQ) {
            headP = headP == null ? q : headP.parent;
            headQ = headQ == null ? p : headQ.parent;
        }
        return headP;
    }
}
