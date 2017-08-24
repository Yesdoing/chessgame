package chess;

import java.util.Scanner;

public class ChessMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("체스 게임을 시작합니다. ");
		System.out.println("시작은 start, 종료는 end 명령을 입력하세요. ");
		
		while(true) {
			String command = scan.nextLine();
			if(command.equals("start")) {
				Board board = new Board();
				board.initialize();
				System.out.println(board.showBoard());
			} else if(command.equals("end")) {
				break;
			} else {
				System.out.println(command + "는 지원하지 않는 명령어 입니다. ");
			}
		}
		
		scan.close();
		
	}
	
}
