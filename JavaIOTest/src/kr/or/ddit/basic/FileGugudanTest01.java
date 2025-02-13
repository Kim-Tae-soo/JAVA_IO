package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileGugudanTest01 {

	// 사용자로부터 출력할 단을 입력 받아 해당 단을 파일로 출력하는 프로그램을 작성하시오.
	// 구구단이 저장될 파일명 : gugudan.txt

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("출력할 단을 입력하세요: ");
			int dan = scanner.nextInt();
			String filename = "C:/work_ts/D_Other/gugudan.txt";

			try (FileWriter writer = new FileWriter(filename)) {
				for (int i = 1; i <= 9; i++) {
					String result = dan + " * " + i + " = " + (dan * i) + "\n";
					writer.write(result);
					System.out.println(result);
				}
				System.out.println("구구단이 " + filename + " 파일에 저장되었습니다.");
				
				
			} catch (IOException e) {
				System.out.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());

			}
			System.out.println();
		}
	}

}
