package com.klezovich.small_problems.json;

/*Requirement
We are in a Star Wars Celebration in 2015, a number of fans are arguing about which characters appeared in which Star Wars films, before the situation goes out of control we've decided to produce a resource to help solving the issue.


Your job is, given a film name and a character name, produce two lists, one with all the names of the characters who appeared in the given film in alphabetical order, and another one with all the names of the films where the given character appeared in alphabetical order. Take into account that some self-proclaimed fans might think Spock appeared in Return of the Jedi, in that case please return "none" instead of the name of the films.


To do so, you will be using the Swapi API, which documentation can be found here: https://challenges.hackajob.co/swapi/documentation, which enpoints are: https://challenges.hackajob.co/swapi/api/.


INPUT
string      Film
string      Character


OUTPUT
string      Film: CharacterA, CharacterB, CharacterC; Character: FilmA, FilmB, FilmC


EXAMPLE 1
Input
"A New Hope","Raymus Antilles"
Output
A New Hope: Beru Whitesun lars, Biggs Darklighter, C-3PO, Chewbacca, Darth Vader, Greedo, Han Solo, Jabba Desilijic Tiure, Jek Tono Porkins, Leia Organa, Luke Skywalker, Obi-Wan Kenobi, Owen Lars, R2-D2, R5-D4, Raymus Antilles, Wedge Antilles, Wilhuff Tarkin; Raymus Antilles: A New Hope, Revenge of the Sith


EXAMPLE 2
Input
"The Force Awakens", "Poggle the Lesser"
Output
The Force Awakens: Ackbar, BB8, Captain Phasma, Chewbacca, Finn, Han Solo, Leia Organa, Luke Skywalker, Poe Dameron, R2-D2, Rey; Poggle the Lesser: Attack of the Clones, Revenge of the Sith


EXAMPLE 3
Input
"The Force Awakens", "Walter White"
Output
The Force Awakens: Ackbar, BB8, Captain Phasma, Chewbacca, Finn, Han Solo, Leia Organa, Luke Skywalker, Poe Dameron, R2-D2, Rey; Walter White: none
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonStarwars2 {

	static class UrlMaker {
		
		static String jsonFormatReq = "&format=json";
		
		static String formUrlToGetNthCharacter( int num ) {
			String urlBase = "https://challenges.hackajob.co/swapi/api/people/";
			return urlBase + num +"/"+jsonFormatReq;
		}
		
		static String formSearchUrlForFilm(String filmName) {

			String urlBase = "https://challenges.hackajob.co/swapi/api/films/?search=";
			String urlEnd="";
			try {
				urlEnd = java.net.URLEncoder.encode(filmName, "UTF-8").replace("+", "%20");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return urlBase+urlEnd+jsonFormatReq;
		}

		static String formSearchUrlForCharacter(String charName) {
			String urlBase = "https://challenges.hackajob.co/swapi/api/people/?search=";
			String urlEnd="";
			try {
				urlEnd = java.net.URLEncoder.encode(charName, "UTF-8").replace("+", "%20");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return urlBase+urlEnd+jsonFormatReq;
		}

	}

	static JsonObject getJsonResponseForUrl(String urlString) {
		//System.out.println("Pinging URL:" + urlString );
		URL url=null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//System.out.println("Pinging URL:" + url);
		JsonObject jsonObject = null;
		try {

			StringBuilder result = new StringBuilder();

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);

			}
			//System.out.println(result.toString());
			rd.close();

			jsonObject = new JsonParser().parse(result.toString()).getAsJsonObject();

		} catch (Exception e) {

		}

		return jsonObject;
	}
	

	
	static String getNthCharacterNameFromUrl( String charUrl ) {
		String url = charUrl;
		JsonObject joChar = getJsonResponseForUrl(url);
		String charName = joChar.get("name").getAsString();
		return charName;
	}
	
	static String getNthFilmNameFromUrl( String filmUrl ) {
		String url = filmUrl;
		JsonObject joFilm = getJsonResponseForUrl(url);
		String filmName = joFilm.get("title").getAsString();
		return filmName;
	}
	
	
	static List<String> getFilmListForCharacter( JsonObject charSearchRes ){
		List<String> liFilm = new ArrayList<>();
		JsonObject joChar = charSearchRes.getAsJsonArray("results").get(0).getAsJsonObject();
		//System.out.println("Character object from search:" + joChar );
		JsonArray filmLinkArray = joChar.get("films").getAsJsonArray();
		
		for( int ii=0; ii<filmLinkArray.size(); ii++ ) {
	        String filmUrl = filmLinkArray.get(ii).getAsString();
	        //System.out.println("Film URL" + filmUrl);
	        String filmTitle = getNthFilmNameFromUrl(filmUrl + "?format=json");
	        liFilm.add(filmTitle);
		}
		
		return liFilm;
	}
	
	static List<String> getCharacterListForFilm( JsonObject filmSearchRes ){
		
		List<String> liChar = new ArrayList<>();
		JsonObject joFilm = filmSearchRes.getAsJsonArray("results").get(0).getAsJsonObject();
		//System.out.println("Film object from search:"+joFilm);
		JsonArray characterLinkArray = joFilm.get("characters").getAsJsonArray();
		
		for( int ii=0; ii< characterLinkArray.size(); ii++ ) {
			String charUrl = characterLinkArray.get(ii).getAsString();
			//System.out.println(charUrl);
			String charName = getNthCharacterNameFromUrl(charUrl + "?format=json");
			//System.out.println(charName);
			liChar.add(charName);
		}
		
		return liChar;
		
	}
	
	static String convertListToCsvString( List<String> li ) {
		
		String separator =", ";
		
		StringBuilder sb = new StringBuilder();
		for( String s : li ) {
			sb.append(separator).append(s);
		}
		
		String res = sb.substring(separator.length());
		return res;
	}
	

	public static String run(String film, String character) {

		String filmUrl = UrlMaker.formSearchUrlForFilm(film);
		JsonObject joFilmSearchRes = getJsonResponseForUrl(filmUrl); 
		
		List<String> filmCharacterList = getCharacterListForFilm(joFilmSearchRes);
		Collections.sort(filmCharacterList);
		
		String charUrl = UrlMaker.formSearchUrlForCharacter(character);
		JsonObject joCharSearchRes = getJsonResponseForUrl(charUrl);
		
		String charResStr = convertListToCsvString(filmCharacterList);
		
		// Character not found
		String filmResStr = "none";
		if( joCharSearchRes.get("count").getAsInt() != 0 ) {
			List<String> charFilmList = getFilmListForCharacter(joCharSearchRes);
			Collections.sort(charFilmList);
						
			//System.out.println(charResStr);
			filmResStr = convertListToCsvString(charFilmList);
		}
		
		//System.out.println("Film object:"+joFilmSearchRes);
		//System.out.println("Character object:"+ joCharSearchRes);
		
		
		
				//System.out.println(filmResStr);
		
		
		String filmsAndCharacters = film+": "+charResStr+"; "+character +": "+ filmResStr;
		return filmsAndCharacters;
	}
	
	public static void main(String[] args) {
		System.out.println(run("A New Hope", "Luke Skywalker" ));
		System.out.println( run("A New Hope", "Spok") );
	}

}
