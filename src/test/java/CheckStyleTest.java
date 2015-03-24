import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import category.checkstyle.CheckStyleTests;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import javax.xml.stream.*;

public class CheckStyleTest {

    /** Checkstyle�̌��ʃt�@�C�� */
    private File checkstyleResult;

    @Before
    public void setUp() throws Exception {
        this.checkstyleResult = new File("./build/reports/checkstyle/main.xml");

	// Checkstyle�̌��ʃt�@�C���������ꍇ
	if(!checkstyleResult.exists()){
            throw new Exception("Checkstyle Reports Not Found: " + checkstyleResult.getAbsolutePath());
	}
    }

    @Category(CheckStyleTests.class)
    @Test
    public void testSomeLibraryMethod() throws Exception {
        // ���ʃt�@�C���̓ǂݍ���
	InputStream r = new FileInputStream(checkstyleResult);
	XMLInputFactory factory = XMLInputFactory.newInstance();
	XMLStreamReader reader = factory.createXMLStreamReader(r);

	// Checkstyle�̃G���[�����J�E���g����
	int errorCount = 0;
	while (reader.hasNext()){
            reader.next();
	    if(reader.isStartElement() && reader.getLocalName().equals("error")){
	        errorCount++;
	    }
	}

	assertThat(errorCount, is(1));
    }
}
