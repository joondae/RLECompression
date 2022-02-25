import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RLEDecompressorVerI {
	static BufferedReader input;
	static PrintWriter printer;

	public static int decompress(String fileName) throws IOException {
		input = new BufferedReader(new FileReader(fileName));
		printer = new PrintWriter(fileName.substring(0, fileName.length() - 4));
		if (fileName.substring(fileName.length() - 4, fileName.length()).equals(".rle")) {
			//System.out.println("hello");
			char prev = (char) input.read();
			int count;
			for (char c = (char) input.read(); input.ready(); c = (char) input.read()) {
				if (c == prev) {
					count = (int) ((char) input.read());
					//System.out.println("yes: " + prev + " " + count);
					for (int i = 0; i < count; i++) {
						printer.print(c);
					}
					c = (char) input.read();
				} else {
					//System.out.println("no: " + prev);
					printer.print(prev);
				}
				prev = c;
			}
			printer.close();
			return 0;
		}

		return -1;
	}
}