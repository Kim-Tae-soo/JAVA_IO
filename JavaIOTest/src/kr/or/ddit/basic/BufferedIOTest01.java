package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 Buffered 스트림을 사용한다.
		try {
			FileOutputStream fout = new FileOutputStream("C:/work_ts/D_Other/bufferTest.txt");

			// 크기가 5인 버퍼스트림 객체 생성
			// 크기를 지정하지 않으면 키본 크기가 8KB(8192byte) 이다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			for (char ch = '1'; ch <= '9'; ch++) {
				bout.write(ch);
			}
			bout.flush();	// 버퍼에 남아있는 데이터를 모두 출력시킨다.
			// fout.close();
			bout.close();	// 보조스트림을 닫으면 보조 스트림에서 사용한 기반이 되는 스트림도 같이 닫힌다.
			System.out.println("출력 작업 끝");
		} catch (IOException e) {

		}

	}

}
