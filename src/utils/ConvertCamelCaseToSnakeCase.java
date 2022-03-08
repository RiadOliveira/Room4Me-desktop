package utils;

public class ConvertCamelCaseToSnakeCase {
    public static String execute(String text) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        
        return text.replaceAll(regex, replacement).toLowerCase();
    }
}
