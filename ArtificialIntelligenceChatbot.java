import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ArtificialIntelligenceChatbot {

    private static final Map<String, String> knowledgeBase = new HashMap<>();

    public static void main(String[] args) {
        initializeKnowledgeBase();
        SwingUtilities.invokeLater(ArtificialIntelligenceChatbot::createAndShowGUI);
    }

    private static void initializeKnowledgeBase() {
        knowledgeBase.put("hi", "Hello! How can I assist you?");
        knowledgeBase.put("hello", "Hi! Feel free to ask me anything.");
        knowledgeBase.put("how are you", "I'm just code, but I'm functioning perfectly!");
        knowledgeBase.put("what is your name", "I'm a Java-based chatbot, created during the CodeAlpha internship.");
        knowledgeBase.put("what is java", "Java is a high-level, object-oriented programming language used for building applications.");
        knowledgeBase.put("bye", "Goodbye! Have a great day.");
        knowledgeBase.put("thanks", "You're welcome!");
        knowledgeBase.put("help", "You can ask me about Java, programming, or say 'bye' to exit.");
    }

    private static String getResponse(String userInput) {
        userInput = userInput.trim().toLowerCase();

        for (String key : knowledgeBase.keySet()) {
            if (userInput.contains(key)) {
                return knowledgeBase.get(key);
            }
        }
        return "Sorry, I didn't understand that. Can you rephrase?";
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("AI Chatbot - CodeAlpha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {
            String userText = inputField.getText();
            if (!userText.isEmpty()) {
                chatArea.append("You: " + userText + "\n");
                String response = getResponse(userText);
                chatArea.append("Bot: " + response + "\n\n");
                inputField.setText("");
            }
        });

        inputField.addActionListener(e -> sendButton.doClick());

        frame.setVisible(true);
    }
}
