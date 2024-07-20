package com.automation.hybridFramework.testcases;
import java.io.IOException;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.hybridFramework.BaseClass;
import com.automation.hybridFramework.utilities.ExcelUtilities;
import com.google.common.base.Verify;


public class Demo extends BaseClass {
	public Logger log = LogManager.getLogger(this.getClass());
	
	@Test
	public void demoTest() throws IOException {
		log.info("*********************Test Started************************* ");
	//	Assert.assertEquals(true, false);
		
		log.info("*********************Test Finished************************* ");
	}

}
