import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.common.io.CharSink;
import com.google.common.io.Files;

public class JSON_Parsing {
public static void AdverageScore(String input) {
	double all = 0;
	//input = "\"data\": "+input;
	//System.out.println("Two: ----------"+input);
	JSONArray arr = new JSONArray(input);
	//JSONObject obj = new JSONObject(input);
	
	//int output = arr.getJSONObject(0).getJSONObject("alliances").getJSONObject("red").getInt("score");
	for(int i = 0; i< arr.length();i++) {
		for(int ie = 0;ie<3;ie++) {
			if(arr.getJSONObject(i).getJSONObject("alliances").getJSONObject("red").getJSONArray("team_keys").getString(ie).equals("frc254")) {
				System.out.println("Red");
				all+=arr.getJSONObject(i).getJSONObject("alliances").getJSONObject("red").getDouble("score");
			}
			if(arr.getJSONObject(i).getJSONObject("alliances").getJSONObject("blue").getJSONArray("team_keys").getString(ie).equals("frc254")) {
				System.out.println("Blue");
				all+=arr.getJSONObject(i).getJSONObject("alliances").getJSONObject("blue").getDouble("score");
			}
		}
		//if(arr.getJSONObject(i).getJSONObject("alliances").getJSONObject("red").getJSONArray("team_keys").)
	}
	System.out.println(all);
	System.out.println(all/arr.length());
	//System.out.println(arr.length());
	//System.out.println(output);
}

public static ArrayList teamkeys(String input) {
	JSONArray arr = new JSONArray(input);
	ArrayList output = new ArrayList();
	for(int i = 0;i<arr.length();i++) {
		output.add(arr.getString(i));
	}
	return output;
}
public static void WriteToFile(String data, String location) {
    File file = new File(location);
    CharSink sink = Files.asCharSink(file, StandardCharsets.UTF_8);
    try {
        sink.write(data);
    }
    catch(Exception ex)
    {
     System.out.println(ex);
    }
}
}
