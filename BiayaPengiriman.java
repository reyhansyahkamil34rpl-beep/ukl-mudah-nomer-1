import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class BiayaPengiriman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            // Input
            System.out.print("Masukkan berat paket (kg): ");
            double berat = input.nextDouble();

            System.out.print("Masukkan jarak pengiriman (km): ");
            double jarak = input.nextDouble();

            System.out.print("Masukkan panjang paket (cm): ");
            double panjang = input.nextDouble();

            System.out.print("Masukkan lebar paket (cm): ");
            double lebar = input.nextDouble();

            System.out.print("Masukkan tinggi paket (cm): ");
            double tinggi = input.nextDouble();

            // Validasi sederhana: tidak boleh negatif
            if (berat < 0 || jarak < 0 || panjang < 0 || lebar < 0 || tinggi < 0) {
                System.out.println("Nilai tidak boleh negatif.");
                return;
            }

            // Hitung volume (cm^3)
            double volume = panjang * lebar * tinggi;

            // Tentukan biaya per kg berdasarkan jarak
            double biayaPerKg = (jarak <= 10) ? 4250 : 6000;

            // Hitung biaya awal berdasarkan berat
            double totalBiaya = berat * biayaPerKg;

            // Tambahkan biaya volume jika melebihi ambang 100 cm^3
            final double VOLUME_THRESHOLD = 100.0; // 100 cm^3 sesuai soal
            if (volume > VOLUME_THRESHOLD) {
                totalBiaya += 50000;
            }

            // Format mata uang (Rp) tanpa desimal
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            nf.setMaximumFractionDigits(0);

            // Output
            System.out.println("\n=== Rincian Pengiriman ===");
            System.out.println("Berat paket      : " + berat + " kg");
            System.out.println("Jarak pengiriman : " + jarak + " km");
            System.out.println("Volume paket     : " + String.format("%.0f", volume) + " cm^3");
            System.out.println("Biaya per kg     : " + nf.format(biayaPerKg));
            System.out.println("Biaya volume     : " + (volume > VOLUME_THRESHOLD ? nf.format(50000) : nf.format(0)));
            System.out.println("Total biaya pengiriman : " + nf.format(totalBiaya));
        } finally {
            input.close();
        }
    }
}