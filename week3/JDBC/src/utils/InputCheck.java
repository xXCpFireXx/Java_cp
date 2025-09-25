package utils;

import javax.swing.JOptionPane;

public class InputCheck {

    // Validates that a string is not null or empty
    public static String validateString(String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return input.trim();
    }

    // Validates that a string is a valid non-negative integer
    public static int validateInteger(String input, String errorMessage) {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new IllegalArgumentException("The value cannot be negative.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // Validates that a string is a valid non-negative double
    public static double validateDouble(String input, String errorMessage) {
        try {
            double value = Double.parseDouble(input);
            if (value < 0) {
                throw new IllegalArgumentException("The value cannot be negative.");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // Requests and validates a string using JOptionPane
    public static String requestString(String message, String errorMessage) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
            try {
                return validateString(input, errorMessage);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Requests and validates an integer using JOptionPane
    public static int requestInteger(String message, String errorMessage) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
            try {
                return validateInteger(input, errorMessage);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Requests and validates a double using JOptionPane
    public static double requestDouble(String message, String errorMessage) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.QUESTION_MESSAGE);
            try {
                return validateDouble(input, errorMessage);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static int requestConfirm(String message, String errorMessage) {
        while (true) {
            int input = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.YES_NO_OPTION);
            try {
                return validateInteger(String.valueOf(input), errorMessage);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Displays a success message
    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Displays an information message
    public static void showInfoMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    public static void showWarningMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}