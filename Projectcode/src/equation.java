import java.util.Scanner;

public class equation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// �ڵ��� ź�� ���ⷮ ��� ���α׷�
		System.out.println("=== ź�� ���� �� ����Ʈ ����ϱ� ===");
		
		// �̵����ܰ� �Ÿ� �κ��� ���߿� gui�� ������Ű�� ���ֵ� �ɵ� �մϴ�.
		System.out.print("�̵������� �Է��ϼ��� >> ");
		String how = sc.next();
		System.out.print("�̵��� �Ÿ��� �Է��ϼ��� >> ");
		int distance = sc.nextInt();
		
		
		// ���� ���� ����
		// gui���� �̵������� �����ϰ� �Է¹�ư�� ������ ������ ����Ǹ鼭 �Էµ� ������ �����ǰ� ����� �ɰ� �����ϴ�.
		
		double c_car = 243.8; // �ڵ��� ź�� ���ⷮ
		double c_bus = 17.7;  // ���߱��� ź�� ���ⷮ
		double c_elec = 0;    // ������ ź�� ���ⷮ
		double c_walk = 0;    // ���� �� ������ ź�� ���ⷮ
		double c_day = 0;     // ���� �Ϸ� ������ ź�ҷ�
		double score = 0;        // ���� ȹ���� ����
		double point = 0;		  // ���� ȹ���� ����Ʈ
		
		//
		
		// �츮�� 100%�� ���� ����� ź�� ���ⷮ
		double standard = (243.8) * (34.5);
		
		
		// ������ ź�� ���ⷮ �� ���� ����ϱ�
		// �Ʒ� �ڵ忡�� how.equals �κ��� gui �� �����ϸ� ���� �� �������� �� �κ��Դϴ�.
		
		// �¿����϶�
		if (how.equals("�¿���")) {
			c_day += c_car * distance;  // ���⼭ += �� ���� ������ �̵������� ������ ��츦 ���
			if (c_day >= standard) {
				score = 0;
				point = 0;
			}else {
				score = ((double)(standard - c_day) / (double) standard) * 100;
				score = (int)score; // .0 ���ִ� ����� ��� �ƽôº�...
				point = score;
			}
		}
		
		// ���߱����϶�
		if (how.equals("���߱���")) {
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

		// �����ڵ���, ����, ������ �϶�
		if (how.equals("�����ڵ���")) {
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
		
		System.out.println("���� �Ϸ��� ������ >> " + score);
		System.out.println("���� ���� ����Ʈ�� >> " + point);

	sc.close();	
	}
	
}
