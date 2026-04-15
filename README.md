# FinRadar 💸

**Gizlilik Odaklı Akıllı Harcama ve Abonelik Takipçisi**

FinRadar, banka bildirimlerinizi yerel olarak analiz ederek harcamalarınızı ve aboneliklerinizi otomatik olarak takip eden, kullanıcı gizliliğini en ön planda tutan bir Android uygulamasıdır. Verileriniz asla cihazınızdan dışarı çıkmaz.

## 🌟 Öne Çıkan Özellikler

-   **🔔 Otomatik Tespit**: Banka harcama bildirimlerini (SMS/Push) gerçek zamanlı olarak yakalar ve harcamalarınızı otomatik olarak kategorize eder.
-   **🔒 Üst Düzey Güvenlik (Zero-Knowledge)**: Yerel veritabanınız **SQLCipher** ile endüstri standardı **AES-256 bit** şifreleme ile korunur. Şifreleme anahtarı cihazınızın güvenli donanım alanında (**Android Keystore**) saklanır.
-   **🛡️ Gizlilik Önceliği**: İnternet erişimi sadece isteğe bağlı döviz kuru güncellemeleri için kullanılır. Verileriniz hiçbir bulut sunucusuna yedeklenmez, tamamen size aittir.
-   **📶 Çevrimdışı Çalışma**: İnternet bağlantısına ihtiyaç duymadan tüm özelliklerini sunar.
-   **🌍 Çok Dilli Destek**: Türkçe, İngilizce, Almanca, Fransızca, İspanyolca, Arapça, Çince, Japonca ve Rusça dillerini destekler.
-   **📈 Akıllı Uyarılar**: Abonelik fiyatlarındaki beklenmedik artışları tespit eder ve sizi uyarır.

## 🛠️ Teknoloji Yığını

-   **Dil**: %100 Kotlin
-   **UI**: Jetpack Compose (Material 3 - Modern & Dinamik Tasarım)
-   **Mimari**: MVVM + Clean Architecture + Usecase Pattern
-   **SDK Desteği**: Target SDK 35 (Android 15) / Min SDK 26
-   **Dependency Injection**: Hilt
-   **Veritabanı**: Room + SQLCipher (Encrypted SQLite)
-   **Arka Plan İşlemleri**: WorkManager
-   **Yerel Tercihler**: DataStore (Preferences)
-   **Güvenlik**: Android Keystore API & Biometric API

## 🚀 Başlarken

1.  Depoyu klonlayın (`git clone`).
2.  Android Studio (En güncel sürüm önerilir) ile projeyi açın.
3.  Gradle senkronizasyonunu tamamlayın.
4.  Uygulamayı bir cihazda (API 26+) çalıştırın.
5.  Uygulamanın çalışması için **"Bildirim Erişimi"** iznini vermeniz gerekmektedir.

## 📝 Gizlilik Politikası

FinRadar'ın temel felsefesi verinizi cihazınızda tutmaktır. Uygulamayı sildiğiniz an, tüm verileriniz kalıcı olarak yok olur. Sunucu üzerinde hiçbir yedeğiniz tutulmaz.

---
**İletişim:** [fn.raadar@gmail.com](mailto:fn.raadar@gmail.com)
