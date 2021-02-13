package lk.shenaz.maslibrary;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FetchbookAsyncTask extends AsyncTask<Void,Void,List<Book>> {
    private static final String TAG = "pagereached";
    private String bookName;
    private String bookAuthor;
    private String bookRating;
    private String Description;
    private final String BOOK_URL = "http://10.0.2.2/api/MasLibrary/maslibrary.php?apitoken=";
    private String TOKEN = "123";

    private static int CONNECTION_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;


    public FetchbookAsyncTask() {

    }

    public FetchbookAsyncTask(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    @Override
    protected List<Book> doInBackground(Void... voids) {
        List<Book> booklist = null;
        try {
            URL url = new URL(BOOK_URL+"123");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(READ_TIMEOUT);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);//app downloding something from api
            httpURLConnection.setDoOutput(false);//app uploading something to api

            /*OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.flush();
            outputStreamWriter.close();
            outputStream.close(); */

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = (InputStream) httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line);
                }

                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                booklist = new ArrayList<>();

                Log.i(TAG, "Length : "+stringBuilder.toString());

                for (int i=0; i < jsonArray.length(); i++){
                    Book book = new Book();
                    JSONObject obj = jsonArray.getJSONObject(i);

                    book.setBookId(obj.getInt("BookId"));
                    book.setBookName(obj.getString("BookName"));
                    book.setBookAuthor(obj.getString("BookAuthor"));
                    book.setDescription(obj.getString("Description"));
                    book.setDescription(obj.getString("Video"));

                    booklist.add(book);
                }
                // Log.i(TAG,)
                return booklist;
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return booklist;
    }
}
