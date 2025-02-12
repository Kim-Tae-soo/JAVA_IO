package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		// C:\\work_ts\\D_Other\\test.txt 파일을 읽어서 화면에 출력하는 예제
		
		try {
			// 파일을 읽어올 바이트 기반 스트림 객체를 생성한다.
			
			// FileInputStream 객체의 생성자에 읽어올 파일 정보를 넣어준다. 
								// ==> File객체 또는 문자열로 넣어줄 수 있다.
			// 방법1
//			FileInputStream fin = new FileInputStream("C:\\work_ts\\D_Other\\test.txt");
			
			// 방법2
			File f = new File("C:\\work_ts\\D_Other\\test.txt");
			FileInputStream fin = new FileInputStream(f);
			
			int c; // 읽어온 자료가 저장될 변수 선언
			while((c=fin.read()) != -1) {
				// 읽어온 자료를 화면에 출력한다.
				System.out.print((char)c);
			}
			
			// 작업 완료 후 스트림 닫기
			fin.close();
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다...");
			e.printStackTrace();
		}

	}

}
