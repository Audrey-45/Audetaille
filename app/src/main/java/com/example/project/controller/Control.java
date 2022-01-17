package com.example.project.controller;

import android.content.Context;

import com.example.project.model.Acc;
import com.example.project.model.AccessDistant;
import com.example.project.model.CartArticles;
import com.example.project.model.Favorite;
import com.example.project.model.Ticket;

import org.json.JSONArray;

import java.util.ArrayList;

public final class Control {

    private static Control instance = null;
    private static CartArticles cartarticle;
    private static Acc account;
    private static Favorite fav;
    private static Ticket ticket;
    private static AccessDistant accessDistant;
    private static Context context;
    private ArrayList<CartArticles> allArticles = new ArrayList<CartArticles>();
    private ArrayList<Acc> allAccount = new ArrayList<Acc>();
    private ArrayList<Favorite> allFavorites = new ArrayList<Favorite>();
    private ArrayList<Ticket> allTicket = new ArrayList<Ticket>();


    /**
     * constructor private
     */
    private Control()
    {
        super();
    }

    /**
     * Creation of instance
     * @return instance
     */

    public static final Control getInstance(Context context)
    {
        if(context != null)
        {
            Control.context = context;
        }

        if(Control.instance == null)
        {
            Control.instance = new Control();
            accessDistant = new AccessDistant();
            //get all information of the database
            accessDistant.sendAcc("allAcc", new JSONArray());
            accessDistant.send("all", new JSONArray());
            accessDistant.sendFav("allFav", new JSONArray());
            accessDistant.sendTs("allTs", new JSONArray());
        }

        return Control.instance;
    }


    /**
     * get All articles
     * @return allArticles
     */
    public ArrayList<CartArticles> getAllArticles() {
        return allArticles;
    }

    /**
     * set All articles
     * @param allArticles
     */
    public void setAllArticles(ArrayList<CartArticles> allArticles) {
        this.allArticles = allArticles;
    }

    /**
     * get All account
     * @return allAccount
     */
    public ArrayList<Acc> getAllAccount() {
        return allAccount;
    }

    /**
     * set All articles
     * @param allAccount
     */
    public void setAllAccount(ArrayList<Acc> allAccount) {
        this.allAccount = allAccount;
    }

    /**
     * get All all Favorites
     * @return all Favorites
     */
    public ArrayList<Favorite> getAllFavorites() {
        return allFavorites;
    }

    /**
     * set All all Favorites
     * @param allFavorites
     */
    public void setAllFavorites(ArrayList<Favorite> allFavorites) {
        this.allFavorites = allFavorites;
    }

    /**
     * get All all Tshirt
     * @return allTshirt
     */
    public ArrayList<Ticket> getAllTshirt() {
        return allTicket;
    }

    /**
     * set All all Tshirt
     * @param allTshirt
     */
    public void setAllTshirt(ArrayList<Ticket> allTshirt) {
        this.allTicket = allTshirt;
    }

    /**
     * Delete article in cart
     * @param cartArticles
     * @param position
     */
    public void delCart(CartArticles cartArticles, int position)
    {
        accessDistant.send("del", cartArticles.convertToJSONArray());
        allArticles.remove(position);
        setAllArticles(allArticles);
    }

    /**
     * delete fav article in favorite
     * @param favorite
     * @param position
     */
    public void delFav(Favorite favorite, int position)
    {
        accessDistant.sendFav("delFav", favorite.convertToJSONArray());
        allFavorites.remove(position);
        setAllFavorites(allFavorites);
    }

    /**
     * delete customs t-shirt
     * @param ticket
     * @param position
     */
    public void delTs(Ticket ticket, int position)
    {
        accessDistant.sendTs("delTs", ticket.convertToJSONArray());
        allTicket.remove(position);
        setAllTshirt(allTicket);
    }

    /**
     * save article in the cart
     * @param article
     */
    public void addCart(String article)
    {
        int id = 0;
        for(int i=0; i<allArticles.size(); i++)
        {
            if(allArticles.get(i).getArticleCart().equals(article))
            {
                id++;
            }
        }
        cartarticle = new CartArticles(article, id+getAllArticles().size()-1);


        allArticles.add(cartarticle);
        accessDistant.send("save", cartarticle.convertToJSONArray());
    }

    /**
     * add account
     * @param firstname
     * @param lastname
     * @param password
     * @param email
     */
    public void AddAcc(String firstname, String lastname, String password, String email)
    {
        account = new Acc(firstname,lastname,password,email);
        allAccount.add(account);
        accessDistant.sendAcc("saveAcc", account.convertToJSONArray());
    }

    /**
     * add favorite
     * @param favorite
     */
    public void addFavorite(String favorite)
    {

        int id = 0;
        for(int i=0; i<allFavorites.size(); i++)
        {
            if(allFavorites.get(i).getFav().equals(favorite))
            {
                id++;
            }
        }

        fav = new Favorite(favorite,id);
        allFavorites.add(fav);
        accessDistant.sendFav("saveFav", fav.convertToJSONArray());
    }

    /**
     * add customs t-shirt
     * @param color
     * @param size
     * @param name
     */
    public void AddTshirt(String color, String size, String name)
    {
        ticket = new Ticket(color,size,name);
        allTicket.add(ticket);
        accessDistant.sendTs("saveTs", ticket.convertToJSONArray());
    }


    /**
     * set Cart
     * @param cartArticles
     */
    public void setCart(CartArticles cartArticles)
    {
        Control.cartarticle = cartArticles;
    }

    /**
     * set Account
     * @param account
     */
    public void setAcc(Acc account)
    {
        Control.account = account;
    }

    /**
     * set Favorite
     * @param fav
     */
    public void setFavorite(Favorite fav)
    {
        Control.fav = fav;
    }

    /**
     * set Customs tshirt
     * @param tshirt
     */
    public void setTshirt(Ticket tshirt)
    {
        Control.ticket = tshirt;
    }




}
