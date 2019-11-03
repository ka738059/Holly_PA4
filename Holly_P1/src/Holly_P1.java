import java.io.*;
import java.util.*;

public class Holly_P1 {
	
	public class DuplicateRemover {
		
		private Set<String> uniqueWords;
		
		public void remove(String dataFile) throws FileNotFoundException{
			
			try {
				ArrayList<String> stringsList = new ArrayList<>();
				File data = new File(dataFile);
				Scanner scnr = new Scanner(new FileReader(data));
				
				while(scnr.hasNextLine()) {
					
					stringsList.add(scnr.nextLine());
				}
				
				uniqueWords = new HashSet<>(stringsList);
				scnr.close();
			}
			catch (Exception e) {
				System.out.println("Error in P1 remove()");
				
			}
			
			
		}
		
		public void write(String outputFile) throws FileNotFoundException {
			try { 
				FileWriter writer = new FileWriter(outputFile);
				Iterator<String> iterate = uniqueWords.iterator();
				
				while(iterate.hasNext()) {
					writer.write(iterate.next());
				}
				writer.close();
			}
			
			catch (Exception f) {
				System.out.println("Error in P1 write");
				
			}
		}
	}
	
	public static class Application {
		public void main(String[] args) throws IOException {
			
			DuplicateRemover duplicateRemover = new DuplicateRemover();
			
			duplicateRemover.remove("problem1.txt");
			duplicateRemover.write("unique_words.txt");
			
		}
	}
}
