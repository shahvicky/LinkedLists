

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;

public class LatestBlock {
	
/*	"blockHash, prevBlockHash, nonce, blockTransactions"
	"00000d03a1ce56a06bfdbceb0249bbb2204a6f22,
	0000000000000000000000000000000000000000, 28427, [[0, 1, 5], [1, 2,
	5]]"	*/
	
	public static void main(String[] args) {
	/*	int[] startBalances = {5, 0, 0};
		int[][] pendingTransactions = {{0,1,5},
				                      {1,2,5}};
		int blockSize= 2;	*/
	/*	int[] startBalances = {1, 7};
		int[][] pendingTransactions = {{1,0,4},
				                      {1,0,3},
				                      {1,0,2}};
		int blockSize= 2;	*/
	/*	int[] startBalances = {3, 10, 10, 3};
		int[][] pendingTransactions = {{3,2,2},
				 {2,3,5},
				 {3,2,4},
				 {3,0,2},
				 {1,2,2}};
		int blockSize= 2;	*/
		int[] startBalances = {2, 8, 7, 3, 3, 9, 7};
		int[][] pendingTransactions = {{1,4,4},
				 {5,4,5},
				 {6,3,5},
				 {1,4,1},
				 {5,3,4},
				 {6,3,1},
				 {1,4,3}};
		int blockSize= 3;
		System.out.println(getLatestBlock(startBalances, pendingTransactions, blockSize));

	}

	static String getLatestBlock(int[] startBalances, int[][] pendingTransactions, int blockSize) {
		String prevBlockHash = "";
		String currBlockHash = "0000000000000000000000000000000000000000";
		int sizeCounter = 0;
		String nonce="";
		String trans = "";
		List<int[]> transactions = new ArrayList<>();
		for(int i=0; i<pendingTransactions.length; i++) {
			int fromAdd = pendingTransactions[i][0];
			int toAdd = pendingTransactions[i][1];
			int amount = pendingTransactions[i][2];
			if(startBalances[fromAdd] >= amount) {
				startBalances[toAdd] += amount;
				startBalances[fromAdd] -= amount;
				transactions.add(pendingTransactions[i]);
				sizeCounter++;
			}
			if((sizeCounter==blockSize) || (i == pendingTransactions.length-1 && transactions.size()!=0)) {
				prevBlockHash = currBlockHash;
				trans = "[";
				for(int[] transaction : transactions) {
					System.out.println(Arrays.toString(transaction));
					trans += Arrays.toString(transaction)+", ";
				}
				trans = trans.substring(0, trans.length()-2)+"]";
				String[] temp = nounceBlockHash(prevBlockHash, trans);
				nonce = temp[0];
				currBlockHash = temp[1];
				transactions.clear();
				sizeCounter = 0;
			}
		}
		String result = currBlockHash+", "+prevBlockHash+", "+nonce+", "+trans;
		return result;
	}
	
	static String[] nounceBlockHash(String prevBlockHash, String transactions) {
		System.out.println(transactions);
		String nonce = "";
		String blockHash = "";
		for(int i=0; i<=Integer.MAX_VALUE; i++) {
			String text = prevBlockHash+", "+i+", "+transactions;
			blockHash = sha1(text);
			if(blockHash.substring(0, 4).equals("0000")) {
				System.out.println(i);
				nonce = ""+i;
				break;
			}
		}
		String[] res = {nonce, blockHash};
		return res;
	}
	
	static String sha1(String text) {
		String sha1 = "";
		try {
			java.security.MessageDigest crypt = java.security.MessageDigest.getInstance("SHA-1");
			crypt.update(text.getBytes("UTF-8"));
			Formatter formatter = new Formatter();
			for (byte b : crypt.digest()) {
				formatter.format("%02x", b);
			}
			sha1 = formatter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sha1;
	}

}
