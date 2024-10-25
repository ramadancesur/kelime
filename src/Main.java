import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Main {

    // Tekrar eden harf olup olmadığını kontrol eden yardımcı metot
    private static boolean tekrarEdenHarfVarMi(String kelime) {
        HashSet<Character> harfSeti = new HashSet<>();
        for (char harf : kelime.toCharArray()) {
            if (harfSeti.contains(harf)) {
                return true; // Tekrar eden harf bulundu
            }
            harfSeti.add(harf);
        }
        return false; // Tekrar eden harf yok
    }


    public static void main(String[] args) {
        // 1. Kelime dizisi oluşturun
        String[] kelimeDizisi = {"kalem", "elalem", "kelam", "kelime"};

        // Tekrar eden harfleri içeren kelimeleri burada saklayacağız
        List<String> tekrarliKelimeler = new ArrayList<>();

        // 2. Kelimelerde tekrar eden harfleri kontrol edin
        for (String kelime : kelimeDizisi) {
            if (tekrarEdenHarfVarMi(kelime)) {
                tekrarliKelimeler.add(kelime);
            }
            // 3. Eğer iki kelime bulduysak, aramayı durdurun
            if (tekrarliKelimeler.size() == 2) {
                break;
            }
        }

        // Eğer iki tekrar eden kelime bulunmuşsa devam et
        if (tekrarliKelimeler.size() == 2) {
            // İki kelimeyi birleştirip harf listesi oluşturun
            String kelime1 = tekrarliKelimeler.get(0);
            String kelime2 = tekrarliKelimeler.get(1);
            String birlesikHarfListesi = kelime1 + kelime2;

            // 4. Rastgele harflerden metin oluşturun
            StringBuilder yeniMetin = new StringBuilder();
            Random random = new Random();
            int uzunluk = 6; // İstenen uzunluk (örnekte 6 harfli)

            for (int i = 0; i < uzunluk; i++) {
                int rastgeleIndex = random.nextInt(birlesikHarfListesi.length());
                yeniMetin.append(birlesikHarfListesi.charAt(rastgeleIndex));
            }

            // Sonucu ekrana yazdır
            System.out.println("Tekrar eden harf içeren 2 kelime: " + kelime1 + ", " + kelime2);
            System.out.println("Oluşturulan metin: " + yeniMetin.toString());
        } else {
            System.out.println("Tekrar eden harf içeren yeterli kelime bulunamadı.");
        }
    }
}
