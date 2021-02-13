package lk.shenaz.maslibrary;

import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private String email = "shenaz@gmail.com";
    private String password = "s1200";


    public void setUp(){

    }


    @Test
    public void Logintest(){

        User actual = loginActivityActivityTestRule.getActivity().LoginChecker(email,password);
        Assert.assertNotEquals(null, actual);
    }

    public void tearDown(){

    }
}
