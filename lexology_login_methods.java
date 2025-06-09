package com.lbr.page_objects.lexology;

import static org.hamcrest.CoreMatchers.is;

import com.lbr.base.test_base;
import com.lbr.utils.setup_tests;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class lexology_login_methods extends test_base {

  public lexology_login_methods(setup_tests st, WebDriver driver) {
    page_object_base(st, driver);
  }

  @FindBy(xpath = "//h1[contains(text(),'Log in')]")
  WebElement login_header;

  @FindBy(xpath = "//p[contains(.,'To access the Lexology website, you must either log in or register.')]")
  WebElement login_intro;

  @FindBy(xpath = "//input[@id='EmailAddress']")
  WebElement email_address;

  @FindBy(xpath = "//a[contains(.,'customerservices@lexology.com')]")
  WebElement contact;

  @FindBy(xpath = "//input[@id='Password']")
  WebElement password;

  @FindBy(xpath = "//button[contains(.,'Login')]")
  WebElement login_button;

  @FindBy(xpath = "//a[contains(.,'Reset password')]")
  WebElement reset_password_link;

  @FindBy(xpath = "//a[contains(.,'register')]")
  WebElement register_button;

  @FindBy(xpath = "(//a[contains(.,'Register')])[3]")
  WebElement register_cta;

  @FindBy(css = ".register-msg")
  WebElement register_block;

  @FindBy(xpath = "//input[@value='Reset password']")
  WebElement reset_password_button;

  @FindBy(xpath = "//h1[@id='main-header']")
  WebElement lex_homepage_header;

  @FindBy(xpath = "//button[contains(.,'Login with SSO')]")
  WebElement login_with_sso_button;

  // method to verify Login page contents
  public void login_page_contents() {
    actions.wait_until(login_header);
    MatcherAssert.assertThat(login_header.isDisplayed(), is(true));
    MatcherAssert.assertThat(login_intro.isDisplayed(), is(true));
    MatcherAssert.assertThat(email_address.isDisplayed(), is(true));
    MatcherAssert.assertThat(password.isDisplayed(), is(true));
    MatcherAssert.assertThat(reset_password_link.isDisplayed(), is(true));
    MatcherAssert.assertThat(register_button.isDisplayed(), is(true));
    MatcherAssert.assertThat(register_cta.isDisplayed(), is(true));
    MatcherAssert.assertThat(register_block.isDisplayed(), is(true));
  }

  // method to click on Login button
  public void click_login_button() {
    actions.wait_until(login_button);
    login_button.click();
  }

  // method to enter some characters into the email field
  public void enter_characters_into_email_field() {
    actions.wait_until(email_address);
    email_address.sendKeys("abcde");
  }

  // method to check the reset password page is displayed
  public void click_reset_password_button() {
    actions.wait_until(reset_password_header);
    reset_password_button.click();
  }

  // method to verify the Lexology homepage
  public void lexology_homepage() {
    actions.wait_until(lex_homepage_header);
    MatcherAssert.assertThat(
      driver.getCurrentUrl(),
      is(setup_tests._lexology_test_domain + "/")
    );
  }
}
