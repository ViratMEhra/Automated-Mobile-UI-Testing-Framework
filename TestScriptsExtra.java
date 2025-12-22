   @Test(priority = 1)
    public void verifyAppLaunch() {
        Assert.assertNotNull(driver, "Driver is not initialized");
        System.out.println("✅ App launched successfully");
    }

    @Test(priority = 2)
    public void verifyLoginScreenUI() {
        Assert.assertTrue(driver.findElementById("email_input").isDisplayed(),
                "Email field not visible");
        Assert.assertTrue(driver.findElementById("password_input").isDisplayed(),
                "Password field not visible");
        Assert.assertTrue(driver.findElementById("login_button").isDisplayed(),
                "Login button not visible");

        System.out.println("✅ Login screen UI verified");
    }

    @Test(priority = 3)
    public void loginWithValidCredentials() {
        driver.findElementById("email_input")
                .sendKeys("virat.mehra@example.com");

        driver.findElementById("password_input")
                .sendKeys("User@123");

        driver.findElementById("login_button").click();

        WebElement homeTitle = driver.findElementById("home_title");
        Assert.assertTrue(homeTitle.isDisplayed(),
                "Login failed or home screen not displayed");

        System.out.println("✅ Login successful with valid credentials");
    }

    @Test(priority = 4)
    public void loginWithInvalidPassword() {
        driver.findElementById("profile_icon").click();
        driver.findElementById("logout_button").click();

        driver.findElementById("email_input").clear();
        driver.findElementById("password_input").clear();

        driver.findElementById("email_input")
                .sendKeys("virat.mehra@example.com");

        driver.findElementById("password_input")
                .sendKeys("WrongPassword");

        driver.findElementById("login_button").click();

        WebElement errorMsg = driver.findElementById("error_message");
        Assert.assertEquals(errorMsg.getText(), "Invalid credentials");

        System.out.println("✅ Error message verified for invalid login");
    }

    @Test(priority = 5)
    public void verifyLoginButtonDisabledWhenFieldsAreEmpty() {
        driver.findElementById("email_input").clear();
        driver.findElementById("password_input").clear();

        WebElement loginButton = driver.findElementById("login_button");
        Assert.assertFalse(loginButton.isEnabled(),
                "Login button should be disabled for empty inputs");

        System.out.println("✅ Login button disabled for empty fields");
    }

    @Test(priority = 6)
    public void verifyPasswordFieldIsMasked() {
        WebElement passwordField = driver.findElementById("password_input");
        String isMasked = passwordField.getAttribute("password");

        Assert.assertEquals(isMasked, "true");
        System.out.println("✅ Password masking verified");
    }

    @Test(priority = 7)
    public void verifySessionPersistenceAfterLogin() {
        driver.navigate().back();

        WebElement homeTitle = driver.findElementById("home_title");
        Assert.assertTrue(homeTitle.isDisplayed(),
                "Session not maintained after navigation");

        System.out.println("✅ User session persistence verified");
    }

    @Test(priority = 8)
    public void verifyLogoutFunctionality() {
        driver.findElementById("profile_icon").click();
        driver.findElementById("logout_button").click();

        Assert.assertTrue(driver.findElementById("login_button").isDisplayed(),
                "Logout failed");

        System.out.println("✅ Logout successful");
    }

    @Test(priority = 9)
    public void verifyAppRelaunch() {
        driver.closeApp();
        driver.launchApp();

        Assert.assertTrue(driver.findElementById("login_button").isDisplayed(),
                "App did not relaunch correctly");

        System.out.println("✅ App relaunch verified");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }
