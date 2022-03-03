package HtmlConvertPackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import workshop.PatternMatcher;

public class PlaintextToHtmlConverter {
  
    List<PatternMatcher> patternMatchers;
    public String toHtml() throws Exception {
        String text = read();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String read() throws IOException {
    	Path filePath = Paths.get("sample.txt");
    	byte[] fileByteArray = Files.readAllBytes(filePath);
        return new String(fileByteArray);
    }

    private String basicHtmlEncode(String source) {
        
        int i = 0;
        List<String> result = new ArrayList<>();
        List<String> convertedLine = new ArrayList<>();
        char characterToConvert = '\n';
        //String characterToConvert = stashNextCharacterAndAdvanceThePointer(source);
        for (PatternMatcher patternMatcher : patternMatchers) {
            if(patternMatcher.matches(characterToConvert))convertedLine.add(patternMatcher.generateRresponse());
            
        }
        addANewLine(result,convertedLine);
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

   
    //stringfy convertedLine array and push into result
    //reset convertedLine
    private void addANewLine(List<String> result,List<String> convertedLine) {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushACharacterToTheOutput(List<String> convertedLine,String characterToConvert) {
        convertedLine.add(characterToConvert);
    }
}
