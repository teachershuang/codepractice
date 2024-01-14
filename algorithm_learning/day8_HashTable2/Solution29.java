package day8_HashTable2;

import java.util.HashMap;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Solution29 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ints[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            ints[ransomNote.charAt(i) - 'a']--;
            if (ints[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
