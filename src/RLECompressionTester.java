import java.io.IOException;

public class RLECompressionTester {
	public static void main(String [] args) {
		//MINI TEST CASES for ver. I <-- FAILS
		/*
		RLEDecompressorVerI dI = new RLEDecompressorVerI();
		try {
			System.out.println(dI.decompress("myRLE.txt.rle"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		RLECompressorVerI cI = new RLECompressorVerI();
		try {
			cI.compress("myRLE.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		//FINAL TEST CASEs for ver. I <-- WORKS
		/*
		RLEDecompressorVerI dI2 = new RLEDecompressorVerI();
		try {
			System.out.println(dI2.decompress("RLEmystery.txt.rle"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		/*
		RLECompressorVerI cI2 = new RLECompressorVerI();
		try {
			cI2.compress("RLEtest.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		
		
		
		
		
		
		
		
		//MINI TEST CASES FOR VER. II <-- FAILS
		/*
		RLECompressorVerII c = new RLECompressorVerII();
		c.compress("RLEtest.txt");
		*/
		/*
		RLEDecompressorVerII d = new RLEDecompressorVerII();
		System.out.println(d.decompress("myRLE.txt.rle"));
		*/
		
		//FINAL TEST CASES FOR VER. II <-- N/A
		/*
		RLECompressorVerII c2 = new RLECompressorVerII();
		c2.compress("RLEtest.txt");
		*/				
		/*
		RLEDecompressorVerII d2 = new RLEDecompressorVerII();
		System.out.println(d2.decompress("RLEmystery.txt.rle"));
		*/
	}
}
