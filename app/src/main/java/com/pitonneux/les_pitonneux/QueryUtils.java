package com.pitonneux.les_pitonneux;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * this class is used to extract JSON
 */

// we declared final so it can't be subclassed
public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils(){

    }


    public static ArrayList<ListItem> fetchListItemData(String requestUrl){
        //create the url with our own method
        URL url = createUrl(requestUrl);
        //perform the Http request our own method
        String jsonResponse = null;
        try{

            jsonResponse = makeHttpRequest(url);

        }catch (IOException e){
            Log.e(QueryUtils.class.getSimpleName(), "Error closing input stream", e);

        }
        //here we prepare a list of ListItem to return
        ArrayList<ListItem> listItems = extractListItem(jsonResponse);

        return listItems;
    }



    /**
     *
     * the method encapsulate the url inside a try/catch block
     * @param stringUrl the url of http String
     * @return a valid url
     */
    private static URL createUrl(String stringUrl){
        URL url = null;// outside the try/catch for the variable scope
        try{
            url = new URL(stringUrl);
        }catch (MalformedURLException e){
            Log.e(QueryUtils.class.getSimpleName(),"invalid url",e);
            return null;//here it ends the method with null not executing the rest of the code
        }

        return url ;
    }


    /**
     *
     * @param url the request url passed in by the {{@link #fetchListItemData(String)}}
     * @return a string containing the JSON response
     * @throws IOException we need to handle the InputStream error if any, try/catch inside {{@link #fetchListItemData(String)}}
     */
    private static String makeHttpRequest(URL url) throws IOException{
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }


        // REMEMBER TO NOT FORGET THE INTERNET PERMISSION FOR FETCHING DATA AND VERIFY THAT OUR INTERNET WORKS

        // here we consider variable scope to have access inside the try/catch block
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }


    /**
     *
     * @param inputStream takes the inputStream given by the server (request url)
     * @return build and return the String containing the server response
     * @throws IOException handle the InputStream error if any, try/catch inside {{@link #makeHttpRequest(URL)}}
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }





    /**
     * Return a list of {@link ListItem} objects that has been built up from
     * parsing a JSON response.
     */
    private static ArrayList<ListItem> extractListItem(String listItemJSON) {

        // Create an empty ArrayList that we can start adding listItems from the JSON key values
        ArrayList<ListItem> listItems = new ArrayList<>();

        //TODO iterate to map keys
        try {

            // the baseJsonResponse is actually a JSONObject
            JSONObject baseJsonResponse = new JSONObject(listItemJSON);

            // here we extract the array in the JSON key value "features"
            JSONObject listItemObject = baseJsonResponse.getJSONObject("115862");


            String title = listItemObject.getString("title");
            String description = listItemObject.getString("description");





                // and url from the JSON response.
                listItems.add(new ListItem(title,description));


        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of listItems
        return listItems;
    }

}
