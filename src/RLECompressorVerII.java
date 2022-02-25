import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RLECompressorVerII {
	public void compress(String filename) {
		File fIn = new File(filename);
		FileReader fr;
		BufferedReader br = null;
		
		File fOut = new File(filename + ".rle");
		FileWriter fw;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(fIn);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			fw = new FileWriter(fOut);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while(br.ready()) {
				char letterToRead = (char) br.read();
				
				if(letterToRead == br.read()) {
					int count = 2;
					
					for(char i = letterToRead; i == br.read(); i = (char) br.read()) {
						count++;
					}
					
					char compressedRun = (char) count;
					bw.write(letterToRead + letterToRead + compressedRun);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
