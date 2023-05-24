package sut;

import junit.extensions.abbot.ScriptFixture;
import junit.extensions.abbot.ScriptTestSuite;
import junit.extensions.abbot.TestHelper;
import junit.framework.Test;

/*
 * Integrating Costello Script into JUnit Test

    1. Subclass ScriptFixture
    2. Write a suite() method that returns a ScriptTestSuite object specifying the saved scripts to run
       Scripts are loaded from the file system and filtered from directories.
 */
public class ScriptTest extends ScriptFixture {

	public ScriptTest(String filename) {
		super(filename);
	}

	public static Test suite() {
		// all scripts in folder script/ will be executed
		return new ScriptTestSuite(ScriptTest.class, "script");
	}
	
	public static void main(String[] args) {
		TestHelper.runTests(args, ScriptTest.class);
	}
}
