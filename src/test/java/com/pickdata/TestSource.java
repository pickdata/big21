package com.pickdata;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pickdata.columns.ColumnList;
import com.pickdata.page.ValuesVO;

public class TestSource {

	@Test
	public void test() {
		String[] values={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","31"};
		ValuesVO vo = new ValuesVO();
		
		
		System.out.println(ColumnList.columnName.length);
		System.out.println(vo);
		
	}

}
