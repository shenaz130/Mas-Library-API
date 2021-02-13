package lk.shenaz.maslibrary;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LibraryFragmentUITest {
    @Rule


    public void setUp(){

    }

    @Test
    public void LIbraryFragmentUI(){
        //onView(withId(R.id.sign_in_button)).perform(click());

    }

    public void tearDown(){

    }
}
