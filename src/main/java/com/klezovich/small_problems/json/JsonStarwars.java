package com.klezovich.small_problems.json;

import java.io.*;
import java.net.*;
import com.google.gson.*;

/*
 *  This is a solution for one of the challenges as https://app.hackajob.co
 *  The goal is to use implement a static method .run() for this class, such that 
 *  given a name of star wars character it will use the SWAPI API (https://challenges.hackajob.co/swapi/documentation)
 *  to count the number of starwars movies in which this character has appeared
 */

public class JsonStarwars {

	public static int run(String character) {

		// Loop through all characters

		int curCharNum = 1;
		boolean lastCharFound = false;

		while (!lastCharFound) {

			JsonObject jo = getCharacterData(curCharNum);
			// System.out.println("CharacterDataJsonObject:"+jo);
			String cName = getCharacterName(jo);

			System.out.println("Num:" + curCharNum + "Name:" + cName);

			System.out.println("OriginalName:" + character);
			System.out.println("FoundName:" + cName);

			if (cName.equals(character)) {
				return getFilmCount(jo);
			}

			if (!isLastCharacter(jo)) {
				curCharNum++;
			} else {
				lastCharFound = true;
			}

		}

		// if one of them matches - return film count
		return 0;
	}

	private static boolean isLastCharacter(JsonObject jo) {
		Object nextFieldValue = jo.get("next");
		if (nextFieldValue == null) {
			return true;
		}

		return false;
	}

	private static int getFilmCount(JsonObject jo) {
		JsonArray jaFilms = jo.getAsJsonArray("films");
		System.out.println("Films:" + jaFilms);
		return jaFilms.size();

	}

	private static String getCharacterName(JsonObject jo) {
		String name = jo.get("name").toString();
		name = name.substring(1);
		name = name.substring(0, name.length() - 1);
		// System.out.println("Name is:" + name);
		return name;
	}

	private static JsonObject getCharacterData(int num) {

		URL url = formUrlForNthCharacter(num);
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
			rd.close();

			jsonObject = new JsonParser().parse(result.toString()).getAsJsonObject();

		} catch (Exception e) {

		}

		return jsonObject;

	}

	private static URL formUrlForNthCharacter(int charNum) {

		// https://challenges.hackajob.co/swapi/api/people/1/
		String sUrl = "http://challenges.hackajob.co/swapi/api/people/" + charNum + "/?format=json";

		URL url = null;

		try {
			url = new URL(sUrl);
		} catch (Exception e) {
		}

		return url;
	}

	public static void main(String[] args) {

		JsonStarwars s = new JsonStarwars();
		System.out.println(s.run("Luke Skywalker"));

	}

}