package Thread;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDrivenArchitecture {
    public static void main(String[] args) {
        Frame frame = new Frame("Event-Driven Architecture Example");
        frame.setSize(300, 200);

        Button button = new Button("Click Me!");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }
}
