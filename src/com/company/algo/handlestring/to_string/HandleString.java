package com.company.algo.handlestring.to_string;

public class HandleString {

    public static void main(String[] args) {

    }

    class Solution {
        public String solution(int n) {
            String answer = "";
            for(int i=0; i<n; i++){
                if (i % 2 == 0) {   // 0나누기 2도 나머지 0
                    answer += String.format("수");
                }else {
                    answer += String.format("박");
                }
            }
            return answer;
        }
    }
}
