import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class ParticleSystem extends JPanel {
    private ArrayList<Particle> particles = new ArrayList<>();
    private Random rand = new Random();
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    // Particle class to define individual particle properties
    class Particle {
        double x, y;         // Position
        double dx, dy;       // Velocity
        Color color;         // Particle color
        int size;            // Particle size
        float alpha;         // Transparency

        Particle() {
            x = rand.nextInt(WIDTH);
            y = rand.nextInt(HEIGHT);
            dx = (rand.nextDouble() * 4) - 2;  // Random velocity -2 to 2
            dy = (rand.nextDouble() * 4) - 2;
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            size = rand.nextInt(10) + 5;
            alpha = 1.0f;
        }

        void move() {
            x += dx;
            y += dy;
            
            // Bounce off walls
            if (x < 0 || x > WIDTH - size) dx = -dx;
            if (y < 0 || y > HEIGHT - size) dy = -dy;
            
            // Slight random drift and fade
            dx += (rand.nextDouble() - 0.5) * 0.1;
            dy += (rand.nextDouble() - 0.5) * 0.1;
            alpha -= 0.005f;
            if (alpha < 0) alpha = 0;
        }
    }

    public ParticleSystem() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Add initial particles
        for (int i = 0; i < 100; i++) {
            particles.add(new Particle());
        }

        // Animation timer
        Timer timer = new Timer(16, new ActionListener() {  // ~60 FPS
            @Override
            public void actionPerformed(ActionEvent e) {
                updateParticles();
                repaint();
            }
        });
        timer.start();

        // Mouse listener to add new particles on click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i = 0; i < 5; i++) {
                    particles.add(new Particle());
                }
            }
        });
    }

    private void updateParticles() {
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            p.move();
            if (p.alpha <= 0) {
                particles.remove(i);
                particles.add(new Particle()); // Replace faded particles
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                           RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw particles
        for (Particle p : particles) {
            g2d.setColor(new Color(p.color.getRed(), p.color.getGreen(), 
                                 p.color.getBlue(), (int)(p.alpha * 255)));
            g2d.fillOval((int)p.x, (int)p.y, p.size, p.size);
        }

        // Draw "Sufyan" in the top-left corner
        g2d.setColor(new Color(255, 255, 255, 180)); // White with some transparency
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.drawString("Sufyan", 20, 40);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Particle System Simulation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ParticleSystem());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}