package lk.shenaz.maslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookActivity extends AppCompatActivity {
    List<Book> bookList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        ListView listView = (ListView) findViewById(R.id.lvBook);
    //    List<Book> bookList = getbooks();

        FetchbookAsyncTask fetchbookAsyncTask = new FetchbookAsyncTask();
        try {
          bookList=  fetchbookAsyncTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LibraryArrayAdapter libraryArrayAdapter=new LibraryArrayAdapter (getApplicationContext(),bookList);

        listView.setAdapter(libraryArrayAdapter);

    }

   /* private List<Book> getbooks(){
        List<Book> bookList = new ArrayList<>();

        bookList.add(new Book("In Search of Lost Time","Marcel Proust","5.6", "Swann's Way, the first part of A la recherche de temps perdu"));
        bookList.add(new Book(" The Great Gatsby", "F. Scott Fitzgerald", "7.6", "The novel chronicles an era that Fitzgerald himself dubbed the"));
        bookList.add(new Book("One Hundred Years of Solitude ","Gabriel Garcia Marquez", "6.9","One of the 20th century's enduring works, One Hundred Years of Solitude is a widely beloved and acclaimed novel known throughout"));
        bookList.add(new Book(" War and Peace", "Leo Tolstoy", "8.6"," War and Peace delineates in graphic detail events leading up to Napoleon's invasion of Russia"));
        bookList.add(new Book("Lolita", "Vladimir Nabokov" , "6.5","The book is internationally famous for its innovative style and infamous for its controversial subject: the protagonist and unreliable narrator"));

        return bookList;
    }*/

}
