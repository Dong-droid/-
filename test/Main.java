
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		���� b = new ����("Ÿ�����",100, 12); //����,����
		����� a = new �����("�������",100, 0.1); //����,����
		��ũ t = new ��ũ("��ũ��ũ",50, 4); //����,����
		
		Driver d = new Driver("�̹�");
		Vehicle [] vs = {b,a,t};
		
		//���� Vehicle���� ���¸� ���δ�.
		Vehicle.show(vs);
	
		d.drive();  //		
		//driver��  ������ ���ᰡ ������������  drive()�Ѵ� . �� �� km���� �޸� �� ������?
		d.drive(vs);

		Vehicle.show(vs);
		
		
	}

}
