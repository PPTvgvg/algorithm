package com.kuake.cn.algorithm;

/**
 * @description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: kuake.cn
 * @create: 2020-09-18 10:47
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0){
            return 0;
        }else if (s.length()==1){
            return 1;
        }
        //窗口
        Windows windwos = new Windows(s.substring(0,1), 0,  0);
        int maxLength = 1;
        int currentLength = 1;
        while (windwos.getRight()<s.length()){
            windwos.setRight(windwos.getRight()+1);
            if (windwos.getRight()==s.length()){
                break;
            }
//            String s1 = null;
//            if (windwos.getRight()+1==s.length()){
//                s1 = s.substring(windwos.getRight());
//            }else {
//                s1 = s.substring(windwos.getRight(),windwos.getRight()+1);
//            }
//            System.out.println(s1);
            if (windwos.getContent().contains(s.substring(windwos.getRight(),windwos.getRight()+1))){
                windwos.setLeft(windwos.getContent().indexOf(s.charAt(windwos.getRight()))+windwos.getLeft()+1);
                currentLength = windwos.getRight() - windwos.getLeft() + 1;
            }else {
                currentLength++;
            }
            windwos.setContent(s.substring(windwos.getLeft(),windwos.getRight()+1));
            System.out.println(windwos);
            maxLength = Math.max(maxLength,currentLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String string = "au";
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(string);
        System.out.println(i);
    }

    private class Windows {
        private int left;
        private int right;
        private String content;
        public Windows(String content, int left, int right){
            this.content = content;
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Windows{" +
                    "left=" + left +
                    ", right=" + right +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
