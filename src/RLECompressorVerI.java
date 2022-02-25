import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RLECompressorVerI {
	static BufferedReader input;
	static PrintWriter printer;

	public static void compress(String fileName) throws IOException {
		input = new BufferedReader(new FileReader(fileName));
		printer = new PrintWriter(fileName + ".rle");
		//System.out.println("hello");
		
		char prev = (char) input.read();
		int count;
		boolean wasReady = input.ready();
		
		for (char c = (char) input.read(); wasReady; c = (char) input.read()) {
			if (c == prev) {
				count = 1;
				while (c == prev) {
					count++;
					
					if(count > 254) {
						continue;
					}
					else {
						c = (char) input.read();
					}
				}
				printer.print(prev);
				printer.print(prev);
				printer.print((char) count);
				prev = c;
			}
			if (c != prev) {
				printer.print(prev);
			}
			prev = c;
			wasReady = input.ready();
		}
		//System.out.println(prev);
		printer.print(prev);

		printer.close();

	}
}