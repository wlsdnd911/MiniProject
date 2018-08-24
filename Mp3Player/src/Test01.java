
public class Test01 {
	public static void main(String[] args) {
		for(int i=5; i>0; i--) {
			
			System.out.println("i : "+i+"ÃÊ");
			System.out.println("안녕하세요");
			
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Á¾·á!");
	}
}
