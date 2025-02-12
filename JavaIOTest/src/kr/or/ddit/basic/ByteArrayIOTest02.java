package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;

		byte[] temp = new byte[4];

		// 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();

		// 읽어올 데이터가 있는지 확인
		try {
			while (input.available() > 0) {
//				input.read(temp);		// temp 배열 개수만큼 데이터를 읽어와 temlp배열에 저장한다.
				// read(배열)의 반환값 ==> 실제 읽어온 데이터 개수이다.
//				output.write(temp);   	// temp 배열의 데이터를 출력한다.

				int len = input.read(temp); //
				// temp 배열의 0번째 부터 len의 길이만큼
				output.write(temp, 0, len); // (배열명, (배열의)-번째 부터, ""길이만큼)

				System.out.println("반복문 안에서 temp : " + Arrays.toString(temp));

			}

			outSrc = output.toByteArray();
			System.out.println();
			System.out.println(" inSrc : " + Arrays.toString(inSrc));
			System.out.println("outSrc : " + Arrays.toString(outSrc));

			// 스트림 닫기
			input.close();
			output.close();

		} catch (IOException e) {
		}

	}

}
