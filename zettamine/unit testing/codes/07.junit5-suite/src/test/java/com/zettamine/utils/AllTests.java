package com.zettamine.utils;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses( {StringUtilityTest.class, NumberUtilityTest.class})
@SelectPackages("com.zettamine.utils")
public class AllTests {

}
