package com.lbr.testcases.lexology.login;

import com.lbr.base.test_base;
import com.lbr.page_objects.lexology.lexology_login_methods;
import com.lbr.utils.lexology_login;
import org.junit.Before;
import org.junit.Test;

// Testing of a successful Lexology login on the Lexology website // 

public class lexology_login_successful extends test_base {

  public lexology_login_methods login;

  @Before
  public void before_test() throws InterruptedException {
    login = new lexology_login_methods(st, driver);
    actions.get_lexology_url("/account/login");
    actions.accept_cookies();
  }

  @Test
  public void lexology_login_successful_001() {
    // GIVEN that I am on the login page
    // WHEN I enter the username and password of a registered user
    lexology_login.login_with_standard_user();
    // THEN I will be logged in and directed to the homepage
    login.lexology_homepage();
  }
}
