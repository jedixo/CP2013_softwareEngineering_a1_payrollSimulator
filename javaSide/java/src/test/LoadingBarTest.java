package test;


import view.LoadingBar;

public class LoadingBarTest {

	public static void main(String[] args) {
		LoadingBar load = new LoadingBar("test");
		load.updateBar(2, "text test");;
		for (int i = 3; i < 100; i++) {
			load.updateBar(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
		load.dispose();
	}

}
