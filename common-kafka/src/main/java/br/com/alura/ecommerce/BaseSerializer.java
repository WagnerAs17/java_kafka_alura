package br.com.alura.ecommerce;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class BaseSerializer {
    protected final Gson gson = new GsonBuilder().registerTypeAdapter(Message.class, new MessageAdapter()).create();

}
