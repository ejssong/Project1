package project1;
import java.util.Scanner;

public class equation {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      // 자동차 탄소 배출량 계산 프로그램
      System.out.println("=== 탄소 점수 및 포인트 계산하기 ===");
      
      // 이동수단과 거리 부분은 나중에 gui랑 연동시키면 없애도 될듯 합니다.
      System.out.print("이동수단을 입력하세요 >> ");
      String how = sc.next();
      System.out.print("이동한 거리를 입력하세요 >> ");
      int distance = sc.nextInt();
      
      
      // 변수 생성 공간
      // gui에서 이동수단을 선택하고 입력버튼을 누르면 변수가 선언되면서 입력된 값으로 설정되게 만들면 될거 같습니다.
      
      double c_car = 243.8; // 자동차 탄소 배출량
      double c_bus = 17.7;  // 대중교통 탄소 배출량
      double c_elec = 0;    // 전기차 탄소 배출량
      double c_walk = 0;    // 도보 및 자전거 탄소 배출량
      double c_day = 0;     // 오늘 하루 배출한 탄소량
      double score = 0;        // 오늘 획득한 점수
      double point = 0;        // 오늘 획득한 포인트
      
      //
      
      // 우리가 100%로 놓고 계산할 탄소 배출량
      double standard = (243.8) * (34.5);
      
      
      // 차량별 탄소 배출량 및 점수 계산하기
      // 아래 코드에서 how.equals 부분은 gui 랑 연동하면 전부 다 없어져도 될 부분입니다.
      
      // 승용차일때
      if (how.equals("승용차")) {
         c_day += c_car * distance;  // 여기서 += 을 해준 이유는 이동수단이 복수일 경우를 고려
         if (c_day >= standard) {
            score = 0;
            point = 0;
         }else {
            score = ((double)(standard - c_day) / (double) standard) * 100;
            score = (int)score; // .0 없애는 기발한 방법 아시는분...
            point = score;
         }
      }
      
      // 대중교통일때
      if (how.equals("대중교통")) {
         c_day += c_bus * distance;
         if (c_day >= standard) {
            score = 0;
            point = 0;
         }else {
            score = ((double)(standard - c_day) / (double) standard) * 100;
            score = (int)score;
            point = score;
         }
      }

      // 전기자동차, 도보, 자전거 일때
      if (how.equals("전기자동차")) {
         c_day += c_elec * distance;
         if (c_day >= standard) {
            score = 0;
            point = 0;
         }else {
            score = ((double)(standard - c_day) / (double) standard) * 100;
            score = (int)score;
            point = score;
         }
      }
      
      System.out.println("오늘 하루의 점수는 >> " + score);
      System.out.println("오늘 얻은 포인트는 >> " + point);

   sc.close();   
   }
   
}