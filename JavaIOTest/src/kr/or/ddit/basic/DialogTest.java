package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// SWING의 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();

		// 선택할 파일의 확장자 설정 (파일 형식 설정)
		FileNameExtensionFilter img = 
				new FileNameExtensionFilter("이미파일", "png", "jpg", "gif");
		FileNameExtensionFilter doc = 
				new FileNameExtensionFilter("MS Word", new String[] { "docx", "doc" });
		FileNameExtensionFilter pdf = 
				new FileNameExtensionFilter("PDF File", "pdf");
		FileNameExtensionFilter txt = 
				new FileNameExtensionFilter("Text File", "txt");
		
		// 작성된 파일 형식 객체들을 chooser에 추가한다.
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(pdf);
		chooser.addChoosableFileFilter(txt);
		
		// 기본 파일 형식 선택하기
		chooser.setFileFilter(txt);
		
		
		// 모든 파일 목록 표시 여부 설정 ( true : 설정 / false : 미설정 )
//		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setAcceptAllFileFilterUsed(true);
		
		// 다이얼로그 창에 나타날 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("C:/work_ts/D_Other"));
		
		int result = chooser.showOpenDialog(new Panel());	// 열기용 다이얼로그 창 보이기
//		int result = chooser.showSaveDialog(new Panel());	// 저장용 다이얼로그 창 보이기
		
		// 열려진 다디얼로그 창에서 '저장' 또는 '열기' 버튼을 클릭 시 처리하기
		if(result == JFileChooser.APPROVE_OPTION) {
			// 다이얼로그에서 선택한 파일 정보 가져오기
			File selectFiile = chooser.getSelectedFile();
			System.out.println("선택한 파일 : " + selectFiile.getAbsolutePath());
		}
		
		
	
	}

}
