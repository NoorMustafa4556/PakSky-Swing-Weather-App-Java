
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyWeatherAppGUI
        extends JFrame implements ActionListener {

    // GUI Components
    JTextField cityTextField;
    JButton getWeatherButton;
    JLabel temperatureLabel;
    JLabel descriptionLabel;
    JLabel instructionLabel;

    private List<String> knownCities = Arrays.asList(
            "karachi", "lahore", "islamabad", "rawalpindi", "faisalabad", "multan", "peshawar",
            "quetta", "gujranwala", "sialkot", "hyderabad", "sargodha", "bahawalpur", "sukkur",
            "sheikhupura", "mardan", "gujrat", "kasur", "rahim yar khan", "sahiwal", "okara",
            "vehari", "khanewal", "jhelum", "dera ghazi khan", "muzaffargarh", "khushab",
            "chiniot", "jhang", "bahawalnagar", "mandi bahauddin", "hafizabad", "narowal",
            "toba tek singh", "pakpattan", "chakwal", "mianwali", "layyah", "bhakkar",
            "lodhran", "burewala", "kamalia", "arifwala", "chishtian", "sadiqabad", "kamoke",
            "gujar khan", "murree", "pattoki", "raiwind", "dera ismail khan", "karak", "bannu",
            "chaman", "swat", "mirpur", "kotli", "muzaffarabad", "skardu", "gilgit", "khairpur",
            "jacobabad", "shikarpur", "umerkot", "nawabshah", "larkana", "mithi", "dadu",
            "badin", "tando adam", "tando allahyar", "kot adu", "hangu", "tank", "chitral",
            "dir", "buner", "swabi", "haripur", "abbottabad", "mansehra", "battagram", "torghar",
            "musa khel", "zhob", "kalat", "turbat", "gwadar", "nushki", "sibi", "dera bugti",
            "lasbela", "jiwani", "harnai", "khuzdar");

    // 2. Constructor
    public MyWeatherAppGUI() {
        setTitle("Weather App");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(70, 130, 180));

        instructionLabel = new JLabel("Enter City:");
        instructionLabel.setBounds(20, 20, 100, 30);
        instructionLabel.setForeground(Color.WHITE);
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(instructionLabel);

        cityTextField = new JTextField("");
        cityTextField.setBounds(130, 20, 180, 30);
        cityTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        add(cityTextField);

        getWeatherButton = new JButton("Get Weather");
        getWeatherButton.setBounds(320, 20, 110, 30);
        getWeatherButton.setFont(new Font("Arial", Font.BOLD, 12));
        getWeatherButton.setBackground(new Color(30, 144, 255));
        getWeatherButton.setForeground(Color.WHITE);
        getWeatherButton.addActionListener(this);
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
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getWeatherButton) {
            String cityInput = cityTextField.getText().trim();

            if (cityInput.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a city name.", "Input Error",
                        JOptionPane.ERROR_MESSAGE);
                temperatureLabel.setText("Temperature: -- °C");
                descriptionLabel.setText("Description: ---");
                return;
            }

            if (knownCities.contains(cityInput.toLowerCase())) {
                Random random = new Random();
                double temp = 10 + (35 - 10) * random.nextDouble();
                String[] conditions = { "clear sky", "few clouds", "scattered clouds", "broken clouds", "shower rain",
                        "rain", "thunderstorm", "snow", "mist" };
                String desc = conditions[random.nextInt(conditions.length)];

                temperatureLabel.setText(String.format("Temperature: %.2f°C", temp));
                descriptionLabel.setText("Description: " + desc);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Weather data not available for '" + cityInput
                                + "'.\nPlease enter a valid city from our list (e.g., London, Paris, Islamabad).",
                        "City Not Found", JOptionPane.WARNING_MESSAGE);
                temperatureLabel.setText("Temperature: -- °C");
                descriptionLabel.setText("Description: ---");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new MyWeatherAppGUI();
            }
        });
    }
}