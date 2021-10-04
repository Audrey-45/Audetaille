package com.example.project.model;
import android.util.Log;

import com.example.project.controller.Control;
import com.example.project.tools.AccessHTTP;
import com.example.project.tools.AsyncResponse;
import com.example.project.view.Account;
import com.example.project.view.ArticleDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class AccessDistant implements AsyncResponse {

    //Connection to php text
    private static final String SERVERADDR = "http://192.168.1.64/audetaille/serveuraudetaille.php";
    private Control control;

    public AccessDistant()
    {
        control = Control.getInstance(null);
    }

    /**
     * Return informations from distant server
     * @param output
     */
    @Override
    public void processFinish(String output) throws JSONException {
        Log.d("server", "******************" + output);
        //split of the received message
        String[] message = output.split("%");

        if (message.length > 1) {

            //save article
            if (message[0].equals("\t\t\tsave")) {
                Log.d("save", "******************" + message[1]);
            }
            //save fav
            else if (message[0].equals("\t\t\tsaveFav")) {
                Log.d("saveFav", "******************" + message[1]);
            }
            //save account
            else if (message[0].equals("\t\t\tsaveAcc"))
            {
                Log.d("saveAcc", "******************" + message[1]);
            }
            //save tshirt
            else if (message[0].equals("\t\t\tsaveTs"))
            {
                Log.d("saveTs", "******************" + message[1]);
            }
            else {
                //get last article
                if (message[0].equals("\t\t\tlast")) {
                    Log.d("last", "******************" + message[1]);

                    JSONObject info = new JSONObject(message[1]);
                    String article = info.getString("article");
                    Integer id = info.getInt("id");
                    CartArticles cartarticle = new CartArticles(article, id);
                    control.setCart(cartarticle);
                }
                //get last fav
                else if (message[0].equals("\t\t\tlastFav")) {
                    Log.d("lastFav", "******************" + message[1]);

                    JSONObject info = new JSONObject(message[1]);
                    String favarticle = info.getString("favarticle");
                    Integer id = info.getInt("id");
                    Favorite favorite = new Favorite(favarticle, id);
                    control.setFavorite(favorite);
                }
                //get last account
                else if (message[0].equals("\t\t\tlastAcc")) {
                    Log.d("lastAcc", "******************" + message[1]);

                    JSONObject info = new JSONObject(message[1]);
                    String firstname = info.getString("firstname");
                    String lastname = info.getString("lastname");
                    String password = info.getString("password");
                    String email = info.getString("email");
                    Acc account = new Acc(firstname, lastname, password, email);
                    control.setAcc(account);
                }
                //get last tshirt
                else if (message[0].equals("\t\t\tlastTs")) {
                    Log.d("lastTs", "******************" + message[1]);

                    JSONObject info = new JSONObject(message[1]);
                    String color = info.getString("color");
                    String size = info.getString("size");
                    String name = info.getString("name");
                    Tshirt tshirt = new Tshirt(color, size, name);
                    control.setTshirt(tshirt);
                }
                else {
                    //get all article
                    if (message[0].compareTo("\t\t\tall")==0) {
                        Log.d("all", "******************" + message[1]);

                        JSONArray jSonInfo = new JSONArray(message[1]);
                        ArrayList<CartArticles> allArticle = new ArrayList<CartArticles>();
                        for (int k = 0; k < jSonInfo.length(); k++) {
                            JSONObject info = new JSONObject(jSonInfo.get(k).toString());
                            String article = info.getString("article");
                            Integer id = info.getInt("id");
                            CartArticles cartArticles = new CartArticles(article, id);
                            allArticle.add(k,cartArticles);
                        }
                        control.setAllArticles(allArticle);
                      }
                    //get all fav
                    else if (message[0].compareTo("\t\t\tallFav")==0) {
                        Log.d("allFav", "******************" + message[1]);

                        JSONArray jSonInfo = new JSONArray(message[1]);
                        ArrayList<Favorite> allFavorites = new ArrayList<Favorite>();
                        for (int k = 0; k < jSonInfo.length(); k++) {
                            JSONObject info = new JSONObject(jSonInfo.get(k).toString());
                            String favorite = info.getString("favarticle");
                            Integer id = info.getInt("id");
                            Favorite fav = new Favorite(favorite, id);
                            allFavorites.add(k,fav);
                        }
                        control.setAllFavorites(allFavorites);
                    }
                    //get all account
                    else if (message[0].compareTo("\t\t\tallAcc")==0) {
                        Log.d("allAcc", "******************" + message[1]);

                        JSONArray jSonInfo = new JSONArray(message[1]);
                        ArrayList<Acc> allAccount = new ArrayList<Acc>();
                        for (int k = 0; k < jSonInfo.length(); k++) {
                            JSONObject info = new JSONObject(jSonInfo.get(k).toString());
                            String firstname = info.getString("firstname");
                            String lastname = info.getString("lastname");
                            String password = info.getString("password");
                            String email = info.getString("email");
                            Acc account = new Acc(firstname, lastname, password, email);
                            allAccount.add(k,account);
                        }
                        control.setAllAccount(allAccount);
                    }
                    //get all Tshirt
                    else if (message[0].compareTo("\t\t\tallTs")==0) {
                        Log.d("allTs", "******************" + message[1]);

                        JSONArray jSonInfo = new JSONArray(message[1]);
                        ArrayList<Tshirt> allTshirt = new ArrayList<Tshirt>();
                        for (int k = 0; k < jSonInfo.length(); k++) {
                            JSONObject info = new JSONObject(jSonInfo.get(k).toString());
                            String color = info.getString("color");
                            String size = info.getString("size");
                            String name = info.getString("name");
                            Tshirt tshirt = new Tshirt(color, size, name);
                            allTshirt.add(k,tshirt);
                        }
                        control.setAllTshirt(allTshirt);
                    }

                      else {
                        if(message[0].equals("\t\t\tError !")) {
                        Log.d("Error !", "******************" + message[1]);
                        }
                    }
                }
            }
        }

    }

    //send article with php to wamp
    public void send(String operation, JSONArray theDataJSON)
    {
        AccessHTTP accessData = new AccessHTTP();
        //delegation link
        accessData.delegate = this;
        // add parameters
        accessData.addParam("operation", operation);
        accessData.addParam("thedata", theDataJSON.toString());

        //call servor
        accessData.execute(SERVERADDR);
    }

    //send article with php to wamp
    public void sendDelete(String operation, JSONArray theDataJSON)
    {
        AccessHTTP accessData = new AccessHTTP();
        //delegation link
        accessData.delegate = this;
        // add parameters
        accessData.addParam("operation", operation);
        accessData.addParam("thedata", theDataJSON.toString());

        //call servor
        accessData.execute(SERVERADDR);
    }

    //send fav with php to wamp
    public void sendFav(String operationFav, JSONArray theDataJSON)
    {
        AccessHTTP accessData = new AccessHTTP();
        //delegation link
        accessData.delegate = this;
        // add parameters
        accessData.addParam("operationFav", operationFav);
        accessData.addParam("thedataFav", theDataJSON.toString());

        //call servor
        accessData.execute(SERVERADDR);
    }

    //send account with php to wamp
    public void sendAcc(String operationAcc, JSONArray theDataJSON)
    {
        AccessHTTP accessData = new AccessHTTP();
        //delegation link
        accessData.delegate = this;
        // add parameters
        accessData.addParam("operationAcc", operationAcc);
        accessData.addParam("thedataAcc", theDataJSON.toString());

        //call servor
        accessData.execute(SERVERADDR);
    }

    //send tshirt with php to wamp
    public void sendTs(String operationTs, JSONArray theDataJSON)
    {
        AccessHTTP accessData = new AccessHTTP();
        //delegation link
        accessData.delegate = this;
        // add parameters
        accessData.addParam("operationTs", operationTs);
        accessData.addParam("thedataTs", theDataJSON.toString());

        //call servor
        accessData.execute(SERVERADDR);
    }
}

