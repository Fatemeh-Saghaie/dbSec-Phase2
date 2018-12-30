package net;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		java.util.List<String> sign = new ArrayList<>(12);
		sign.add("test456");
		sign.add("test300");
		sign.add("sign40");
		sign.add("test97");
		sign.add("test389");
		sign.add("sign476");
		sign.add("test34");
		sign.add("test333");
		sign.add("sign422");
		sign.add("test1");
		sign.add("test32");
		sign.add("sign433");
		sign.add("test33");
		sign.add("test333");
		sign.add("sign4333");
		MerkleTree mt = new MerkleTree(sign);
		System.out.println(mt.getRoot().sigAsString());
	}
}
