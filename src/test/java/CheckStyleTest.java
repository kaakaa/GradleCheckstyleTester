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

    /** Checkstyleの結果ファイル */
    private File checkstyleResult;

    @Before
    public void setUp() throws Exception {
        this.checkstyleResult = new File("./build/reports/checkstyle/main.xml");

	// Checkstyleの結果ファイルが無い場合
	if(!checkstyleResult.exists()){
            throw new Exception("Checkstyle Reports Not Found: " + checkstyleResult.getAbsolutePath());
	}
    }

    @Category(CheckStyleTests.class)
    @Test
    public void testSomeLibraryMethod() throws Exception {
        // 結果ファイルの読み込み
	InputStream r = new FileInputStream(checkstyleResult);
	XMLInputFactory factory = XMLInputFactory.newInstance();
	XMLStreamReader reader = factory.createXMLStreamReader(r);

	// Checkstyleのエラー数をカウントする
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
