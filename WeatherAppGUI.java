// ... (Yahan wohi code jo pehle share kiya gaya tha) ...
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class WeatherAppGUI extends JFrame implements ActionListener {

    // GUI Components
    JTextField cityTextField;
    JButton getWeatherButton;
    JLabel temperatureLabel;
    JLabel descriptionLabel;
    JLabel instructionLabel;

    public WeatherAppGUI() {
        setTitle("Weather App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(70, 130, 180)); // Steel Blue like color

        instructionLabel = new JLabel("Enter City:");
        instructionLabel.setBounds(20, 20, 100, 30);
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(instructionLabel);

        cityTextField = new JTextField(""); // Default text
        cityTextField.setBounds(130, 20, 180, 30);
        cityTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cityTextField);

        getWeatherButton = new JButton("Get Weather");
        getWeatherButton.setBounds(320, 20, 110, 30);
        getWeatherButton.setFont(new Font("Arial", Font.BOLD, 12));
        getWeatherButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        getWeatherButton.setForeground(Color.WHITE);
        getWeatherButton.addActionListener(this); // Listen for button clicks
        add(getWeatherButton);

        temperatureLabel = new JLabel("Temperature: -- °C");
        temperatureLabel.setBounds(50, 100, 350, 40);
        temperatureLabel.setForeground(Color.WHITE);
        temperatureLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(temperatureLabel);

        descriptionLabel = new JLabel("Description: ---");
        descriptionLabel.setBounds(50, 150, 350, 40);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(descriptionLabel);

        setVisible(true);
        setLocationRelativeTo(null); // Center the window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getWeatherButton) {
            String city = cityTextField.getText();
            if (city.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a city name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                temperatureLabel.setText("Temperature: -- °C");
                descriptionLabel.setText("Description: ---");
                return;
            }

            // For now, generate random weather data
            Random random = new Random();
            double temp = 10 + (35 - 10) * random.nextDouble(); // Random temperature between 10 and 35
            String[] conditions = {"clear sky", "few clouds", "scattered clouds", "broken clouds", "shower rain", "rain", "thunderstorm", "snow", "mist"};
            String desc = conditions[random.nextInt(conditions.length)];

            // Update the labels
            temperatureLabel.setText(String.format("Temperature: %.2f°C", temp));
            descriptionLabel.setText("Description: " + desc);
        }
    }

    public static void main(String[] args) {
        // It's good practice to create and show the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WeatherAppGUI();
            }
        });
    }
}