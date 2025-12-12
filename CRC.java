import java.util.Scanner;

public class CRC {

    private static final String FRAME_DELIMITER = "0111110";
    private static final String GENERATOR_POLYNOMIAL = "1011";

    private String performXORDivision(String dividend, String divisor) {
        int divisorLen = divisor.length();
        char[] dividendArr = dividend.toCharArray();

        for (int i = 0; i <= dividend.length() - divisorLen; i++) {
            if (dividendArr[i] == '1') {
                for (int j = 0; j < divisorLen; j++) {
                    dividendArr[i + j] = (dividendArr[i + j] == divisor.charAt(j)) ? '0' : '1';
                }
            }
        }
        return new String(dividendArr).substring(dividend.length() - divisorLen + 1);
    }

    public String generateCRC(String message) {
        int genLen = GENERATOR_POLYNOMIAL.length();
        String appendedMessage = message + "0".repeat(genLen - 1);
        String crc = performXORDivision(appendedMessage, GENERATOR_POLYNOMIAL);
        System.out.println("    -> CRC Checksum Generated: " + crc);
        return message + crc;
    }

    public String bitStuff(String data) {
        StringBuilder stuffedData = new StringBuilder();
        int consecutiveOnes = 0;
        for (char bit : data.toCharArray()) {
            stuffedData.append(bit);
            if (bit == '1') {
                consecutiveOnes++;
            } else {
                consecutiveOnes = 0;
            }
            if (consecutiveOnes == 5) {
                stuffedData.append('0');
                consecutiveOnes = 0;
            }
        }
        System.out.println("    -> Data after Bit Stuffing: " + stuffedData);
        return stuffedData.toString();
    }

    public String frameData(String stuffedData) {
        return FRAME_DELIMITER + stuffedData + FRAME_DELIMITER;
    }

    public String deFrameData(String frame) {
        if (frame.startsWith(FRAME_DELIMITER) && frame.endsWith(FRAME_DELIMITER)) {
            return frame.substring(FRAME_DELIMITER.length(), frame.length() - FRAME_DELIMITER.length());
        }
        return null;
    }

    public String bitDeStuff(String stuffedData) {
        StringBuilder deStuffedData = new StringBuilder();
        int consecutiveOnes = 0;
        for (int i = 0; i < stuffedData.length(); i++) {
            char bit = stuffedData.charAt(i);
            deStuffedData.append(bit);
            if (bit == '1') {
                consecutiveOnes++;
            } else {
                consecutiveOnes = 0;
            }
            if (consecutiveOnes == 5 && (i + 1 < stuffedData.length()) && stuffedData.charAt(i + 1) == '0') {
                i++;
                consecutiveOnes = 0;
            }
        }
        System.out.println("    -> Data after Bit De-stuffing: " + deStuffedData);
        return deStuffedData.toString();
    }

    public void verifyCRC(String codeword) {
        String remainder = performXORDivision(codeword, GENERATOR_POLYNOMIAL);
        System.out.println("    -> CRC Check Remainder: " + remainder);
        
        if (!remainder.contains("1")) {
            System.out.println("\n SUCCESS: No errors detected. Message received correctly.");
            int originalMessageLength = codeword.length() - (GENERATOR_POLYNOMIAL.length() - 1);
            System.out.println("Original Message: " + codeword.substring(0, originalMessageLength));
        } else {
            System.out.println("\n ERROR: Data corruption detected. Message discarded.");
        }
    }

    public static void main(String[] args) {
   CRC cs = new CRC();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an 8-bit binary message (e.g., 10111110): ");
        String message = scanner.nextLine();

        if (message.length() != 8 || !message.matches("[01]+")) {
            System.out.println("Invalid input. Please enter exactly 8 binary digits.");
            scanner.close();
            return;
        }

        System.out.println("\n--- SENDER SIDE ---");
        System.out.println("1. Original Message: " + message);

        System.out.println("\n2. Applying CRC...");
        String codeword = cs.generateCRC(message);
        System.out.println("   Message with CRC (Codeword): " + codeword);

        System.out.println("\n3. Applying Bit Stuffing...");
        String stuffedData = cs.bitStuff(codeword);

        System.out.println("\n4. Framing the data...");
        String transmittedFrame = cs.frameData(stuffedData);
        System.out.println("   Final Transmitted Frame: " + transmittedFrame);

        System.out.println("\n-------------------------------------------------");
        System.out.println("           TRANSMITTING OVER CHANNEL");
        System.out.println("-------------------------------------------------\n");

        System.out.println("--- RECEIVER SIDE ---");
        System.out.println("1. Received Frame: " + transmittedFrame);

        System.out.println("\n2. De-framing the data...");
        String receivedStuffedData = cs.deFrameData(transmittedFrame);
        System.out.println("   Data after De-framing: " + receivedStuffedData);

        System.out.println("\n3. Applying Bit De-stuffing...");
        String receivedCodeword = cs.bitDeStuff(receivedStuffedData);

        System.out.println("\n4. Verifying message integrity using CRC...");
        cs.verifyCRC(receivedCodeword);

        scanner.close();
    }
}