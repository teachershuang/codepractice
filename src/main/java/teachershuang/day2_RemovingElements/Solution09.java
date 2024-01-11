package teachershuang.day2_RemovingElements;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 */
class Solution09 {
    /*
    使用了一个很精妙的方法，倒序进行检查，从后往前遍历，如果是#就将跳过标志量+1。
     */
    public boolean backspaceCompare(String S, String T) {
        int slowPointerS = S.length() - 1, slowPointerT = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (slowPointerS >= 0 || slowPointerT >= 0) {
            while (slowPointerS >= 0) {
                if (S.charAt(slowPointerS) == '#') {
                    skipS++;
                    slowPointerS--;
                } else if (skipS > 0) {
                    skipS--;
                    slowPointerS--;
                } else {
                    break;
                }
            }
            while (slowPointerT >= 0) {
                if (T.charAt(slowPointerT) == '#') {
                    skipT++;
                    slowPointerT--;
                } else if (skipT > 0) {
                    skipT--;
                    slowPointerT--;
                } else {
                    break;
                }
            }
            if (slowPointerS >= 0 && slowPointerT >= 0) {
                if (S.charAt(slowPointerS) != T.charAt(slowPointerT)) {
                    return false;
                }
            } else {
                if (slowPointerS >= 0 || slowPointerT >= 0) {
                    return false;
                }
            }
            slowPointerS--;
            slowPointerT--;
        }
        return true;
    }

}

