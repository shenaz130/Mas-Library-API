package lk.shenaz.maslibrary;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RunWith(JUnit4.class)
@LargeTest
    public class FetchBookTest {

        public FetchbookAsyncTask fetchbookAsyncTask = new FetchbookAsyncTask();

        public void setUp() {

        }


        @Test
        public void FetchbookTest() throws ExecutionException, InterruptedException {

            List<Book> actual = fetchbookAsyncTask.execute().get();
            Assert.assertNotEquals(null, actual);
        }

        public void tearDown() {

        }
    }

