import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RLEDecompressorVerII {
	public int decompress(String inputFileName) {
		//check arguments for substring
		if(!inputFileName.substring(inputFileName.length() - 4).equals(".rle")) {
			System.out.println("input is not in .rle format");
			return -1;
		}
		
		// br.read() returns next char in file as an int
		// br.ready() returns boolean if at end of file
		// must use br.close() once you're done reading the file
		// equivalent for Scanner is sc.next(), sc.hasNext(),and sc.close()
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(inputFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Can't open " + inputFileName);
		}
		
		//BufferedWriter more comparable to BufferedReader (writes 1 letter at a time)
		//PrintWriter more comparable to Scanner (writes chunks at a time)
		BufferedWriter bw = null;
				
		try {
			File f = new File(inputFileName.substring(0, inputFileName.length() - 4));
			f.createNewFile();
			
			bw = new BufferedWriter(new FileWriter(f));
			
			//assumption that 1st read call shouldn't throw error 
			//b/c why would you use this method if .rle file didn't have at least 1 character in it?
			char firstChar  = (char) br.read();
			char secondChar  = '\u0000';
			boolean run = false;
			
			while(br.ready()) {
				//must work 1st time through and any subsequent times through
				if(run == false) {
					secondChar = (char) br.read();
					System.out.println("NOT run");
				}
				//"incrementing" after a run
				else {
					firstChar = (char) br.read();
					if(br.ready()) {
						secondChar = (char) br.read();
						System.out.println("run AND ready");
					}
					else {
						System.out.println("run NOT ready");
						break;
					}
				}
				
				//if there's a "double stop" then next char's int value is # repetitions
				if(firstChar == secondChar && br.ready()) {
					int numRepetitions = br.read();
					run = true;
					
					for(int i = 0; i < numRepetitions; i++) {
						bw.write(firstChar);
						//System.out.println("writing run for " + firstChar + "\t\tcount is " + (i+1));
					}
					System.out.println("a run occurred");
				}
				else {
					bw.write(firstChar);
					firstChar = secondChar;
					System.out.println("no run occurred");
				}
			}
			
			System.out.println(firstChar);
			System.out.println(secondChar);
			
			if(run) {
				//if last 2 chars of .rle are same (run before)
				if(firstChar == secondChar) {
					System.out.println("1");
					bw.write(firstChar);
					//alternatively write secondChar (doesn't matter since they're equal)
					//UNLESS YOU CARE ABOUT ADDRESSES???
				}
				else {
					//if last 2 chars of .rle are different (run before)
					System.out.println("2");
					//do nothing???
				}
			}
			//if last 2 chars of .rle are same (no run before)
			else if(firstChar == secondChar) {
				System.out.println("3");
				bw.write(firstChar);
				//alternatively write secondChar (doesn't matter since they're equal)
				//UNLESS YOU CARE ABOUT ADDRESSES???
			}
			//if last 2 chars of .rle are different (no run before)
			else {
				System.out.println("4");
			}
			
		    System.out.println(f.getName() + " written Successfully");
		    bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
