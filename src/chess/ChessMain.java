package chess;

import java.util.Scanner;

public class ChessMain {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Board board = new Board();
		board.initialize();
		
		String input = "";
		while(true) {
			System.out.println("게임을 진행할꺼면 start, 끝내실거면 end를 입력해주세요.");
			input = scanner.nextLine();
			if(input.equals("start")) {
				System.out.println(board.showBoard());
			}
			
			if(input.equals("end")) {
				break;
			}
		}
		
		scanner.close();
	}
}
