package leetcode;
/**
 * 
 * @author Bolun
 *
 */
public class ScrambleString {
    
	/**
	 * http://blog.sina.com.cn/s/blog_b9285de20101gy6n.html
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        boolean[][][] scrambled = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++){
                scrambled[i][j][0] = true; 
                scrambled[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
    
        for(int i = s1.length() - 1; i >= 0 ; i--)
            for(int j = s2.length() - 1; j >= 0; j--)
                for(int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n ++)
                    for(int m = 1; m < n; m++){
                        scrambled[i][j][n] |= scrambled[i][j][m] && scrambled[i + m][j + m][n - m] ||
                                scrambled[i][j + n - m][m] && scrambled[i + m][j][n - m];
                        if(scrambled[i][j][n])  break;
                    }
        return scrambled[0][0][s1.length()]; 
    }
	
	public String s1r = null;
	
	public static class TreeNode {
        String val = null;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(String _val) {
            val = _val;
            if (_val.length() == 1) {
                left = null;
                right = null;
            } else if (_val.length() == 2) {
                left = new TreeNode(_val.substring(0,1));
                right = new TreeNode(_val.substring(1,2));
            } else { // general case: 0~mid-1 left; mid~end right
                int mid = (_val.length()-1) / 2;
                left = new TreeNode(_val.substring(0, mid));
                right = new TreeNode(_val.substring(mid,_val.length()));
            }
        }
    }
    
    public void scramble(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) { // non-leaf, swap children
        	System.out.println(root.val+" "+root.left.val+" "+root.right.val);
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            System.out.println(root.val+" "+root.left.val+" "+root.right.val);
            // recursively swap its children
            scramble(root.left);
            scramble(root.right);
        } else {
            return;
        }
    }
    
    public void recover(TreeNode root) {
        inorder_traversal(root);
    }
    
    public void inorder_traversal(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            s1r = s1r + root.val; // append to the result
            return;
        }
        inorder_traversal(root.left);
        inorder_traversal(root.right);
        return;
    }
    
    public boolean isScramble_2(String s1, String s2) {
        if (s1 == null) return false;
        if (s1.length() == 0) {
            if (s2.length() == 0)
                return true;
            else 
                return false;
        }
        if (s1.length() == 1) {
            if (s1.equals(s2))
                return true;
            else
                return false;
        }
        s1r = new String("");
        // build tree of s1
        TreeNode root = new TreeNode(s1);
        // scramble s1
        scramble(root);
        // recover from scramble tree
        recover(root);
        System.out.println(s1r);
        return s1r.equals(s2);
    }
    
    public static void main(String[] args) {
    	ScrambleString s = new ScrambleString();
    	s.isScramble("ab", "ab");
    }
}