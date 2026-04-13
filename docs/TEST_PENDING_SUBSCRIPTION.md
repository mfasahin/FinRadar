# Abonelik Onay Diyaloğunu Test Etme

## 1. Hızlı test (emülatör / cihaz)

1. Uygulamayı çalıştır, **Ayarlar** sekmesine git.
2. **UYGULAMA** kartında **"Abonelik diyaloğunu test et"** satırına dokun.
3. Hemen **"Abonelik tespit edildi"** diyaloğu açılır (Netflix Test — 49,99 TL/ay).
4. **Kaydet** → Abonelik listesine eklenir; **İptal** → Hiçbir şey kaydedilmez.

Bu, diyaloğun ve Kaydet/İptal akışının çalıştığını doğrular.

---

## 2. Gerçek bildirimle test (tam akış)

Bildirimden gelen mesajın **abonelik** olarak tespit edilip diyaloğun çıkması için:

1. **Bildirim dinleme izni** açık olsun (onboarding’de verilmiş olmalı).
2. Cihazda/emülatörde bir **bildirim** tetikle; bildirim **metni** aşağıdaki banka kalıplarından birine uysun ve abonelik adı (Netflix, Spotify vb.) geçsin.

### Örnek bildirim metinleri (Türkçe)

- **İş Bankası:** `Harcama: 49,99 TL Netflix`
- **Garanti:** `49,99 TL Netflix'den çekildi`
- **Yapı Kredi:** `49,99 TL tutarinda Netflix'e ödeme`

### Emülatörde bildirim tetikleme

**Seçenek A – Başka bir uygulama:**  
“Notification Listener” veya “Test Notification” tarzı bir uygama ile yukarıdaki metinlerden birini içeren bildirim gönder.

**Seçenek B – ADB (Android 10+):**  
Başka bir paketten bildirim simüle etmek için örneğin:

```bash
adb shell "cmd notification post -t test -S bigText com.android.systemui 'İş Bankası' 'Harcama: 49,99 TL Netflix'"
```

(Emülatör sürümüne göre `cmd notification` davranışı değişebilir; çalışmazsa Seçenek A’yı kullan.)

3. Bildirim geldikten sonra **uygulamayı aç** (arka plandaysa ön plana getir).
4. **"Abonelik tespit edildi"** diyaloğu görünmeli; **Kaydet** veya **İptal** ile test et.

---

## Özet

| Yöntem | Ne test edilir |
|--------|-----------------|
| Ayarlar → **Abonelik diyaloğunu test et** | Diyaloğun görünmesi, Kaydet/İptal |
| Gerçek bildirim + uygulama açma | SMS/bildirim → tespit → bekleyen abonelik → diyalog |
