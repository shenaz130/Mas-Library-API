package lk.shenaz.maslibrary;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LoginAsyncTask extends AsyncTask<Void,Void,User> {
    private static final String TAG = "loginreached";
    private String email;
    private String password;
    private final String LOGIN_URL = "http://10.0.2.2/api/user.php";
    private static int CONNECTION_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;

    public LoginAsyncTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected User doInBackground(Void... voids) {
        User user = null;
        try {
            URL url = new URL(LOGIN_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(READ_TIMEOUT);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);//app downloding something from api
            httpURLConnection.setDoOutput(true);//app uploading something to api

            String data = URLEncoder.encode("email", "utf-8") + "-" +
                    URLEncoder.encode(email, "utf-8") + "&" +
                    URLEncoder.encode("password", "utf-8") + "=" +
                    URLEncoder.encode(password, "utf-8");

            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(data);

            bufferedWriter.flush();
            bufferedWriter.close();
            outputStreamWriter.flush();
            outputStreamWriter.close();
            outputStream.close();

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = (InputStream) httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line);
                }

                JSONObject jsonObject = new JSONObject(stringBuilder.toString());
               // Log.i(TAG,)
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
}
