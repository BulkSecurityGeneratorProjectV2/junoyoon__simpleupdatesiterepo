package hudson.plugins.simpleupdatesite;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class HPICreationTest {
	@Test
	public void testUpdateCenter() throws IOException {
		UpdateSite site = new UpdateSite();
		site.init(new File("./src/test/resources/tmp"), "http://hudson02.nhncorp.com:9080/update");
		File file = Files.createTempFile("temp", "json").toFile();
		String updateCenterJSONString = site.toUpdateCenterJSONString();
		FileUtils.writeStringToFile(file, updateCenterJSONString);
		System.out.println(updateCenterJSONString);
		assertThat(file.exists(), is(true));
		assertThat(file.length(), greaterThan(200l));
		file.delete();
	}
}
