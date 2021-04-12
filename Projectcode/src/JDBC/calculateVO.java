package JDBC;

public class calculateVO {

   private double c_car = 243.8; // 자동차 탄소 배출량
   private double c_bus = 17.7; // 대중교통 탄소 배출량
   private double c_elec = 0; // 전기차 탄소 배출량
   private double c_walk = 0; // 도보 및 자전거 탄소 배출량
   private double c_day = 0; // 오늘 하루 배출한 탄소량
   private double score = 0; // 오늘 획득한 점수
   private double point = 0; // 오늘 획득한 포인트
   private double avg_car = 34.5;
   private double distance;
   private String dt;
   
   public String getDt() {
      return dt;
   }

   public void setDt(String dt) {
      this.dt = dt;
   }

   private String how;

   public calculateVO(double distance, String how) {
      this.distance = distance;
      this.how = how;
   }

   public calculateVO(String dt, String how, int distance, int score) {
      this.dt = dt;
      this.how = how;
      this.distance = distance;
      this.score = score;
      
   }
   

   public double getC_car() {
      return c_car;
   }

   public void setC_car(double c_car) {
      this.c_car = c_car;
   }

   public double getC_bus() {
      return c_bus;
   }

   public void setC_bus(double c_bus) {
      this.c_bus = c_bus;
   }

   public double getC_elec() {
      return c_elec;
   }

   public void setC_elec(double c_elec) {
      this.c_elec = c_elec;
   }

   public double getC_walk() {
      return c_walk;
   }

   public void setC_walk(double c_walk) {
      this.c_walk = c_walk;
   }

   public double getC_day() {
      return c_day;
   }

   public void setC_day(double c_day) {
      this.c_day = c_day;
   }

   public double getScore() {
      return score;
   }

   public void setScore(double score) {
      this.score = score;
   }

   public double getPoint() {
      return point;
   }

   public void setPoint(double point) {
      this.point = point;
   }

   public double getAvg_car() {
      return avg_car;
   }

   public void setAvg_car(double avg_car) {
      this.avg_car = avg_car;
   }

   public double getDistance() {
      return distance;
   }

   public void setDistance(double distance) {
      this.distance = distance;
   }

   public String getHow() {
      return how;
   }

   public void setHow(String how) {
      this.how = how;
   }

}