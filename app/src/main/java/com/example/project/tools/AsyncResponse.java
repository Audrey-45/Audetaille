package com.example.project.tools;

import org.json.JSONException;

public interface AsyncResponse {
    void processFinish(String output) throws JSONException;
}

