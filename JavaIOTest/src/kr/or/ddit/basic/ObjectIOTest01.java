package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 	직렬화		==>	객체 데이터를 일련의 byte Stream으로 변환하는 작업
 	
 	마샬링(Marshalling)	==>	메모리 상의 객체를 저장 또는 전송하기 위해서 다른 형태로 변환하는 작업
 */


public class ObjectIOTest01 {

	public static void main(String[] args) {
		Member[] memArr = new Member[] {
			new Member("김철민",20,"대전"),	
			new Member("이학범",30,"평양"),	
			new Member("권성운",40,"잠브웨이"),	
			new Member("구준표",50,"금잔디"),	
		};
		
		try {
			//출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("C:/work_ts/D_Other/memObj.bin");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oout = new ObjectOutputStream(bout);
			
			// 저장하기(쓰기 작업)
			System.out.println("객체 저장 작업 시작...");
			for(Member mem : memArr) {
				oout.writeObject(mem);
			}
			
			// 데이터를 출력할 때 마지막에 null을 추가하여 EOFException을 방지 할 수 있다.
			oout.writeObject(null);
			
			System.out.println("객체 저장 작업 끝...");
			
			oout.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
