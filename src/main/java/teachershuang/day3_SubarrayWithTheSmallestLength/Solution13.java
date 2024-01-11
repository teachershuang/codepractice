package teachershuang.day3_SubarrayWithTheSmallestLength;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 */


public class Solution13 {
    // 原始字符串中字符的频率
    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    // 当前窗口中字符的频率
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    // 主函数，用于找到包含字符串 t 所有字符的最小窗口子字符串
    public String minWindow(String s, String t) {
        int tLen = t.length();
        // 初始化原始字符串中字符的频率
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;  // 定义窗口的左右边界，初始时窗口为空
        int len = Integer.MAX_VALUE;  // 用于记录最小窗口的长度
        int ansL = -1, ansR = -1;  // 用于记录最小窗口的起始和结束位置
        int sLen = s.length();

        // 滑动窗口
        while (r < sLen) {
            ++r;
            // 更新当前窗口中字符的频率
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            // 检查是否满足条件
            while (check() && l <= r) {
                // 更新最小窗口的位置和长度
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }

                // 缩小窗口左边界，更新窗口中字符的频率
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        // 返回最小窗口的子字符串
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    // 检查当前窗口中字符的频率是否满足条件
    public boolean check() {
        // 遍历目标字符串的字符及其频率
        Iterator<Map.Entry<Character, Integer>> iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            Character key = entry.getKey();  // 获取字符
            Integer val = entry.getValue();  // 获取字符在目标字符串中的频率
            // 如果当前窗口中该字符的频率不满足条件，返回 false
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        // 如果所有字符的频率都满足条件，返回 true
        return true;
    }
}

