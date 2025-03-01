package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {
	// 한글이 저장된 파일 읽어오기 - 인코딩 방식을 지정해서 읽어오기
	public static void main(String[] args) {
		try {
//			FileReader fr = new FileReader("C:/work_ts/D_Other/test_utf8.txt");
//			FileReader fr = new FileReader("C:/work_ts/D_Other/test_ansi.txt");
			
			/*
			 
			 	int c;

				while ((c = fr.read()) != -1) {
					System.out.print((char)c);
				}
			
				fr.close();
				
			 */
			
			// 바이트 기반 스트림을 문자 기반 스트림으로 변환해주는 보조 스트림은  
			// 인코딩 방식을 지정해서 입출력할 수 있다.
			
			FileInputStream fin = new FileInputStream("C:/work_ts/D_Other/test_utf8.txt");
//			FileInputStream fin = new FileInputStream("C:/work_ts/D_Other/test_ansi.txt");
			
			// 기본 인코딩 방식으로 읽어온다. 
//			InputStreamReader isr = new InputStreamReader(fin);
			
			// 인코딩 방식을 지정해서 읽어오기
			// (형식) InputStreamReader isr = new InputStreamReader(fin, "인코딩방식");
			// 인코딩 방식 예시)
			// - MS949(또는 CP949) 	==> 윈도우 시스템의 기본 한글 인코딩 방식(ANSI방식과 같다.)
			// - UTF-8				==> 유니코드 UTF-8 인코딩 방식
			// - US-ASCII			==> 영문 전용 인코딩 방식
			
			InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
			
			int c;

			while ((c = isr.read()) != -1) {
				System.out.print((char)c);
			}
			
			isr.close();

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
