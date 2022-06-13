package com.company.code_squad.lv2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BaseBallGame {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BaseBallGame game = new BaseBallGame();
        Answer answerObj = new Answer(game.answerInit().toCharArray());

        System.out.println(answerObj.answer);

        while(true) {
            System.out.println("값 입력 : >> ");
            char[] number = (scanner.nextLine()).toCharArray();
            game.handleInputException(number);

            answerObj.calcStrike(number);
            answerObj.calcBall(number);
            if (answerObj.verifyAnswer()) {
                return;
            }else {
                answerObj.print();
                answerObj.init();
            }
        }



    }

    public String answerInit() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public void handleInputException(char[] input) throws IOException {
        if (input.length != 3) {
            throw new IOException("입력값의 길이를 확인해 주세요.");
        }
        for (char c : input) {
            if (c < 48 || c > 57) {
                throw new IOException("입력값은 숫자 여야 합니다.");
            }
        }
    }

}

class Answer {
    char[]  answer;
    int strike;
    int ball;
    Set<Character> ansSet = new HashSet<>();

    public Answer(char[] answer) {
        this.answer = answer;
        for (char ans : answer) {
            ansSet.add(ans);
        }
        for (Character character : ansSet) {
            System.out.println(character);
        }
    }

    public void calcStrike(char[] number) {
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == number[i]) {
                strike++;
            }
        }
    }

    public void calcBall(char[] number) {
        Set<Character> numSet = new HashSet<>();

        for (int i = 0; i < number.length; i++) {
            for (Character num : number) {
                numSet.add(num);
            }
        }
        for (Character num : numSet) {
            if (ansSet.contains(num)) ball++;
        }
        //ball 처리 로직 수정 : ball strike 둘다 커질 수 있기 때문에
        ball = ((strike - ball) < 0) ? ball - strike : 0;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean verifyAnswer() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다!");
            System.out.print(" - 게임 종료 -");
            return true;
        } else return false;
    }
    public void print() {
        if (strike == 0 || ball == 0) {
            System.out.println("0 스트라이크 , 0 볼");
        } else if (strike == 0) {
            System.out.println(ball + " 볼");
        } else if (ball == 0) {
            System.out.println(strike + " 스트라이크");
        } else {
            System.out.println(strike + " 스트라이크" + ball + " 볼");
        }
    }
}
