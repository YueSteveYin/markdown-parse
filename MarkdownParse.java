// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        String[] input = markdown.split("\n", 0);
        for(int i = 0; i<input.length; i++)
        {
            if(input[i].contains("[") && input[i].contains("]") && (input[i].contains("link")|| input[i].contains("Link")))
            {
                String website = input[i].substring(input[i].indexOf("(")+1, input[i].lastIndexOf(")"));
                toReturn.add(website);
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}
