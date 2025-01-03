package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private int lastId;

    public  App(Scanner sc) {
        this.sc =sc; // TestBot.java에 입력값이 있다. 그렇기 때문에 받아와야한다.
        lastId = 0;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            String cmd = sc.nextLine();
            System.out.println("명령 )");

            if(cmd.equals("종료")) {
                System.out.println("명언앱을 종료합니다.");
                break;
            } else if(cmd.equals("등록")) {

                System.out.println("명언 : ");
                System.out.println("작가 : ");
                System.out.println("%d번 명언이 등록되었습니다.".formatted(++lastId));
            } else if(cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println("2 / 작자미상 / 과거에 집착하지 마라.");
                System.out.println("1 / 작자미상 / 현재를 사랑하라.");

            }
        }
    }
}
