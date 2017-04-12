package codejam.year2017;

import java.io.*;

import codejam.*;
import codejam.year2017.a.*;

public class ProblemA {
	public static void main(String[] args) {
		try {
			new Application<>(new AReader(), Flipper::new, new AWriter()).run(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
