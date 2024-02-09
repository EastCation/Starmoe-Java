import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SerialNumberGenerator {
    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SEGMENT_LENGTH = 5;
    private static final int SEGMENT_COUNT = 5;
    private static final String SEPARATOR = "-";

    public static String generateSerialNumber() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < SEGMENT_COUNT; i++) {
            for (int j = 0; j < SEGMENT_LENGTH; j++) {
                sb.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
            }
            if (i < SEGMENT_COUNT - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    public static List<String> generateMultipleSerialNumbers(int count) {
        List<String> serialNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            serialNumbers.add(generateSerialNumber());
        }
        return serialNumbers;
    }

    public static void main(String[] args) {
        List<String> serialNumbers = generateMultipleSerialNumbers(50
        );//此处设定数量
        for (String serialNumber : serialNumbers) {
            System.out.println(serialNumber);
        }
    }
}