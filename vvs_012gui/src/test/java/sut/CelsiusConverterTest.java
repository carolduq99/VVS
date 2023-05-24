package sut;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Test;

public class CelsiusConverterTest extends CelsiusAbstractUiTest {
	
    private JButtonFixture c2fButtonFixture;
    private JButtonFixture f2cButtonFixture;
    
    private JTextComponentFixture inputCFixture;
    private JTextComponentFixture inputFFixture;

    @Override
    protected void onSetUp() {
        this.c2fButtonFixture = this.frame.button(JButtonMatcher.withText("C->F"));
        this.f2cButtonFixture = this.frame.button(JButtonMatcher.withText("F->C"));

        this.inputCFixture = this.frame.textBox("inputC");
        this.inputFFixture = this.frame.textBox("inputF");
    }

    @Test
    public void testCelsiusToFahrenheit() {
    	// Exercise: create a text for the following sequence of actions:
        // 1. write "100" in "inputC" box
        // 2. click the "C->F" button
        // 3. check that the text in "inputF" box equals "212.0"
    }

    @Override
    protected void onTearDown() {
        this.c2fButtonFixture = null;
        this.f2cButtonFixture = null;
    }
}
