package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {

	public static void main(String[] args) {
		// 문자 기반의 Buffered 스트림 사용 예제
		
		try {
			/* 	
			 	이클립스에서 실행되는 자바 프로그램의 현재 위치는 해당 프로그램이
				속한 프로젝트 폴더가 현재 위치가 된다.
			*/
			FileReader fr = new FileReader("./src/kr/or/ddit/basic/FileTest01.java");
			
			BufferedReader br = new BufferedReader(fr);
			
			/*
			 	문자 기반의 입력용 버퍼스트림은 데이터를 한 줄 단위로 읽어올 수 있다.
			 		==> readLine() 메서드를 이용한다.
			 */
			String temp = "";	// 읽어올 문자열이 저장될 변수 선언
			
			for (int i = 1; (temp = br.readLine()) != null; i++) {
				System.out.printf("%4d : %s\n", i,temp );
			}
			
			/*
			
			int i = 1;
			while((temp = br.readLine())!=null) {
				System.out.printf("%4d : %s\n", i,temp );
				i++;
			}
			*/
			
			br.close();
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
