package org.example;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public  App(Scanner sc) {
        this.sc =sc; // TestBot.java에 입력값이 있다. 그렇기 때문에 받아와야한다.
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
                System.out.println("1번 명언이 등록되었습니다.");
            }
        }
    }
}
