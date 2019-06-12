package week3._4;
public class Test {
	public static void main(String[] args) {
		Shape circle = new Shape() {
			@Override
			public void draw() {
				System.out.println("画圆");
			}

			@Override
			public void erase() {
				System.out.println("擦除圆形");
			}
		};
		
		circle.draw();
		circle.erase();

		Shape square = new Shape() {
			@Override
			public void draw() {
				System.out.println("画正方形");
			}

			@Override
			public void erase() {
				System.out.println("擦除正方形");
			}
		};
		square.draw();
		square.erase();
	}
}
