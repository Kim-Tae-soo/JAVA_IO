package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {

	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		// 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		int data; // 읽어온 자료가 저장될 변수
		
		/*
		while (true) {
			// read()메서드 ==> 1byte의 자료를 읽어서 int형으로 반환하는데 읽어올 자료가 없으면 -1을 반환한다.
			data = input.read(); 
			if(data == -1) {
				break;
			}
			
			// 읽어온 자료를 바로 출력하기
			output.write(data);
		}
		*/
		
		while ((data = input.read())!= -1) {
			output.write(data);
		}
		
		// 출력된 스트림값을 배열로 변환해서 저장하기
		outSrc = output.toByteArray();
		
		// 스트림 닫기
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// 결과 확인하기
		System.out.println(" inSrc : " + Arrays.toString(inSrc));
		System.out.println(" OutSrc : " + Arrays.toString(outSrc));
		
		

	}

}
