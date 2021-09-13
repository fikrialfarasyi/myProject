package soal1;

import java.util.ArrayList;

public class soal1 {

	public static void main(String[] args) {
		String kalimat = "aku seorang bajak laut di tengah laut Somalia, aku sedang merompak kapal para "
				+ "penjajah Afrika. Namun aku takut dengan seorang penjajah dari Afrika keturunan "
				+ "India.";
				
		String value = kalimat.replaceAll("[,.]", "");
		
		String[] keys = value.split(" ");
		
		ArrayList<Integer> result = new ArrayList<>();
		
	    for (int i = 0; i < keys.length; i++) {
	        if (result.contains(i)) {
	            continue;
	        }
	        int d = 1;
	        for (int j = i+1; j < keys.length; j++) {
	            if (keys[i].equals(keys[j])) {
	                d += 1;
	                result.add(j);
	            }
	        }
	        System.out.println(keys[i]+" ::"+d);
	    }
	    
	    System.out.println();
	    System.out.println("Kata Terbanyak :: ");
	    String val = "";
	    for (int i = 0; i < result.size(); i++) {
	    	 if(!val.contains(keys[result.get(i)])) {
	    		 System.out.println("- "+keys[result.get(i)]);
	    		 val = keys[i];
	    	 }
	    	
	    }


	}

}
