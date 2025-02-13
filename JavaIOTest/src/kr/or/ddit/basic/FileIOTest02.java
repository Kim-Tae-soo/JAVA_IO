package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		// 바이트 기반 스트림을 이용하여 파일에 출력하기
		try {
			// 파일 출력용 스트림 객체를 생성할 때 지정할 파일이 없으면
			// 새로 생성되고 이미 있으면 덮어쓰기가 된다.
			FileOutputStream fout = 
					new FileOutputStream("C:/work_ts/D_Other/out.txt");
			for(char ch='A'; ch<='Z'; ch++) {
				fout.write(ch);	//'ch'변수의 값을 파일로 출력한다.
			}
				
			System.out.println("파일 출력 완료~~~");
			
			fout.close();	// 스트림 닫기
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
