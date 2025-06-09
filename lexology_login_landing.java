package com.lbr.testcases.lexology.login;

import com.lbr.base.test_base;
import com.lbr.page_objects.lexology.lexology_login_methods;
import org.junit.Before;
import org.junit.Test;

public class lexology_login_landing extends test_base {

  // Tests for the Lexology login page //   

  public lexology_login_methods login;

  @Before
  public void before_test() throws InterruptedException {
    login = new lexology_login_methods(st, driver);
    actions.get_lexology_url("/account/login");
    actions.accept_cookies();
  }

  @Test
  public void lexology_login_landing_001() {
    // GIVEN that I am on the login page
    // THEN there will be a title, intro text, email and password fields,
    // login and reset buttons and a register block
    login.login_page_contents();
  }
}
