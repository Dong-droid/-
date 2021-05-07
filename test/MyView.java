import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyView extends JFrame{

	
	JButton b = new JButton("1234");
	
	public MyView() {
		
		//1.윈도우 크기 조정 ,  레이아웃도 null로 세팅 , title도 .. ,,,,
		this.setSize(700,400);
		this.setLayout(null);
		this.setTitle("손으로 만드는 나의 첫번째 윈도우");
		
		//2. 버튼만들기 - 크기와 위치지정,  색깔도 변경
		
		this.b.setBounds(200,100, 200,100);
		this.b.setBackground(Color.pink);
		b.setFont(new Font("굴림",0,20));
		
		//액션추가
		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//버튼에서  "1234" 숫자형문자열을 가지고와서 +10  한 후 다시 set!
				
				System.out.println(b.getText() + 10);  // + 지만 산술연산이 아니라 문자열연산!
				
				int num = Integer.parseInt(b.getText());
				num +=10;
				
				b.setText(String.valueOf(num));
				
			}
			
			
			
			
			
		});
		
		
		
		//3. 프레임이 부착하기
		
		this.add(b);
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		new MyView().setVisible(true);
		
		
	}

}
