package exam2014;

/**
 * Created by liliya on 23/05/2015.
 */
public class ShiverOrSweat {

    public double read() {

        return 0.0;
    }

    public double readTemperature() throws Exception {

        double reading = read();
        if (reading == -300.00) throw new Exception("Sensor is faulty");
        else return reading;
    }

    public void monitor(double low, double high) {

        while (true) {
            int n = 60;
            try {
                double read = readTemperature();
                int error = 0;
                while (n > 0) {
                    if (read == -300.00) error++;
                    else {
                        if (read < low || read > high) {
                            System.err.println("Temperature needs regulating");
                        }

                    }
                    Thread.sleep(1000);
                    n--;
                }
                if (error == 60) System.err.println("Sensor is broken");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

}
