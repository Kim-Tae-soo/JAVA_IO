package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTestTeacherVer {
	
/*
 	'C:/work_ts/D_Other' 폴더에 있는 '스폰지밥.png'파일을
 	'C:/work_ts/D_Other/연습용 '폴더'에 '복사본_스폰지밥.png'파일로 복사하는 프로그램을 작성하시오
 */

	public static void main(String[] args) {
		// 복사할 원본 파일 정보를 갖는 File 객체 생성
		File file = new File("C:/work_ts/D_Other/스폰지밥.png");
		
		// 원본 파일이 있는지 검사
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath() + "파일이 없습니다...");
			System.out.println("복사 작업을 중지합니다...");
			return;
			
		}
		// 대상 파일이 저장될 폴더 정보를 갖는 File 객체 생성
		File dir = new File("C:/work_ts/D_Other/연습용");
		// 저장할 폴더가 없으면 새로 생성한다.
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		// 입력 및 출력용 스트림 객체 변수 선언
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		// 버퍼스트림 객체 선언
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			// 원본 파일을 읽어올 입력용 스트림 객체 생성
			
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			
			// 복사될 대상 파일에 출력할 출력용 스트림 객체 생성
			fout = new FileOutputStream("C:/work_ts/D_Other/연습용/복사본_스폰지밥.png");
			bout = new BufferedOutputStream(fout);
			
			
			System.out.println("복사 작업 시작...");
			
			int data;		// 읽어온 데이터가 저장될 변수 선언
			/*
			while((data=fin.read())!=-1) {
				fout.write(data);
			}
			*/
			
			while((data=bin.read())!=-1) {
				bout.write(data);
			}
			
			System.out.println("복사 작업 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			if(fin!=null) try {fin.close();} catch(IOException e){}
//			if(fout!=null) try {fout.close();} catch(IOException e){}
			
			if(bin!=null) try {bin.close();} catch(IOException e){}
			if(bout!=null) try {bout.close();} catch(IOException e){}
		}

	}

}
