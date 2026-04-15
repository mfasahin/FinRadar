package com.finradar.android.presentation.settings

object PrivacyPolicyContent {
    fun getTitle(lang: String) = when (lang) {
        "tr" -> "Gizlilik Politikası"
        "de" -> "Datenschutzerklärung"
        "fr" -> "Politique de Confidentialité"
        "es" -> "Política de Privacidad"
        "ar" -> "سياسة الخصوصية"
        "zh" -> "隐私政策"
        "ja" -> "プライバシーポリシー"
        "ru" -> "Политика конфиденциальности"
        else -> "Privacy Policy"
    }

    fun getLastUpdated(lang: String) = when (lang) {
        "tr" -> "Son Güncelleme: 15 Nisan 2026"
        "de" -> "Zuletzt aktualisiert: 15. April 2026"
        "fr" -> "Dernière mise à jour : 15 avril 2026"
        "es" -> "Última actualización: 15 de abril de 2026"
        "ar" -> "آخر تحديث: 15 أبريل 2026"
        "zh" -> "最后更新：2026年4月15日"
        "ja" -> "最終更新日：2026年4月15日"
        "ru" -> "Последнее обновление: 15 апреля 2026 г."
        else -> "Last Updated: April 15, 2026"
    }

    fun getSections(lang: String) = when (lang) {
        "tr" -> listOf(
            "1. Veri Gizliliği" to "Uygulamamız tarafından taranan veya manuel olarak eklenen hiçbir veri (harcamalar, miktarlar, tarihler vb.) kesinlikle uzak bir sunucuya gönderilmez. Tüm verileriniz sadece sizin cihazınızda kalır.",
            "2. Veri İşleme" to "Banka harcama bildirimlerini tespit etmek için \"Bildirim Erişimi\" izni kullanılır. Bu bilgiler yerel analiz yapıldıktan sonra sadece cihazınızdaki şifreli veritabanında saklanır.",
            "3. Güvenlik" to "Verileriniz, endüstri standardı olan AES-256 bit şifreleme ile (SQLCipher) korunur. Şifreleme anahtarı telefonunuzun güvenli donanım alanında (Android Keystore) saklanır.",
            "4. İzinler" to "Uygulama sadece temel işlevlerini yerine getirmek için \"Bildirim Erişimi\" izni talep eder. Reklam göstermez ve internet erişimi sadece döviz kurları gibi (isteğe bağlı) güncellemeler için kullanılır.",
            "5. Veri Silme" to "Uygulamayı telefonunuzdan sildiğiniz an tüm verileriniz kalıcı olarak yok olur. Sunucuda hiçbir yedeğiniz tutulmaz.",
            "6. İletişim" to "fn.raadar@gmail.com"
        )
        "de" -> listOf(
            "1. Datenschutz" to "Keine von unserer App gescannten oder manuell hinzugefügten Daten (Ausgaben, Beträge, Daten usw.) werden jemals an einen Remote-Server gesendet. Alle Ihre Daten bleiben nur auf Ihrem Gerät.",
            "2. Datenverarbeitung" to "Die Berechtigung „Benachrichtigungszugriff“ wird verwendet, um Bankausgabenbenachrichtigungen zu erkennen. Nach einer lokalen Analyse werden diese Informationen nur in der verschlüsselten Datenbank auf Ihrem Gerät gespeichert.",
            "3. Sicherheit" to "Ihre Daten sind durch die branchenübliche AES-256-Bit-Verschlüsselung (SQLCipher) geschützt. Der Verschlüsselungsschlüssel wird im sicheren Hardwarebereich Ihres Telefons (Android Keystore) gespeichert.",
            "4. Berechtigungen" to "Die App fordert die Berechtigung „Benachrichtigungszugriff“ nur an, um ihre Kernfunktionen zu erfüllen. Sie zeigt keine Werbung an und der Internetzugang wird nur für optionale Updates wie Wechselkurse genutzt.",
            "5. Datenlöschung" to "Sobald Sie die App von Ihrem Telefon löschen, werden alle Ihre Daten dauerhaft vernichtet. Es werden keine Backups Ihrer Daten auf einem Server aufbewahrt.",
            "6. Kontakt" to "fn.raadar@gmail.com"
        )
        "fr" -> listOf(
            "1. Confidentialité des données" to "Aucune donnée scannée ou ajoutée manuellement par notre application (dépenses, montants, dates, etc.) n'est jamais envoyée à un serveur distant. Toutes vos données restent uniquement sur votre appareil.",
            "2. Traitement des données" to "L'autorisation « Accès aux notifications » est utilisée pour détecter les notifications de dépenses bancaires. Après analyse locale, ces informations sont stockées uniquement dans la base de données chiffrée de votre appareil.",
            "3. Sécurité" to "Vos données sont protégées par le chiffrement AES-256 bits (SQLCipher), standard de l'industrie. La clé de chiffrement est stockée dans la zone matérielle sécurisée de votre téléphone (Android Keystore).",
            "4. Autorisations" to "L'application demande l'autorisation « Accès aux notifications » uniquement pour remplir ses fonctions principales. Elle n'affiche pas de publicités et l'accès à Internet n'est utilisé que pour des mises à jour facultatives comme les taux de change.",
            "5. Suppression des données" to "Dès que vous supprimez l'application de votre téléphone, toutes vos données sont définitivement détruites. Aucune sauvegarde de vos données n'est conservée sur un serveur.",
            "6. Contact" to "fn.raadar@gmail.com"
        )
        "es" -> listOf(
            "1. Privacidad de datos" to "Ningún dato escaneado o añadido manualmente por nuestra aplicación (gastos, importes, fechas, etc.) se envía nunca a un servidor remoto. Todos sus datos permanecen únicamente en su dispositivo.",
            "2. Procesamiento de datos" to "El permiso de 'Acceso a notificaciones' se utiliza para detectar notificaciones de gastos bancarios. Tras el análisis local, esta información se almacena únicamente en la base de datos cifrada de su dispositivo.",
            "3. Seguridad" to "Sus datos están protegidos con el cifrado AES de 256 bits (SQLCipher) estándar de la industria. La clave de cifrado se almacena en el área de hardware segura de su teléfono (Android Keystore).",
            "4. Permisos" to "La aplicación solicita el permiso de 'Acceso a notificaciones' solo para realizar sus funciones principales. No muestra anuncios y el acceso a Internet se utiliza únicamente para actualizaciones opcionales como los tipos de cambio.",
            "5. Eliminación de datos" to "En cuanto elimine la aplicación de su teléfono, todos sus datos se destruirán de forma permanente. No se guarda ninguna copia de seguridad de sus datos en ningún servidor.",
            "6. Contacto" to "fn.raadar@gmail.com"
        )
        "ar" -> listOf(
            "1. خصوصية البيانات" to "لا يتم إرسال أي بيانات يتم مسحها ضوئياً أو إضافتها يدوياً بواسطة تطبيقنا (النفقات، المبالغ، التواريخ، إلخ) إلى خادم بعيد. تبقى جميع بياناتك على جهازك فقط.",
            "2. معالجة البيانات" to "يُستخدم إذن \"الوصول إلى الإشعارات\" للكشف عن إشعارات الإنفاق البنكي. بعد التحليل المحلي، يتم تخزين هذه المعلومات فقط في قاعدة البيانات المشفرة على جهازك.",
            "3. الأمان" to "بياناتك محمية بتشفير AES-256 بت المعياري في الصناعة (SQLCipher). يتم تخزين مفتاح التشفير في منطقة الأجهزة الآمنة بهاتفك (Android Keystore).",
            "4. الأذونات" to "يطلب التطبيق إذن \"الوصول إلى الإشعارات\" فقط لأداء وظائفه الأساسية. لا يعرض إعلانات، ويُستخدم الوصول إلى الإنترنت فقط للتحديثات الاختيارية مثل أسعار الصرف.",
            "5. حذف البيانات" to "بمجرد حذف التطبيق من هاتفك، يتم إتلاف جميع بياناتك نهائياً. لا يتم الاحتفاظ بأي نسخة احتياطية من بياناتك على أي خادم.",
            "6. الاتصال" to "fn.raadar@gmail.com"
        )
        "zh" -> listOf(
            "1. 数据隐私" to "我们的应用程序扫描或手动添加的任何数据（支出、金额、日期等）都不会发送到远程服务器。您的所有数据仅保留在您的设备上。",
            "2. 数据处理" to "“通知访问”权限用于检测银行支出通知。经过本地分析后，这些信息仅存储在您设备上的加密数据库中。",
            "3. 安全性" to "您的数据受到行业标准 AES-256 位加密 (SQLCipher) 的保护。加密密钥存储在手机的安全硬件区域 (Android Keystore) 中。",
            "4. 权限" to "应用程序仅为了履行其核心功能而请求“通知访问”权限。它不显示广告，互联网访问仅用于汇率等可选更新。",
            "5. 数据删除" to "一旦您从手机中删除该应用程序，您的所有数据将被永久销毁。服务器上不会保留您的任何数据备份。",
            "6. 联系方式" to "fn.raadar@gmail.com"
        )
        "ja" -> listOf(
            "1. データプライバシー" to "当アプリがスキャンまたは手動で追加したデータ（支出、金額、日付など）がリモートサーバーに送信されることはありません。すべてのデータはデバイス内のみに保存されます。",
            "2. データ処理" to "銀行の支出通知を検出するために「通知へのアクセス」権限が使用されます。ローカルでの分析後、この情報はデバイス内の暗号化されたデータベースにのみ保存されます。",
            "3. セキュリティ" to "データは業界標準のAES-256ビット暗号化（SQLCipher）で保護されています。暗号化キーはスマートフォンの安全なハードウェア領域（Android Keystore）に保存されます。",
            "4. 権限" to "アプリは、その主要な機能を実行するためにのみ「通知へのアクセス」権限をリクエストします。広告は表示されず、インターネットアクセスは為替レートなどのオプションの更新にのみ使用されます。",
            "5. データの削除" to "スマートフォンからアプリを削除すると、すべてのデータが完全に破棄されます。サーバー上にお客様のデータのバックアップが保持されることはありません。",
            "6. お問い合わせ" to "fn.raadar@gmail.com"
        )
        "ru" -> listOf(
            "1. Конфиденциальность данных" to "Никакие данные, отсканированные или добавленные вручную нашим приложением (расходы, суммы, даты и т. д.), никогда не отправляются на удаленный сервер. Все ваши данные хранятся только на вашем устройстве.",
            "2. Обработка данных" to "Разрешение «Доступ к уведомлениям» используется для обнаружения уведомлений о банковских расходах. После локального анализа эта информация сохраняется только в зашифрованной базе данных на вашем устройстве.",
            "3. Безопасность" to "Ваши данные защищены с помощью отраслевого стандарта шифрования AES-256 (SQLCipher). Ключ шифрования хранится в защищенной аппаратной области вашего телефона (Android Keystore).",
            "4. Разрешения" to "Приложение запрашивает разрешение «Доступ к уведомлениям» только для выполнения своих основных функций. Оно не показывает рекламу, а доступ в Интернет используется только для дополнительных обновлений, таких как курсы валют.",
            "5. Удаление данных" to "Как только вы удаляете приложение со своего телефона, все ваши данные безвозвратно уничтожаются. Никакие резервные копии ваших данных не хранятся ни на одном сервере.",
            "6. Контакты" to "fn.raadar@gmail.com"
        )
        else -> listOf(
            "1. Data Privacy" to "No data scanned or manually added by our app (expenses, amounts, dates, etc.) is ever sent to a remote server. All your data stays only on your device.",
            "2. Data Processing" to "'Notification Access' permission is used to detect bank spending notifications. After local analysis, this information is stored only in the encrypted database on your device.",
            "3. Security" to "Your data is protected with industry-standard AES-256 bit encryption (SQLCipher). The encryption key is stored in your phone's secure hardware area (Android Keystore).",
            "4. Permissions" to "The app requests 'Notification Access' permission only to perform its core functions. It does not show ads, and internet access is used only for optional updates like exchange rates.",
            "5. Data Deletion" to "Your data is permanently destroyed as soon as you delete the app from your phone. No backup of your data is kept on any server.",
            "6. Contact" to "fn.raadar@gmail.com"
        )
    }
}
