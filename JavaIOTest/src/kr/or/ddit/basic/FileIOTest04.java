package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {

	public static void main(String[] args) {
		// 사용자가 입력한 내용을 그대로 파일로 저장하기.
		try {
			/*
			 * System.out.println("입력 >> "); 
			 * int a = System.in.read();
			 * System.out.println("입력 받은 값 : " + (char)a);
			 */
			// System.in ==> 콘솔(표준입출력장치)의 입력장치와 연결된 스트림
			// System.out ==> 콘솔(표준입출력장치)의 출력장치와 연결된 스트림

			// 바이트기반의 스트림을 문자 기반의 스트림으로 변환하는 보조 스트림이 있다.
			// 입력용 ==> InputStreamReader
			// 출력용 ==> OutputStreamWriter

			InputStreamReader isr = new InputStreamReader(System.in);

			FileWriter fw = new FileWriter("C:/work_ts/D_Other/testChar.txt");

			System.out.println("아무 내용이나 입력하세요. (입력의 끝은 Ctrl+Z 입니다.)");

			int c;
			
			// 콘솔에서 입력할 때 'Ctrl + Z'키를 누르면 입력의 끝 으로 인식하여 -1을 반환한다.
			while ((c = isr.read()) != -1) {
				fw.write(c);
			}
			
			// 스트림 닫기
			isr.close();
			fw.close();

		} catch (IOException e) {
			// TODO: handle exception

		}

	}

}
