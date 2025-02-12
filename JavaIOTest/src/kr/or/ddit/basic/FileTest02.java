package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("C:\\work_ts\\D_Other\\test.txt");
		
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "byte(s)");
		System.out.println("Path : " + f1.getPath());
		System.out.println("absolutePath : " + f1.getAbsolutePath());
		System.out.println();
		
		// 현재 위치 나타내기
		File f2 = new File(".");
//		File f2 = new File("");
		System.out.println("Path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
		if(f1.isFile()) {
			System.out.println(f1.getName() + "은 파일입니다.");
		}else if(f1.isDirectory()) {
			System.out.println(f1.getName() + "은 디렉토리(폴더)입니다.");
		}else {
			System.out.println(f1.getName() + "은 뭐지..?");
		}
		
		if(f2.isFile()) {
			System.out.println(f2.getName() + "은 파일입니다.");
		}else if(f2.isDirectory()) {
			System.out.println(f2.getName() + "은 디렉토리(폴더)입니다.");
		}else {
			System.out.println(f2.getName() + "은 뭐지..?");
		}
		
		
		File f3 = new File("C:\\work_ts\\D_Other\\sample.txt");	// 현재 존자히자 않은 파일 지정
		
		if(f3.isFile()) {
			System.out.println(f3.getName() + "은 파일입니다.");
		}else if(f3.isDirectory()) {
			System.out.println(f3.getName() + "은 디렉토리(폴더)입니다.");
		}else {
			System.out.println(f3.getName() + "은 뭐지..?");
		}
		
		System.out.println();
		
		// 파일 유무 확인 후 생성하는 방법
		if(f3.exists()) {
			System.out.println(f3.getAbsolutePath()+"은 현재 존재합니다...");
		}else {
			System.out.println(f3.getAbsolutePath()+"은 존재하지 않습니다...");
			try {
				if(f3.createNewFile()) {
					System.out.println(f3.getAbsolutePath()+"파일 만들기 성공 !!!");
				}else{
					System.out.println(f3.getAbsolutePath()+"파일 만들기 실패 !!!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
