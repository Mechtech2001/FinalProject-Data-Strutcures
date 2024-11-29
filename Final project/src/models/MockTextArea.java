package models;

import javax.swing.JTextArea;

public class MockTextArea extends JTextArea {
    private StringBuilder content = new StringBuilder();

    @Override
    public void append(String str) {
        content.append(str);
    }

    public String getContent() {
        return content.toString();
    }

    public void clearContent() {
        content.setLength(0);
    }
}