package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileCopyDialogTest {
   public static void main(String[] args) {
      new FileCopyDialogTest().startFileCopy();
   }
   
   public void startFileCopy() {
//    File file = new File("C:/work_ts/D_Other/스폰지밥.png");
      File file = getSelectFile("OPEN");
      
      // 원본 파일이 있는지 검사
      if(!file.exists()) {
         System.out.println(file.getAbsolutePath()+"파일이 없습니다.");
         System.out.println("복사 작업을 중지합니다.");
         return;
      }
      
      // 대상 파일이 저장될 폴더 정보를 갖는 File 객체 생성
      File dir = new File("C:/work_ts/D_Other/연습용");
      // 저장할 폴더가 없으면 새로 생성한다
      if(!dir.exists()) {
         dir.mkdirs();
      }
      
      // 입력 및 출력용 스트림 객체 변수 선언
      FileInputStream fi = null;
      FileOutputStream fo = null;

      try {
         // 원본 파일을 읽어올 입력용 스트림 객체 생성
         fi = new FileInputStream(file);
         
         // 복사될 대상 파일에 출력할 출력용 스트림 객체 생성
//       fo = new FileOutputStream("C:/work_ts/D_Other/연습용/복사본_스폰지밥.png");
         File targetFile = getSelectFile("SAVE");
         fo = new FileOutputStream(targetFile);
         
         System.out.println("원본파일 : " + file.getAbsolutePath() + "를(을) 대상 파일 "
               + targetFile.getAbsolutePath() + "로 복사합니다");
         System.out.println("복사 작업 시작");
         int c;
         while((c=fi.read()) != -1) {
            fo.write(c);
         }
         
         System.out.println("복사 작업 완료");
         
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if(fi != null) try { fi.close(); } catch(IOException e) { }
         if(fo != null) try { fo.close(); } catch(IOException e) { }
      }
   }
   
   private File getSelectFile(String option) {
      // SWING의 파일 열기, 저장 창 연습
      JFileChooser chooser = new JFileChooser();
      
      // 선택할 파일의 확장자 설정(파일 형식 설정)
      FileNameExtensionFilter img = new FileNameExtensionFilter("이미지파일", "png", "jpg", "gif");
      FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word", new String[] {"docx", "doc"});
      FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF File", "pdf");
      FileNameExtensionFilter txt = new FileNameExtensionFilter("Text File", "txt");
      
      // 작성된 파일 형식 객체들을 chooser에 추가한다.
      chooser.addChoosableFileFilter(img);
      chooser.addChoosableFileFilter(doc);
      chooser.addChoosableFileFilter(pdf);
      chooser.addChoosableFileFilter(txt);
      
      // 모든 파일 목록 표시 여부 설정 ( true : 설정, false : 미설정 )
      chooser.setAcceptAllFileFilterUsed(true);
//    chooser.setAcceptAllFileFilterUsed(false);
      
      // 다이얼로그 창에 나타날 기본 경로 설정하기
      chooser.setCurrentDirectory(new File("C:/work_ts/D_Other"));
      
      // 기본 파일 형식 선택하기
      chooser.setFileFilter(txt);
      
      int result;
      if("OPEN".equals(option.toUpperCase())) {
         result = chooser.showOpenDialog(new Panel()); // 열기용 다이얼로그         
      } else if("SAVE".equals(option.toUpperCase())){
         result = chooser.showSaveDialog(new Panel()); // 저장용 다이얼로그         
      } else {
         System.out.println("option은 'OPEN'또는 'SAVE'중 하나를 지정해주세요");
         return null;
      }
      
      // 열려진 다이얼로그 창에서 '저장' 또는 '열기'버튼을 눌렀을 경우 처리하기
      File selectFile = null;
      if(result == JFileChooser.APPROVE_OPTION) {
         // 다이얼로그에서 선택한 파일 정보 가져오기
         selectFile = chooser.getSelectedFile();
         System.out.println("선택한 파일 : " + selectFile.getAbsolutePath());
         
      }
      return selectFile;
      
   }
   
}
