package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> paths = new Stack<String>();
        String s = new String("");
        String[] dirs = path.split("/");
        System.out.println(Arrays.toString(dirs));
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].equals("..")) {
                if (!paths.isEmpty()) {
                    paths.pop();
                }
            } else if (dirs[i].equals(".")) {
                // do nothing
            } else if (dirs[i].equals("")) {
                // do nothing
            } else {
                paths.push(dirs[i]);
            }
        }
        if (paths.isEmpty()) {
            return "/";
        } else {
            while (!paths.isEmpty()) {
                s = "/"+paths.pop()+ s;
            }
            return s;
        }
    }
    
    public static void main(String[] args) {
    	SimplifyPath sp = new SimplifyPath();
    	System.out.println("result:"+sp.simplifyPath("/."));
    }
}