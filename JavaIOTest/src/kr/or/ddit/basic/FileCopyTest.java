package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	'C:/work_ts/D_Other' 폴더에 있는 '스폰지밥.png'파일을
 	'C:/work_ts/D_Other/연습용 '폴더'에 '복사본_스폰지밥.png'파일로 복사하는 프로그램을 작성하시오
 */

public class FileCopyTest {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("C:/work_ts/D_Other/스폰지밥.png");
			
			FileOutputStream fout = new FileOutputStream("C:/work_ts/D_Other/연습용/복사본_스폰지밥.png");
			
			int c;
			while((c=fin.read()) != -1) {
				fout.write(c);
			}
			System.out.println("복사 완료");
			
			fin.close();
			fout.close();
		} catch (IOException e) {
			System.out.println("오류 발생");
		}
		
	}

}
