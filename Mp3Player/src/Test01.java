
public class Test01 {
	public static void main(String[] args) {
		for(int i=5; i>0; i--) {
			
			System.out.println("i : "+i+"√ ");
			
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("¡æ∑·!");
	}
}
