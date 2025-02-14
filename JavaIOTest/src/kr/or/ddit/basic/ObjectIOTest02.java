package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOTest02 {

	public static void main(String[] args) {
		// 저장된 객체를 읽어와서 그 내용을 화면에 출력하는 예제

		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("C:/work_ts/D_Other/memObj.bin")));

			Object obj = null;

			System.out.println("객체 읽기 작업 시작");
			System.out.println("------------------------------");

			// readObject()메서드가 데이터를 끝까지 읽어오면 EOFException을 발생한다.
			while ((obj = oin.readObject()) != null) {
				// 읽어온 데이터는 원래의 객체형으로 형변환 후 사용한다.
				
				Member mem = (Member)obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("------------------------------");
			}
			
			System.out.println("읽기 작업 끝");
			
			
		} catch (EOFException e) {
			// EOFException을 이용하여 읽기가 끝났을 때 처리하는 경우
//			System.out.println("읽기 작업 끝");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
