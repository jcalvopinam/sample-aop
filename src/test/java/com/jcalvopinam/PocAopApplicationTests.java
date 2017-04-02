package com.jcalvopinam;

import com.jcalvopinam.service.PersonService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleAopApplicationTests {

    @Autowired
    PersonService personServiceMock;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        personServiceMock.setName("Juanca");
        String output = this.outputCapture.toString();
        assertThat(output).contains("Juanca");
    }

}
