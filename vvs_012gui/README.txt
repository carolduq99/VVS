
Run Costello (use test/CostelloRunner.java)

Create new script in menu File | New Script... and save it

Click "Insert your launch information here" and at the right a list of options appear

write "sut.CelsiusConverter" at the Target class name

the other text fields should have method 'main' and arguments '[]' (this can be changed accordingly)

Select Capture | All actions

The app starts and you make some actions in it, then close the app

A sequence of events will be recorded, save them into the script (cf the eg in script/)

Then, it's possible to include assertions, go into the sequence and click on an event
then, Insert | Assert | Text, and a new assertion will appear. Select which component
is to be checked, and provide the expected value.

To execute the script as a test in Eclipse create a class like this:

	import junit.extensions.abbot.ScriptFixture;
	import junit.extensions.abbot.ScriptTestSuite;
	import junit.extensions.abbot.TestHelper;
	import junit.framework.Test;
	
	public class CelsiusScriptTest extends ScriptFixture {
	
		public CelsiusScriptTest(String filename) {
			super(filename);
		}
	
		public static Test suite() {
		    // all scripts in folder script/ will be executed
			return new ScriptTestSuite(CelsiusScriptTest.class, "script");
		}
		
		public static void main(String[] args) {
			TestHelper.runTests(args, CelsiusScriptTest.class);
		}
	}
	

--------
	
Refs:

http://www2.sys-con.com/itsg/virtualcd/java/archives/0804/dutta/index.html
http://underpop.online.fr/j/java/professional-java-tools-for-extreme-programming/lib0147.html
http://www.cafeaulait.org/slides/sd2006west/guitesting/Testing_GUIs_with_Abbot_and_Costello.html
