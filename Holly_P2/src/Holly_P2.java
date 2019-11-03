import java.io.*;
import java.util.*;


public class Holly_P2 {
	public class DuplicateCounter {
		
		HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();
		
		public void count(String dataFile) throws FileNotFoundException{
			try {
				String word;
				ArrayList<String> stringsList = new ArrayList<>();
				File data = new File(dataFile);
				Scanner scnr = new Scanner(new FileReader(data));

				while(scnr.hasNextLine()) {
					word = scnr.nextLine();
					
					if(stringsList.contains(word))
						wordCounter.put(word, wordCounter.get(word) + 1);
					else 
						wordCounter.put(word, 1);
				}
				scnr.close();
				
			}
			
			catch (Exception e) {
				System.out.println("Error in P2 count");
				
			}
		}
		
		public void write(String outputFile) {
				try { 
					FileWriter writer = new FileWriter(outputFile);
					Iterator<HashMap.Entry<String, Integer>> iterate = wordCounter.entrySet().iterator();
					
					while(iterate.hasNext()) {
						HashMap.Entry<String, Integer> frequency = iterate.next();
						writer.write(frequency);
					}
					writer.close();
				}
				
				catch (Exception f) {
					System.out.println("Error P2 write");
				}
		}
	}
	
	public class Application {
		public void main(String[] args) throws IOException {
			DuplicateCounter duplicateCounter = new DuplicateCounter();
		
			duplicateCounter.count("problem2.txt");
			duplicateCounter.write("unique_word_counts.txt");
		}
		
	}

}
