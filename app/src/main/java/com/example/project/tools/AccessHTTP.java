package com.example.project.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import android.os.AsyncTask;

import org.json.JSONException;

/**
 * HTTP remote connection technical class
 */
public class AccessHTTP extends AsyncTask<String, Integer, Long> {

    // properties
    public String ret=""; // information return by the server
    public AsyncResponse delegate=null; // management synchronous return
    private String parameters = ""; // parameters to sens in POST to server

    /**
     * Constructeur : do nothing
     */
    public AccessHTTP() {
        super();
    }

    /**
     * Constructor parameter string send in POST to server
     * @param nom
     * @param valeur
     */
    public void addParam(String nom, String valeur) {
        try {
            if (parameters.equals("")) {
                // first parameter
                parameters = URLEncoder.encode(nom, "UTF-8") + "=" + URLEncoder.encode(valeur, "UTF-8");
            }else{
                // next parameters (separate by &)
                parameters += "&" + URLEncoder.encode(nom, "UTF-8") + "=" + URLEncoder.encode(valeur, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * method called by the execute method
     * allows to send to the server a list of parameters in GET
     * @param urls have the server address in box 0 of urls
     * @return null
     */
    @Override
    protected Long doInBackground(String... urls) {
        // to eliminate some errors
        System.setProperty("http.keepAlive", "false");
        // objects to manage connection, reading and writing
        PrintWriter writer = null;
        BufferedReader reader = null;
        HttpURLConnection connexion = null;

        try {
            // creation of the url from the address received as a parameter, in urls [0]
            URL url = new URL(urls[0]);
            // open of connexion
            connexion = (HttpURLConnection) url.openConnection();
            connexion.setDoOutput(true);
            // choice of POST method for sending parameters
            connexion.setRequestMethod("POST");
            connexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connexion.setFixedLengthStreamingMode(parameters.getBytes().length);
            // creation of the send request on the connection, with the parameters
            writer = new PrintWriter(connexion.getOutputStream());
            writer.print(parameters);
            // Once the sending is complete, empty the sending channel
            writer.flush();
            // Retrieving the return from the server
            reader = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
            ret = reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // closing of the sending and receiving channels
            try{
                writer.close();
            }catch(Exception e){}
            try{
                reader.close();
            }catch(Exception e){}
        }
        return null;
    }

    /**
     * Return from the server, send the information returned to processFinish
     * @param result
     */
    @Override
    protected void onPostExecute(Long result) {
        // ret contains the retrieved information
        try {
            delegate.processFinish(this.ret);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}