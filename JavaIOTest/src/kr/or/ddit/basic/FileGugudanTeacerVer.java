package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileGugudanTeacerVer {

	// 사용자로부터 출력할 단을 입력 받아 해당 단을 파일로 출력하는 프로그램을 작성하시오.
	// 구구단이 저장될 파일명 : gugudan.txt

	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		FileGugudanTeacerVer fgt = new FileGugudanTeacerVer();
		// fgt.charGuguda();
		fgt.byteGugudan();

	}

	public void byteGugudan() {
		System.out.println();
		System.out.print("출력할 단을 입력 >> ");
		int dan = scan.nextInt();

		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("C:/work_ts/D_Other/gugudanByte.txt");

			String result = dan + "단\r\n";
			for (int i = 1; i <= 9; i++) {
				result += dan + " * " + i + " = " + (dan * i) + "\r\n";
			}

			// 문자열을 byte배열로 변환 후 파일로 출력한다. ==> String 객체의 getBytes() 메서드 이용
			fout.write(result.getBytes("UTF-8"));

			System.out.println("출력 끝...");
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (fout != null)
				try {
					fout.close();
				} catch (IOException e2) {
					// TODO: handle exception
				}
		}
	}

	public void charGuguda() {
		System.out.println();
		System.out.print("출력할 단을 입력 >> ");
		int dan = scan.nextInt();

		FileWriter fw = null;
		try {
			fw = new FileWriter("C:/work_ts/D_Other/gugudanChar.txt");

			/*
			fw.write(dan + "단\r\n");
			
			for (int i = 1; i <= 9; i++) {
				fw.write(dan + " * " + i + " = " + (dan * i) + "\r\n");
			}
			*/

			String result = dan + "단\r\n";

			for (int i = 1; i <= 9; i++) {
				result += dan + " * " + i + " = " + (dan * i) + "\r\n";
			}

			fw.write(result);

			System.out.println("출력 끝...");

		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e2) {
					System.out.println("오류 발생");
				}
			}
		}

	}

}
