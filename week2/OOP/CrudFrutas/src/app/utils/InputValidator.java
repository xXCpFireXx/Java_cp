package app.utils;

import java.util.Optional;
import javax.swing.JOptionPane;

public class InputValidator {
    private final static String DEFAULT_INVALID_INPUT_MESSAGE = "Entrada inválida. Inténtalo de nuevo";
    private final static String DEFAULT_INVALID_INPUT_PANE_TITLE = "Entrada inválida";

    // String
    public static String requestString(String prompt) {
        return requestString(prompt, DEFAULT_INVALID_INPUT_MESSAGE, false);
    }

    public static String requestString(String prompt, boolean allowEmpty) {
        return requestString(prompt, DEFAULT_INVALID_INPUT_MESSAGE, allowEmpty);
    }

    public static String requestString(String prompt, String invalidInputMessage, boolean allowEmpty) {
        while (true) {
            String inputString = JOptionPane.showInputDialog(null, prompt);
            String trimmedInput = inputString == null ? "" : inputString.trim();
            if (allowEmpty)
                return trimmedInput;

            if (!trimmedInput.isEmpty())
                return trimmedInput;

            JOptionPane.showMessageDialog(null, invalidInputMessage, DEFAULT_INVALID_INPUT_PANE_TITLE,
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Integer
    public static int requestInteger(String prompt, String invalidInputMessage, boolean allowEmpty, int defaultValue) {
        while (true) {
            String inputInteger = requestString(prompt, allowEmpty);
            if (allowEmpty && (inputInteger == null || inputInteger.isEmpty())) {
                return defaultValue; // Devuelve el valor por defecto si se permite vacío
            }

            try {
                return Integer.parseInt(inputInteger); // Convierte y retorna el valor ingresado
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, invalidInputMessage, "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static int requestInteger(String prompt, String invalidInputMessage, int defaultValue) {
        return requestInteger(prompt, invalidInputMessage, false, defaultValue);
    }

    public static int requestInteger(String prompt, int defaultValue) {
        return requestInteger(prompt, "La entrada no es un entero. Inténtalo de nuevo", false, defaultValue);
    }

    public static int requestInteger(String prompt) {
        return requestInteger(prompt, "La entrada no es un entero. Inténtalo de nuevo", false, 0);
    }

    // Double
    public static Optional<Double> requestDouble(String prompt, String invalidInputMessage) {
        return requestDouble(prompt, invalidInputMessage, false);
    }

    public static Optional<Double> requestDouble(String prompt, boolean allowEmpty) {
        return requestDouble(prompt, "La entrada no es un número válido. Inténtalo de nuevo", allowEmpty);
    }

    public static Optional<Double> requestDouble(String prompt) {
        return requestDouble(prompt, "La entrada no es un número válido. Inténtalo de nuevo", false);
    }

    public static Optional<Double> requestDouble(String prompt, String invalidInputMessage, boolean allowEmpty) {
        while (true) {
            String inputDouble = requestString(prompt, allowEmpty);
            double inputCastDouble = 0;
            if (allowEmpty && inputDouble.isEmpty())
                return Optional.empty();
            inputCastDouble = Double.parseDouble(inputDouble);
            try {
                if (inputCastDouble<0){
                    throw new NumberFormatException();
                }
                return Optional.of(inputCastDouble);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, invalidInputMessage, DEFAULT_INVALID_INPUT_PANE_TITLE,
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

}