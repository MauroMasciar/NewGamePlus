package network;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

import debug.Log;*/

public class WebApp {
	public static void sendStatus(String username, String gamename, String user_id, int secondsBeetwenTimes, int state) {
		/*String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/data_app.php?uid=" + user_id + "&name=" + username + "&state=" + state + "&game=" + gamename + "&time=" + Utils.getTotalHoursFromSeconds(secondsBeetwenTimes, false);
		} else {
			url = "https://dywtpn.fun/controller/data_app.php?uid=" + user_id + "&name=" + username + "&state=" + state + "&game=" + gamename + "&time=" + Utils.getTotalHoursFromSeconds(secondsBeetwenTimes, false);
		}
        url = url.replace(" ", "%20");
        send(url);
	}
	
	public static void sendSession(String user_id, String username, String game_name, String library, String platform, String datetime_start, String date_end, int seconds, String token) {
		String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/receive_game_session.php?uid=" + user_id + "&name=" + username  + "&game_name=" + game_name + "&library=" + library + "&platform=" + platform + "&datetime_start=" + datetime_start + "&datetime_end=" + date_end + "&seconds=" + seconds + "&token=" + token;
		} else {
			url = "https://dywtpn.fun/controller/receive_game_session.php?uid=" + user_id + "&name=" + username + "&game_name=" + game_name + "&library=" + library + "&platform=" + platform + "&datetime_start=" + datetime_start + "&datetime_end=" + date_end + "&seconds=" + seconds + "&token=" + token;
		}
		url = url.replace(" ", "%20");
        send(url);
        String dbg = "Enviado a la web: " + game_name + ". Tiempo: " + seconds + " (" + datetime_start + " -> " + date_end + ")";
        Log.Loguear(dbg);
	}
	
	public static void sendAchievement(String user_id, String description, String datetime) {
		String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/receive_achievement.php?uid=" + user_id + "&description=" + description + "&datetime=" + datetime;
		} else {
			url = "https://dywtpn.fun/controller/receive_achievement.php?uid=" + user_id + "&description=" + description + "&datetime=" + datetime;
		} 
		url = url.replace(" ", "%20");
        send(url);
	}
	
	public static void accountUpdate(String user_id, int opt) {
		String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/account_update.php?uid=" + user_id + "&opt=" + opt;
		} else {
			url = "https://dywtpn.fun/controller/account_update.php?uid=" + user_id + "&opt=" + opt;
		}
		url = url.replace(" ", "%20");
        send(url);
	}
	
	public static void newGame(String user_id, String name, int time, String last_played, int completed, int platform, int library, int category, String completed_date) {
		String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/games_list.php?user_id=" + user_id + "&name=" + name + "&time=" + time + "&last_played=" + last_played + "&completed=" + completed + "&platform=" + platform + "&library=" + library + "&category=" + category + "&completed_date=" + completed_date;
		} else {
			url = "https://dywtpn.fun/controller/games_list.php?user_id=" + user_id + "&name=" + name + "&time=" + time + "&last_played=" + last_played + "&completed=" + completed + "&platform=" + platform + "&library=" + library + "&category=" + category + "&completed_date=" + completed_date;
		}
		url = url.replace(" ", "%20");
        send(url);
	}
	
	public static void editGame(String user_id, String name, int time, String last_played, int completed, String completed_date, String platform, String library, String category) {
		String url;
		if(Main.test) {
			url = "http://localhost/www-dywtpn/controller/edit_game.php?user_id=" + user_id + "&name=" + name + "&time=" + time + "&last_played=" + last_played + "&completed=" + completed + "&platform=" + platform + "&library=" + library + "&category=" + category + "&completed_date=" + completed_date;
		} else {
			url = "https://dywtpn.fun/controller/edit_game.php?user_id=" + user_id + "&name=" + name + "&time=" + time + "&last_played=" + last_played + "&completed=" + completed  + "&platform=" + platform + "&library=" + library + "&category=" + category + "&completed_date=" + completed_date;
		}
		url = url.replace(" ", "%20");
        send(url);
	}
	
	private static void send(String url) {
		try {			
			@SuppressWarnings("deprecation")
			URL obj = new URL(url);
	        HttpURLConnection con;
	        
			con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("GET");
	        con.setRequestProperty("cache-control", "no-cache");
	        con.setRequestProperty("X-API-KEY", "myApiKey");
	        con.setRequestProperty("X-API-EMAIL", "myEmail@mail.com");

	        int responseCode = con.getResponseCode();
	        System.out.println("\nSending 'GET' request to URL : " + url);
	        System.out.println("Response Code : " + responseCode);

	        BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();
	        System.out.println(response.toString());
	        
	        /*String dbg = "Web Response Code: " + responseCode;
	        Log.Loguear(dbg);
	        dbg = "Web Response: " + response;
	        Log.Loguear(dbg);*/
	        
	 /*       if(response.toString().equals("FAIL")) JOptionPane.showMessageDialog(null, "Fallo al enviar a tu perfil de DYWTPN Online. Verifica si no la has enviado ya o vuelve a intentarlo mas tarde.\nSi el problema persiste contacte con soporte\n\ncontacto@dywtpn.com\n\nCódigo de error: 1xWS0000001.", "Error", JOptionPane.ERROR_MESSAGE);
	        else if(responseCode != 200) JOptionPane.showMessageDialog(null, "Fallo al enviar a tu perfil de DYWTPN Online. Verifica si no la has enviado ya o vuelve a intentarlo mas tarde.\nSi el problema persiste contacte con soporte\n\ncontacto@dywtpn.com\n\nCódigo de error: 1xWS0000002.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}	
}
