package com.example.loginandregistrationsystem;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,String,String> {

    Context context;

    public BackgroundTask(Context ctx){
        this.context = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type = strings[0];
        String name = strings[1];
        String email = strings[2];
        String password = strings[3];
        String pass_confirm = strings[4];

        String regUrl = "http://192.168.43.190/android_connect/register.php";
        if (type.equals("reg")){
            try {
                URL url = new URL(regUrl);

                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String insert_data = URLEncoder.encode("name","UTF-8")+ "="+URLEncoder.encode(name,"UTF-8")
                        +"&"+URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("password")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("confirm_password","UTF-8")+"="+URLEncoder.encode(pass_confirm,"UTF-8");
                bufferedWriter.write(insert_data);
                bufferedWriter.flush();
                bufferedWriter.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"ISO-8859-1");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String result = "";
                String line = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line).append("\n");

                }

                result = stringBuilder.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
