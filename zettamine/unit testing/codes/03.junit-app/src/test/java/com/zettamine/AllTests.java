package com.zettamine;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.zettamine.services.LargestTest;
import com.zettamine.ums.services.UserServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ LargestTest.class, UserServiceTest.class })
public class AllTests {

}
