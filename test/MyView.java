import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyView extends JFrame{

	
	JButton b = new JButton("1234");
	
	public MyView() {
		
		//1.������ ũ�� ���� ,  ���̾ƿ��� null�� ���� , title�� .. ,,,,
		this.setSize(700,400);
		this.setLayout(null);
		this.setTitle("������ ����� ���� ù��° ������");
		
		//2. ��ư����� - ũ��� ��ġ����,  ���� ����
		
		this.b.setBounds(200,100, 200,100);
		this.b.setBackground(Color.pink);
		b.setFont(new Font("����",0,20));
		
		//�׼��߰�
		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//��ư����  "1234" ���������ڿ��� ������ͼ� +10  �� �� �ٽ� set!
				
				System.out.println(b.getText() + 10);  // + ���� ��������� �ƴ϶� ���ڿ�����!
				
				int num = Integer.parseInt(b.getText());
				num +=10;
				
				b.setText(String.valueOf(num));
				
			}
			
			
			
			
			
		});
		
		
		
		//3. �������� �����ϱ�
		
		this.add(b);
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new MyView().setVisible(true);
		
		
	}

}
