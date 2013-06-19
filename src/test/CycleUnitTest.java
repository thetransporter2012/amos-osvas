import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CycleUnitTest {

	
	String inputPathCSV;
	String inputPathXML;
	String outputPathXML;
	String[] args1;
	String[] args2;
	String[] args3;
	String[] args4;
	String[] args5;
	
	
	Main m1;
	Main m2;
	Main m3;
	Main m4;
	Main m5;
	
	/*
	 * Works locally only, reference to local paths
	 * 
	
	@SuppressWarnings("static-access")
	@Before
	public void setMain() throws Exception{
	
		args1 = new String[0];
		args2 = new String[1];
		args2[0] = "/Users/Radi/Desktop/CSVInput.csv";
		args3 = new String[3];
		args3[0] = "/Users/Radi/Desktop/CSVInput.csv";
		args3[1] = "/Users/Radi/Desktop/XMLQueryDIFFERENT.xml";
		args3[2] = "/Users/Radi/Desktop/src";
			
		m1 = new Main();
		m2 = new Main();
		m3 = new Main();
		m1.main(args1);
		m2.main(args2);
		m3.main(args3);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void test() {
		//fail("Not yet implemented");
		assertEquals(m1.outputPathXML, m2.outputPathXML);
		assert(m1.inputPathXML != m3.inputPathXML);
	}

	*/
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
}
