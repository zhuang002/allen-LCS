import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static int[] seq1 ;
	static int[] seq2 ;
	static HashMap<Parameters, Integer> cache = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int n1 = Integer.parseInt(line[0]);
		int n2 = Integer.parseInt(line[1]);
		seq1 = new int[n1];
		seq2 = new int[n2];
		
		line = reader.readLine().split(" ");
		for (int i=0;i<n1;i++)
			seq1[i] = Integer.parseInt(line[i]);
		
		line = reader.readLine().split(" ");
		for (int i=0;i<n2;i++)
			seq2[i] = Integer.parseInt(line[i]);
		
		System.out.println(getLCS(0,0));
		
		
	}
	
	private static int getLCS(int i, int j) {
		// TODO Auto-generated method stub
		if (i==seq1.length || j==seq2.length)
			return 0;
		
		Parameters key = new Parameters(i,j);
		if (cache.containsKey(key))
			return cache.get(key);
		int rt;
		if (seq1[i]==seq2[j]) {
			rt = 1+getLCS(i+1,j+1);
			cache.put(key, rt);
			return rt;
		} else {
			int lcs1 = getLCS(i,j+1);
			int lcs2 = getLCS(i+1, j);
			if (lcs1>=lcs2) 
				rt = lcs1;
			else 
				rt = lcs2;
			cache.put(key, rt);
			return rt;
		}
	}

}

class Parameters {
	int i;
	int j;
	
	public Parameters(int i,int j) {
		this.i=i;
		this.j=j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameters other = (Parameters) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
	
	
}
