package utils;

import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;

public class DataConverter {
    public static<T extends Number> String convertNumberToCurrencyValue(
        T value
    ) {
        Locale ptBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(ptBr).format(value);
    }

    public static String getParsedPhoneNumber(
        String phoneNumber
    ) {
        String regex = "(\\d{2})(\\d{2})(\\d{1})(\\d{4})(\\d+)";
        String replacement = "+$1($2)$3.$4-$5";

        String parsedPhoneNumber = phoneNumber.replaceFirst(
            regex, replacement
        );
        return parsedPhoneNumber;
    }

    public static String getParsedZipCode(
        int zipCode
    ) {
        String regex = "(\\d{2})(\\d{3})(\\d+)";
        String replacement = "$1.$2-$3";

        String parsedZipCode = String.valueOf(zipCode).replaceFirst(
            regex, replacement
        );
        return parsedZipCode;
    }

    public static String convertCamelCaseToSnakeCase(String content) {
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        String parsedContent = content.replaceAll(
            regex, replacement
        ).toLowerCase();
        
        return parsedContent;
    }

    public static String normalizeTextToCompare(String text) {
        String parsedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        parsedText = parsedText.replaceAll("[^\\p{ASCII}]", "");

        return parsedText.toLowerCase();
    }
}
