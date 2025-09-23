package utils;

import javax.swing.*;

public class InputCheck {

    // Validates that a string is not null or empty
    public static String validateString(String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
        return input.trim();
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